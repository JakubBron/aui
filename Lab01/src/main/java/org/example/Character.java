package org.example;

import lombok.*;
import java.io.Serializable;

@Data
//@Builder(builderMethodName = "buildInternal")
@Builder
public class Character implements Serializable {
    String name;
    int level;
    Profession profession;

    /*public static class CharacterBuilder {
        public Character build() {
            Character character = this.buildInternal();
            character.getProfession().getCharacters().add(character);
            return character;
        }

        public void setProfession(Profession profession) {
            if(this.profession != null)
            {
                this.profession.getCharacters().remove(this);
            }
            this.profession = profession;
            profession.getCharacters().add(this);
        }
    }
    */
}