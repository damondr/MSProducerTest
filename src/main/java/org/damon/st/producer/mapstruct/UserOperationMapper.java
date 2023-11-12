package org.damon.st.producer.mapstruct;

import org.damon.st.producer.dto.UserOperationDto;
import org.damon.st.producer.model.User;
import org.damon.st.producer.utils.UserOperation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface UserOperationMapper {

    UserOperationDto toDto(User user, UserOperation operation);
}
