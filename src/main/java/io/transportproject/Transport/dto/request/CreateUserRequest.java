package io.transportproject.Transport.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank(message = "Nome é obrigatório")
    private String name;

    @Email(message = "Email inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;
}