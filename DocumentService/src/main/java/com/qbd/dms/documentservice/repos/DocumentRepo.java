package com.qbd.dms.documentservice.repos;

import com.qbd.dms.documentservice.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.List;

@Repository
public interface DocumentRepo extends JpaRepository<Document, Long> {
    public List<Document> findAllByUserId(long userId);
}
