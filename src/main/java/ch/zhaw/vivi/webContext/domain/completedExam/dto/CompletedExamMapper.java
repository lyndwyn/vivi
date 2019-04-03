package ch.zhaw.vivi.webContext.domain.completedExam.dto;

import ch.zhaw.vivi.webContext.domain.completedExam.CompletedExam;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

/**
 * Mapper for the entity- and dto-class completedExam.
 * 
 * @author Yves Kaufmann
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface CompletedExamMapper {
	
	CompletedExam fromDTO(CompletedExamDTO completedExamDTO);

	CompletedExamDTO toDTO(CompletedExam completedExam);

	List<CompletedExam> fromDTOs(List<CompletedExamDTO> completedExamDTOs);

	List<CompletedExamDTO> toDTOs(List<CompletedExam> completedExams);
	
	Set<CompletedExam> fromDTOs(Set<CompletedExam> completedExamDTOs);
	
	Set<CompletedExamDTO> toDTOs(Set<CompletedExam> completedExams);
	
}
