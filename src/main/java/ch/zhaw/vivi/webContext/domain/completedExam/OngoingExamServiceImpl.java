package ch.zhaw.vivi.webContext.domain.completedExam;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;
import ch.zhaw.vivi.webContext.domain.certificate.Certificate;
import ch.zhaw.vivi.webContext.domain.certificate.CertificateRepository;
import ch.zhaw.vivi.webContext.domain.certificate.CertificateService;
import ch.zhaw.vivi.webContext.domain.givenResponse.GivenResponse;
import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOption;
import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class implements the service-interface which holds all data access related methods targeted towards the
 * entity completedExam.
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
	public void addGivenResponseById(OngoingExam ongoingExam, ResponseOption responseOption){

		//TODO Check if principal user is the user from the ongoingExam.
		GivenResponse response = new GivenResponse(responseOption);
		Set<GivenResponse> responses = ongoingExam.getGivenResponses();

		// check if this response was already given before
		if (replyIsNew(responses, response)) {
			responses.add(response);
			ongoingExam.setScore((response.calculateScore()));

			repository.save(ongoingExam);
		}
	}

	@Override
	public void completeExam(OngoingExam ongoingExam){
		//TODO Check if principal user is the user from the ongoingExam.
		ongoingExam.setEndTime(LocalTime.now());
		ongoingExam.setPassed(ongoingExam.isPassed());

		// check if ongoingExam is passed, so a certificate gets generated
		if (ongoingExam.isPassed()){
			Certificate certificate = new Certificate(ongoingExam.getUser());
			ongoingExam.setCertificate(certificate);
			ongoingExam.setCompleted(true);
			// save certificate and generate the issueDate.
			certificateService.generate(certificate);
		}

		repository.save(ongoingExam);
	}

	public boolean replyIsNew(Set<GivenResponse> responses, GivenResponse response){

		for (GivenResponse r:responses) {
			if(r.getResponseOption().getId().equals(response.getResponseOption().getId()))
				return false;
		}
		return true;
	}

}
