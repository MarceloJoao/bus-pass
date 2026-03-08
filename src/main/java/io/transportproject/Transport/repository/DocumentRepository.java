package io.transportproject.Transport.repository;

import io.transportproject.Transport.entity.Document;
import io.transportproject.Transport.entity.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findByUserId(Long userId);

    List<Document> findByStatus(DocumentStatus status);

}
