package com.exp.self.medbook.dto;

import lombok.*;


@Builder
@Getter
@Setter
public record ReportDTO(
        Long id,
        String title,
        String description) {

}
