package com.qdb.dms.integration.postintegrationservice.entities;

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
    private long userId;
    private long documentId;
    @Column
    private String title;
    @Column
    private String body;
}
