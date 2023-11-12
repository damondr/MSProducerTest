package org.damon.st.producer.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private int code;
    private String message;
    private Long id;

    public UserResponseDto(int code, String message) {
    }
}
