package com.example.ProfessionService.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Builder
@Table(name = "professions")
public class Profession {

    @Id
    @ToString.Exclude
    @Builder.Default
    @Column(name = "profession_id", nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "years_of_experience")
    private int yearsOfExperience;

}
