package com.szymonowicz.projekt.dto;

import com.szymonowicz.projekt.validators.PasswordMatches;
import com.szymonowicz.projekt.validators.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PasswordMatches
public class AuthorDTO {
    @NotNull
    @Size(min = 1, message = "Too short first name")
    private String firstName;

    @NotNull
    @Size(min = 1, message = "Too short last name")
    private String lastName;

    @NotNull
    @Size(min = 6, message = "Too short username, at least 6 characters")
    private String username;

    @ValidPassword
    private String password;

    @NotNull
    private String matchingPassword;

//    @NotNull
//    @NotEmpty
//    private String email;
}
