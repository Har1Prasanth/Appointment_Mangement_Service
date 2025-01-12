package com.booking.appointment_management_service.api.user;

import com.booking.appointment_management_service.api.user.dto.Role;
import com.booking.appointment_management_service.api.user.dto.UserDto;
import com.booking.appointment_management_service.api.user.dto.UserResponseDto;
import com.booking.appointment_management_service.entity.User;
import com.booking.appointment_management_service.service.user.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Hari Prasanth
 */
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Data
@Slf4j
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto){

        User user= userService.registerUser(modelMapper.map(userDto, User.class));
        if(user!=null){
        return ResponseEntity.ok("User registered successfully");
        }else {
            return ResponseEntity.badRequest().body("User registration failed");
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDto> getUserByEmail(@PathVariable("email") String email){

        User user = userService.getUserByEmail(email);
        UserResponseDto userResponseDto = modelMapper.map(user, UserResponseDto.class);
        return ResponseEntity.ok(userResponseDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> getAllUsers(
            @RequestParam(required = false) Role role
    ){
        List<User> users;
        if(role != null){
            users = userService.getAllUsersByRole(role);
        }else{
            users = userService.getAllUsers();
        }

        List<UserResponseDto> userResponseDtoList =users.stream()
                .map(user -> new UserResponseDto( user.getName(), user.getEmail(), user.getRole()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(userResponseDtoList);

    }
}
