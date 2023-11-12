package org.damon.st.producer.config;

import lombok.RequiredArgsConstructor;
import org.damon.st.producer.dto.UserDto;
import org.damon.st.producer.dto.UserOperationDto;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    private final ConnectionFactory connectionFactory;
    private final ApplicationProperties applicationProperties;

    @Bean
    public Exchange userInfoExchange() {
        return new DirectExchange(applicationProperties.getRabbit().getExchangeName());
    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return createTemplate();
    }

    private RabbitTemplate createTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

}