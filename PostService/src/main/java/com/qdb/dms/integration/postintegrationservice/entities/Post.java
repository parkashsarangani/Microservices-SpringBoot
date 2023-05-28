package com.qdb.dms.integration.postintegrationservice.entities;

import com.qdb.dms.integration.postintegrationservice.external.models.Document;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "POST")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private long documentId;
    @Column
    private long userId;
    @Column
    private String title;
    @Column
    private String body;

}
