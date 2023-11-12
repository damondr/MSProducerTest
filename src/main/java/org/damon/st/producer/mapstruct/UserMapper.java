package org.damon.st.producer.mapstruct;

import org.damon.st.producer.dto.UserDto;
import org.damon.st.producer.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User entity);
    User toEntity(UserDto dto);
}
