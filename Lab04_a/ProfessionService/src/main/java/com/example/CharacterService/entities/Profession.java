package com.example.CharacterService.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;

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
