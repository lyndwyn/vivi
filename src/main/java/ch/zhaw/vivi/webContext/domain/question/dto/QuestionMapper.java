package ch.zhaw.vivi.webContext.domain.question.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.zhaw.vivi.webContext.domain.question.Question;

/**
 * Mapper for the entity- and dto-class question.
 * 
 * @author Yves Kaufmann
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface QuestionMapper {
	
	Question fromDTO(QuestionDTO questionDTO);
	
	QuestionDTO toDTO(Question question);

	List<Question> fromDTOs(List<QuestionDTO> questionDTOs);
	
	List<QuestionDTO> toDTOs(List<Question> questions);
	
	Set<Question> fromDTOs(Set<Question> questionDTOs);
	
	Set<QuestionDTO> toDTOs(Set<Question> questions);
	
}
