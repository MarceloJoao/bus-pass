package io.transportproject.Transport.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDocumentRequest {

    @NotBlank
    private String fileName;

    @NotBlank
    private String filePath;
}