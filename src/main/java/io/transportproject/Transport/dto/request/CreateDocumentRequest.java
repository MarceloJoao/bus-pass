package io.transportproject.Transport.dto.request;

import io.transportproject.Transport.entity.DocumentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateDocumentRequest {

    @NotBlank
    private String fileName;

    @NotBlank
    private String filePath;

    @Enumerated(EnumType.STRING)
    private DocumentType type;
}