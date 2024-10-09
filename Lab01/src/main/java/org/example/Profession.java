package org.example;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class Profession implements Serializable {
    String name;
    int yearsOfexperience;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Builder.Default
    final List<Character> characters = new ArrayList<>();
}