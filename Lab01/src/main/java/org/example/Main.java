package org.example;

import lombok.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 2 - object creation:");
        Profession solider = Profession.builder()
                .name("Żołnierz")
                .yearsOfexperience(10)
                .build();
        Profession priest = Profession.builder()
                .name("Kleryk")
                .yearsOfexperience(5)
                .build();
        Profession criminal = Profession.builder()
                .name("Łotr")
                .yearsOfexperience(7)
                .build();

        List<Profession> professions = List.of(solider, priest, criminal);

        Character solider1 = Character.builder()
                .name("Jan")
                .level(5)
                .profession(solider)
                .build();
        solider.getCharacters().add(solider1);

        Character solider2 = Character.builder()
                .name("Paweł")
                .level(3)
                .profession(solider)
                .build();
        solider.getCharacters().add(solider2);

        Character priest1 = Character.builder()
                .name("Grzegorz")
                .level(7)
                .profession(priest)
                .build();
        priest.getCharacters().add(priest1);

        Character criminal1 = Character.builder()
                .name("Andrzej")
                .level(10)
                .profession(criminal)
                .build();
        criminal.getCharacters().add(criminal1);

        professions.forEach(profession -> {
            System.out.println(profession.getName() + " characters:");
            profession.getCharacters().forEach(character -> System.out.println(character.toString()));
        });

        System.out.println("\n");
        System.out.println("Task 3 - set: creation and printing");
        Set<Character> characters = professions.stream()
                .flatMap(profession -> profession.getCharacters().stream())
                .collect(Collectors.toSet());
        characters.forEach(character -> System.out.println(character.toString()));

        System.out.println("\n");
        System.out.println("Task 4 - filtering and sorting");
        final int filteringLevel = 5;
        characters.stream().filter(character -> character.getLevel() > filteringLevel)
                .sorted(Comparator.comparing(Character::getName))
                .forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Task 5 - transforming and sorting");
        val charactersDTO = characters.stream().map(CharacterDTO::new)
                .sorted()
                .toList();
        charactersDTO.forEach(System.out::println);

        System.out.println("\n");
        System.out.println("Task 6 - serialization and deserialization to binary file");

        // serialize
        try {
            val fileOutputStream = new FileOutputStream("professions.bin");
            val objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(professions);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // deserialize
        try {
            val fileInputStream = new FileInputStream("professions.bin");
            val objectInputStream = new ObjectInputStream(fileInputStream);
            val professionsDeserialized = (List<Profession>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

            professionsDeserialized.forEach(profession -> {
                System.out.println(profession.getName() + " characters:");
                profession.getCharacters().forEach(character -> System.out.println(character.toString()));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n");
        System.out.println("Task 7 - parallel processing");
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.submit(() -> characters.stream().toList().parallelStream().forEach(character -> {
            try {
                Random r = new Random();
                Thread.sleep(r.nextInt(1,5) * 500);
                System.out.println(character);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })).join();
        forkJoinPool.shutdown();
    }
}

