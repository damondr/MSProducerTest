package org.damon.st.producer.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.damon.st.producer.dto.UserDto;
import org.damon.st.producer.dto.UserResponseDto;
import org.damon.st.producer.mapstruct.UserMapper;
import org.damon.st.producer.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {
    private final UsersService usersService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody @Valid UserDto userDTO) {
        Long userId = usersService.createUser(userMapper.toEntity(userDTO));
        return ResponseEntity.ok(new UserResponseDto(0,"User creation request accepted.", userId));
    }

    @PutMapping
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody @Valid UserDto userDTO) {
        Long userId = usersService.updateUser(userMapper.toEntity(userDTO));
        return ResponseEntity.ok(new UserResponseDto(0,"User update request accepted.", userId));
    }

    @DeleteMapping
    public ResponseEntity<UserResponseDto> deleteUser(@RequestBody @Valid UserDto userDTO) {
        Long userId = usersService.deleteUser(userMapper.toEntity(userDTO));
        return ResponseEntity.ok(new UserResponseDto(0,"User deletion request accepted.", userId));
    }

}