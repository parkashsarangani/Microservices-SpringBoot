package com.qdb.dms.integration.postintegrationservice.external.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Document {
    @Id
    private Long id;
    private String name;
    private Long userId;
}
