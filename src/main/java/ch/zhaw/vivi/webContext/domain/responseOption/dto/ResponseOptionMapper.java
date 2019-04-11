package ch.zhaw.vivi.webContext.domain.responseOption.dto;

import java.util.List;
import java.util.Set;

import ch.zhaw.vivi.webContext.domain.responseOption.ResponseOption;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


/**
 * Mapper for the entity- and dto-class responseOption.
 * @author Yves Kaufmann
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface ResponseOptionMapper {
	
	ResponseOption fromDTO(ResponseOptionDTO responseOptionDTO);
	
	ResponseOptionDTO toDTO(ResponseOption responseOption);

	List<ResponseOption> fromDTOs(List<ResponseOptionDTO> responseOptionDTOs);
	
	List<ResponseOptionDTO> toDTOs(List<ResponseOption> responseOptions);
	
	Set<ResponseOption> fromDTOs(Set<ResponseOption> responseOptionDTOs);
	
	Set<ResponseOptionDTO> toDTOs(Set<ResponseOption> responseOptions);
	
}
