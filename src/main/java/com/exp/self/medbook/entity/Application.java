package com.exp.self.medbook.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "APPLICATION")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "application_seq")
    @SequenceGenerator(name = "application_seq", sequenceName = "APPLICATION_SEQ", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false, foreignKey = @ForeignKey(name = "FK_APPLICATION_ACCOUNT_ID"))
    private Account account;

    @Column(name = "CREATE_DATE", nullable = false)
    private OffsetDateTime createDate;

    @Column(name = "IS_DELETED", nullable = false)
    private boolean isDeleted;

}
