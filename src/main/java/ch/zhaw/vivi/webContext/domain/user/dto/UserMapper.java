package ch.zhaw.vivi.webContext.domain.user.dto;

import ch.zhaw.vivi.webContext.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

/**
 * Mapper for the entity- and dto-class user.
 * 
 * @author Yves Kaufmann
 *
 */
@Mapper(componentModel="spring", unmappedTargetPolicy=ReportingPolicy.IGNORE)
public interface UserMapper {
	
	User fromDTO(UserDTO userDTO);

	UserDTO toDTO(User user);

	List<User> fromDTOs(List<UserDTO> userDTOs);

	List<UserDTO> toDTOs(List<User> users);
	
	Set<User> fromDTOs(Set<User> userDTOs);
	
	Set<UserDTO> toDTOs(Set<User> users);
	
}
