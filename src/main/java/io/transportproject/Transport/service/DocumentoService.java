package io.transportproject.Transport.service;

import io.transportproject.Transport.entity.Documento;
import io.transportproject.Transport.entity.StatusDocumento;
import io.transportproject.Transport.entity.User;
import io.transportproject.Transport.repository.DocumentoRepository;
import io.transportproject.Transport.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final UserRepository userRepository;

    public Documento criar(Long userId, Documento documento) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        documento.setUsuario(user);
        documento.setStatus(StatusDocumento.PENDENTE);

        return documentoRepository.save(documento);
    }

    public List<Documento> listarPorUsuario(Long userId) {
        return documentoRepository.findByUsuarioId(userId);
    }

    public Documento aprovar(Long id) {
        Documento doc = documentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        doc.setStatus(StatusDocumento.APROVADO);
        return documentoRepository.save(doc);
    }

    public Documento rejeitar(Long id) {
        Documento doc = documentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

        doc.setStatus(StatusDocumento.REJEITADO);
        return documentoRepository.save(doc);
    }
}
