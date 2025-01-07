package com.exp.self.medbook.dto;

import lombok.*;

import java.time.OffsetDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApplicationDTO {
    private Long id;
    private OffsetDateTime createDate;
    private boolean isDeleted;
}
