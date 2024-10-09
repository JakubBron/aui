package org.example;

import lombok.*;

@Value
public class CharacterDTO implements Comparable<CharacterDTO> {
    String name;
    int level;
    String professionName;

    public CharacterDTO(Character c) {
        this.name = c.getName();
        this.level = c.getLevel();
        this.professionName = c.getProfession().getName();
    }

    @Override
    public int compareTo(CharacterDTO o) {
        if (this.name.compareTo(o.name) != 0) {
            return this.name.compareTo(o.name);
        }
        else if (this.level != o.level) {
            return this.level - o.level;
        }
        else {
            return this.professionName.compareTo(o.professionName);
        }
    }
}
