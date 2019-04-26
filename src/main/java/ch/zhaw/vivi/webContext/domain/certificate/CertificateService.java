package ch.zhaw.vivi.webContext.domain.certificate;

import ch.zhaw.vivi.config.generic.ExtendedService;

/**
 * This interface holds all data access related methods targeted towards the
 * entity certificate.
 *
 * @author Yves Kaufmann
 */
public interface CertificateService extends ExtendedService<Certificate> {

    public Certificate generate(Certificate certificate);
}
