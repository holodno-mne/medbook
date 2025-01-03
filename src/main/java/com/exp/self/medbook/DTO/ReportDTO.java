package com.exp.self.medbook.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ReportDTO {
    private Long id;
    private String title;
    private String description;
}
