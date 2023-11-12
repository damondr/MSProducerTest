package org.damon.st.producer.service.impl;

import lombok.RequiredArgsConstructor;
import org.damon.st.producer.config.ApplicationProperties;
import org.damon.st.producer.mapstruct.UserOperationMapper;
import org.damon.st.producer.model.User;
import org.damon.st.producer.service.UsersService;
import org.damon.st.producer.utils.UserOperation;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final ApplicationProperties applicationProperties;
    private final RabbitTemplate rabbitTemplate;
    private final UserOperationMapper userOperationMapper;

    public Long createUser(User user) {
        return processUserOperation(UserOperation.CREATE, user);
    }

    public Long updateUser(User user) {
        return processUserOperation(UserOperation.UPDATE, user);
    }

    public Long deleteUser(User user) {
        return processUserOperation(UserOperation.DELETE, user);
    }

    private Long processUserOperation(UserOperation operation, User user) {
        sendUserOperationToQueue(operation, user);
        return user.getId();
    }

    private void sendUserOperationToQueue(UserOperation operation, User user) {
        rabbitTemplate.convertAndSend(
                applicationProperties.getRabbit().getExchangeName(),
                applicationProperties.getRabbit().getRoutingKey(),
                userOperationMapper.toDto(user, operation)
        );
    }
}