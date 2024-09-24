package com.example.collab.repository;

import com.example.collab.model.Document;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class DocumentRepository {

    private final RedisTemplate<String, Object> redisTemplate; // Object로 변경
    private HashOperations<String, String, Object> hashOperations; // Object로 변경

    @Autowired
    public DocumentRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void save(Document document) {
        hashOperations.put("DOCUMENT", document.getId(), document);
    }

    public Document findById(String id) {
        return (Document) hashOperations.get("DOCUMENT", id); // 캐스팅 필요
    }

    public void delete(String id) {
        hashOperations.delete("DOCUMENT", id);
    }
}
