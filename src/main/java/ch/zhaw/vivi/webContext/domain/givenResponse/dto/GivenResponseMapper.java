package ch.zhaw.vivi.webContext.domain.givenResponse.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.zhaw.vivi.webContext.domain.givenResponse.GivenResponse;



/**
 * Mapper for the entity- and dto-class givenResponse.
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface GivenResponseMapper {

    GivenResponse fromDTO(GivenResponseDTO givenResponseDTO);

    GivenResponseDTO toDTO(GivenResponse givenResponse);

    List<GivenResponse> fromDTOs(List<GivenResponseDTO> givenResponseDTOs);

    List<GivenResponseDTO> toDTOs(List<GivenResponse> givenResponses);

    Set<GivenResponse> fromDTOs(Set<GivenResponse> givenResponseDTOs);

    Set<GivenResponseDTO> toDTOs(Set<GivenResponse> givenResponses);

}