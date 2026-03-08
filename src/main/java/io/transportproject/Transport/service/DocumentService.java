package io.transportproject.Transport.service;

import io.transportproject.Transport.dto.request.CreateDocumentRequest;
import io.transportproject.Transport.dto.response.DocumentResponse;
import io.transportproject.Transport.entity.Document;
import io.transportproject.Transport.entity.DocumentStatus;
import io.transportproject.Transport.entity.DocumentType;
import io.transportproject.Transport.entity.User;
import io.transportproject.Transport.repository.DocumentRepository;
import io.transportproject.Transport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final UserRepository userRepository;

    public DocumentResponse create(Long userId, CreateDocumentRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Document document = new Document();
        document.setUser(user);
        document.setType(request.getType());
        document.setFileName(request.getFileName());
        document.setFilePath(request.getFilePath());
        document.setStatus(DocumentStatus.PENDENTE);

        Document saved = documentRepository.save(document);

        return mapToResponse(saved);
    }

    public List<DocumentResponse> listByUser(Long userId) {
        return documentRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public DocumentResponse approve(Long id) {

        Document doc = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        doc.setStatus(DocumentStatus.APROVADO);

        return mapToResponse(documentRepository.save(doc));
    }

    public DocumentResponse reject(Long id) {

        Document doc = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        doc.setStatus(DocumentStatus.REJEITADO);

        return mapToResponse(documentRepository.save(doc));
    }

    public DocumentResponse update(Long id, CreateDocumentRequest request) {

        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        existingDocument.setFileName(request.getFileName());
        existingDocument.setType(request.getType());
        existingDocument.setFilePath(request.getFilePath());
        existingDocument.setStatus(DocumentStatus.PENDENTE);

        Document saved = documentRepository.save(existingDocument);

        return mapToResponse(saved);
    }

    public DocumentResponse delete(Long id) {

        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        documentRepository.delete(existingDocument);

        return mapToResponse(existingDocument);
    }

    public List<DocumentResponse> listPending() {

        return documentRepository.findByStatus(DocumentStatus.PENDENTE)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<DocumentResponse> listByType(DocumentType type) {

        return documentRepository.findByType(type)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private DocumentResponse mapToResponse(Document document) {
        return DocumentResponse.builder()
                .id(document.getId())
                .userId(document.getUser().getId())
                .type(document.getType())
                .fileName(document.getFileName())
                .filePath(document.getFilePath())
                .status(document.getStatus())
                .build();
    }
}