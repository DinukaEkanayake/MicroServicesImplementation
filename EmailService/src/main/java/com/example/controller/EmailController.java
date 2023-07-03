package com.example.controller;

import com.example.dto.ResponseDTO;
import com.example.dto.SignupDTO;
import com.example.repository.EmailRepository;
import com.example.service.MailService;
import com.example.util.StringList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class EmailController {

    private final EmailRepository emailRepository;
    private final MailService mailService;
    ResponseDTO responseDTO = new ResponseDTO();

    @GetMapping("/sendemail")
    public ResponseEntity<ResponseDTO> sendEmail(@RequestParam String email ){

        try{
                return ResponseEntity.ok().body(mailService.send(email));

        }catch (Exception e){
            responseDTO.setCode(StringList.RSP_ERROR);
            responseDTO.setMessage(e.getMessage());
            responseDTO.setContent(e);
            return ResponseEntity.badRequest().body(null);
        }
    }

}
