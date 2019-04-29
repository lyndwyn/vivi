package ch.zhaw.vivi.webContext.domain.ongoingExam;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;
import ch.zhaw.vivi.webContext.domain.certificate.Certificate;
import ch.zhaw.vivi.webContext.domain.certificate.CertificateService;
import ch.zhaw.vivi.webContext.domain.givenResponse.GivenResponse;
import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOption;
import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOptionService;
import ch.zhaw.vivi.webContext.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Set;

/**
 * This class implements the service-interface which holds all data access related methods targeted towards the
 * entity ongoingExam.
 * 
 * @author Yves Kaufmann
 *
 */
@Service
public class OngoingExamServiceImpl extends ExtendedServiceImpl<OngoingExam> implements OngoingExamService {

	ResponseOptionService responseOptionService;

	CertificateService certificateService;

	@Autowired
	public OngoingExamServiceImpl(OngoingExamRepository repository, ResponseOptionService responseOptionService, CertificateService certificateService) {
		super(repository);
		this.responseOptionService = responseOptionService;
		this.certificateService = certificateService;
	}

	@Override
	public ResponseOption findResponseOptionById(Long id){
		return responseOptionService.findById(id);
	}

	@Override
	public void addGivenResponseById(OngoingExam ongoingExam, ResponseOption responseOption) throws IllegalAccessException {

		//validate if the currently logged in user is the defined user for the ongoingExam.
		System.out.println(validatePrincipal(ongoingExam.getUser()));
		if (validatePrincipal(ongoingExam.getUser())){
			GivenResponse response = new GivenResponse(responseOption);
			Set<GivenResponse> responses = ongoingExam.getGivenResponses();

			// check if this response was already given before
			if (replyIsNew(responses, response)) {
				responses.add(response);
				ongoingExam.setScore((response.calculateScore()));

				repository.save(ongoingExam);
			}else{
				throw new IllegalAccessException();
			}
		}else{
			throw new SecurityException();
		}
	}

	@Override
	public void completeExam(OngoingExam ongoingExam) {

		//validate if the currently logged in user is the defined user for the ongoingExam.
		if (validatePrincipal(ongoingExam.getUser())) {
			ongoingExam.setEndTime(LocalTime.now());
			ongoingExam.setPassed(ongoingExam.isPassed());

			// check if ongoingExam is passed, so a certificate gets generated
			if (ongoingExam.isPassed()) {
				Certificate certificate = new Certificate(ongoingExam.getUser());
				ongoingExam.setCertificate(certificate);
				ongoingExam.setCompleted(true);
				// save certificate and generate the issueDate.
				certificateService.generate(certificate);
			}

			repository.save(ongoingExam);
		}else{
			throw new SecurityException();
		}
	}

	private boolean validatePrincipal(User user) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String principalUsername = ((UserDetails)principal).getUsername();
		String principalPassword = ((UserDetails)principal).getPassword();

		if(principalUsername.equals(user.getUsername()) && principalPassword.equals(user.getPassword())){
			return true;
		}
		return false;
	}

	public boolean replyIsNew(Set<GivenResponse> responses, GivenResponse response){

		for (GivenResponse r:responses) {
			if(r.getResponseOption().getId().equals(response.getResponseOption().getId()))
				return false;
		}
		return true;
	}

}
