package com.motivici.customerservices.model.request;


import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class CreateUserRequestModel {
    @NotNull(message="firsName cannot null")
    private String firstName;
    @NotNull(message="lastName cannot null")
    private String lastName;
    @NotNull(message="email cannot null")
    @Size(min = 8,max = 50, message = "email 8-50 character")
    @Email
    private String email;
    @NotNull(message="userId cannot null")
    private String userId;

}
