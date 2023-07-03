package com.example.CustomerService.service;

import com.example.CustomerService.dto.ResponseDTO;
import com.example.CustomerService.dto.SignupDTO;
import com.example.CustomerService.entity.Role;
import com.example.CustomerService.entity.User;
import com.example.CustomerService.repository.UserRepository;
import com.example.CustomerService.util.StringList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class SignupServiceImplementation implements SignupService{

      private final UserRepository userRepository;
      private final RestTemplate restTemplate;

    @Override
    public ResponseDTO signup(SignupDTO signupDTO){

            var user= User.builder()
                    .Fname(signupDTO.getFname())
                    .Lname(signupDTO.getLname())
                    .email(signupDTO.getEmail())
                    .Password(signupDTO.getPassword())
                    .role(Role.USER)
                    .build();
            userRepository.save(user);
            ResponseEntity<com.example.dto.ResponseDTO> response = restTemplate.getForEntity("http://localhost:8081/api/v1/auth/sendemail?email="+user.getEmail(),
                    com.example.dto.ResponseDTO.class);
            return ResponseDTO.builder()
                    .code(StringList.RSP_SUCCESS)
                    .content(user)
                    .message("Registration success!Verification Email Sent!")
                    .build();
    }

}
