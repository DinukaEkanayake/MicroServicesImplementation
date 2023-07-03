package com.example.CustomerService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SignupDTO {
    private String Email;
    private String Fname;
    private String Lname;
    private String Password;
    private String confPass;

}
