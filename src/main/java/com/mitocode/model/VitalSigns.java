package com.mitocode.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "vital_signs")
public class VitalSigns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(nullable = false)
    private LocalDateTime date;
    @Column(nullable = false)
    private String temperature;
    @Column(nullable = false)
    private String pulse;
    @Column(nullable = false, name = "respiratory_rate")
    private String respiratoryRate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;
}
