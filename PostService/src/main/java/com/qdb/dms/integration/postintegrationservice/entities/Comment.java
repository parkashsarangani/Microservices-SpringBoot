package com.qdb.dms.integration.postintegrationservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "COMMENT")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private long postId;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String body;
}
