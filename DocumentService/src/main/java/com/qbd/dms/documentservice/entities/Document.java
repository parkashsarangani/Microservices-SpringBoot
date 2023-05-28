package com.qbd.dms.documentservice.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Document")
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private Long userId;

}
