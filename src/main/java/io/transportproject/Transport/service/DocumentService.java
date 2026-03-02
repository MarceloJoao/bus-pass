package io.transportproject.Transport.service;

import io.transportproject.Transport.entity.Document;
import io.transportproject.Transport.entity.DocumentStatus;
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

    public Document create(Long userId, Document document) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        document.setUser(user);
        document.setStatus(DocumentStatus.PENDENTE);

        return documentRepository.save(document);
    }

    public List<Document> listByUser(Long userId) {
        return documentRepository.findByUserId(userId);
    }

    public Document approve(Long id) {
        Document doc = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        doc.setStatus(DocumentStatus.APROVADO);
        return documentRepository.save(doc);
    }

    public Document reject(Long id) {
        Document doc = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        doc.setStatus(DocumentStatus.REJEITADO);
        return documentRepository.save(doc);
    }

    public Document update(Long id, Document updatedDocumentData) {
        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found with ID: " + id));

        existingDocument.setFileName(updatedDocumentData.getFileName());
        existingDocument.setFilePath(updatedDocumentData.getFilePath());
        existingDocument.setStatus(DocumentStatus.PENDENTE); // Reseta o status para PENDENTE após atualização

        return documentRepository.save(existingDocument);
    }

    public Document delete(Long id) {
        Document existingDocument = documentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Document not found with ID: " + id));

        documentRepository.delete(existingDocument);
        return existingDocument;
    }
}
