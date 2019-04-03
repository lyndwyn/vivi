package ch.zhaw.vivi.webContext.domain.certificate;

import ch.zhaw.vivi.config.generic.ExtendedServiceImpl;
import org.springframework.stereotype.Service;

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
	
}
