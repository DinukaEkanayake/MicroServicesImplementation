package com.example.CustomerService.service;

import com.example.CustomerService.dto.ResponseDTO;
import com.example.CustomerService.dto.SignupDTO;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public interface SignupService {

    ResponseDTO signup(SignupDTO signupDTO) throws MessagingException, UnsupportedEncodingException;

}
