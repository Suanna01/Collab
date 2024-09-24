package com.example.collab.service;

import com.example.collab.model.Document;
import com.example.collab.repository.DocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public void createOrUpdateDocument(Document document) {
        documentRepository.save(document);
    }

    public Document getDocument(String id) {
        return documentRepository.findById(id);
    }
}
