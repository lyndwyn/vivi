package ch.zhaw.vivi.webContext.domain.certificate;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * This class implements the service-interface which holds all data access related methods targeted towards the
 * entity certificate.
 * 
 * @author Yves Kaufmann
 *
 */
@Service
public class CertificateServiceImpl extends ExtendedServiceImpl<Certificate> implements CertificateService {

	public CertificateServiceImpl(CertificateRepository repository) {
		super(repository);
	}

	@Override
	public Certificate generate(Certificate certificate){

		certificate.setIssueDate(LocalDate.now());
		repository.save(certificate);

		return certificate;
	}
}
