package com.example.entities;

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
@Table(name = "characters")
public class Character {

    @Id
    @ToString.Exclude
    @Builder.Default
    @Column(name = "character_id", nullable = false)
    private UUID id = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "level")
    private int level;

    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;
}
