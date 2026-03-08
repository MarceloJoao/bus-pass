package io.transportproject.Transport.dto.response;

import io.transportproject.Transport.entity.DocumentStatus;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentResponse {

    private Long id;
    private Long userId;
    private String fileName;
    private String filePath;
    private DocumentStatus status;
}