package com.example.service;

import com.example.dto.ResponseDTO;
import com.example.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface MailService {
    ResponseDTO send(String email);
}
