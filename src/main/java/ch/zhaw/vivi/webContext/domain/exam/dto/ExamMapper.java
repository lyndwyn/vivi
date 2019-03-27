package ch.zhaw.vivi.webContext.domain.exam.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.zhaw.vivi.webContext.domain.exam.Exam;



/**
 * Mapper for the entity- and dto-class exam.
 * 
 * @author Yves Kaufmann
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface ExamMapper {
	
	Exam fromDTO(ExamDTO examDTO);
	
	ExamDTO toDTO(Exam exam);

	List<Exam> fromDTOs(List<ExamDTO> examDTOs);
	
	List<ExamDTO> toDTOs(List<Exam> exams);
	
	Set<Exam> fromDTOs(Set<Exam> examDTOs);
	
	Set<ExamDTO> toDTOs(Set<Exam> exams);
	
}
