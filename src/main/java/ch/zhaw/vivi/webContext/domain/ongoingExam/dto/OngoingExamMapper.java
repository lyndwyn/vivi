package ch.zhaw.vivi.webContext.domain.ongoingExam.dto;

import ch.zhaw.vivi.webContext.domain.ongoingExam.OngoingExam;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

/**
 * Mapper for the entity- and dto-class ongoingExam.
 * 
 * @author Yves Kaufmann
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface OngoingExamMapper {
	
	OngoingExam fromDTO(OngoingExamDTO ongoingExamDTO);

	OngoingExamDTO toDTO(OngoingExam ongoingExam);

	List<OngoingExam> fromDTOs(List<OngoingExamDTO> ongoingExamDTOS);

	List<OngoingExamDTO> toDTOs(List<OngoingExam> ongoingExams);
	
	Set<OngoingExam> fromDTOs(Set<OngoingExam> ongoingExamDTOS);
	
	Set<OngoingExamDTO> toDTOs(Set<OngoingExam> ongoingExams);
	
}
