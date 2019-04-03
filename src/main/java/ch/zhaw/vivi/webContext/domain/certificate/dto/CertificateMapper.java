package ch.zhaw.vivi.webContext.domain.certificate.dto;

import ch.zhaw.vivi.webContext.domain.certificate.Certificate;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

/**
 * Mapper for the entity- and dto-class certificate.
 * 
 * @author Yves Kaufmann
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface CertificateMapper {
	
	Certificate fromDTO(CertificateDTO certificateDTO);
	
	CertificateDTO toDTO(Certificate certificate);

	List<Certificate> fromDTOs(List<CertificateDTO> certificateDTOs);
	
	List<CertificateDTO> toDTOs(List<Certificate> certificates);
	
	Set<Certificate> fromDTOs(Set<Certificate> certificateDTOs);
	
	Set<CertificateDTO> toDTOs(Set<Certificate> certificates);
	
}
