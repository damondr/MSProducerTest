package org.damon.st.producer.dto;

import lombok.*;
import org.damon.st.producer.utils.UserOperation;

@Getter
@Setter
public class UserOperationDto {
    private UserOperation operation;
    private UserDto user;
}