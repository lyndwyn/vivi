package ch.zhaw.vivi.webContext.domain.answer.dto;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ch.zhaw.vivi.webContext.domain.answer.Answer;


/**
 * Mapper for the entity- and dto-class answer.
 * @author Laura Steiner
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface AnswerMapper {
	
	Answer fromDTO(AnswerDTO answerDTO);
	
	AnswerDTO toDTO(Answer answer);

	List<Answer> fromDTOs(List<AnswerDTO> answerDTOs);
	
	List<AnswerDTO> toDTOs(List<Answer> answers);
	
	Set<Answer> fromDTOs(Set<Answer> answerDTOs);
	
	Set<AnswerDTO> toDTOs(Set<Answer> answers);
	
}
