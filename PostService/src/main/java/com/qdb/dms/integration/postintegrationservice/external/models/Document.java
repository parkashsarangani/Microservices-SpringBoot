package com.qdb.dms.integration.postintegrationservice.external.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Document {
    private Long id;
    private String name;
    private Long userId;
}
