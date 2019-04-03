package ch.zhaw.vivi.webContext.domain.certificate;

import ch.zhaw.vivi.config.generic.ExtendedJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface holds all data access related methods targeted towards the
 * entity certificate.
 *
 * @author Yves Kaufmann
 */
@Repository
public interface CertificateRepository extends ExtendedJpaRepository<Certificate> {
	
}
