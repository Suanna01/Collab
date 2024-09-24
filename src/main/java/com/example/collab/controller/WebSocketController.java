package com.example.collab.controller;

import com.example.collab.model.Document;
import com.example.collab.service.DocumentService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    private final DocumentService documentService;

    public WebSocketController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @MessageMapping("/update")
    @SendTo("/topic/documents")
    public Document updateDocument(Document document) {
        documentService.createOrUpdateDocument(document);
        return document;
    }
}
