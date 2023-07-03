package com.example.CustomerService.controller;

import com.example.CustomerService.dto.ResponseDTO;
import com.example.CustomerService.dto.SignupDTO;
import com.example.CustomerService.repository.UserRepository;
import com.example.CustomerService.service.SignupService;
import com.example.CustomerService.util.StringList;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SignupController {

    private final UserRepository userRepository;
    private final SignupService signupService;
    ResponseDTO responseDTO = new ResponseDTO();

    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO> signup(@RequestBody SignupDTO signupDTO){

        try{
            if(userRepository.findByEmail(signupDTO.getEmail()).isPresent()){
                return ResponseEntity.badRequest().body(
                        ResponseDTO.builder()
                                .code(StringList.RSP_DUPLICATED)
                                .message("Username is already taken")
                                .build()
                );
            }
            else{
                return ResponseEntity.ok().body(
                        signupService.signup(signupDTO)
                );
            }

        }catch (Exception e){
            responseDTO.setCode(StringList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return ResponseEntity.badRequest().body(null);
        }
    }

}
