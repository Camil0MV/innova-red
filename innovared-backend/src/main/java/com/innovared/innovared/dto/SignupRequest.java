package com.innovared.innovared.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupRequest {
    @NotBlank(message = "El id no puede estar vacío")
    private String id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String firstName;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String lastName;

    @NotBlank(message = "El país es obligatoria")
    private String country;

    @NotBlank(message = "El departamento o provincia es obligatorio/a")
    private String departmentProvince;

    @NotBlank(message = "La ciudad es obligatoria")
    private String city;

    @Email(message = "El correo no es válido")
    @NotBlank(message = "El correo no puede estar vacío")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}
