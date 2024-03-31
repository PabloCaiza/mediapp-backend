package com.mitocode.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalSignsDTO {
    private Integer id;
    @NotNull
    private LocalDateTime date;
    @NotNull
    private String temperature;
    @NotNull
    private String pulse;
    @NotNull
    private String respiratoryRate;
    @NotNull
    private PatientDTO patient;
}
