package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.boot.CommandLineRunner;
import com.example.services.character.CharacterService;
import com.example.services.profession.ProfessionService;
import com.example.entities.Character;
import com.example.entities.Profession;

import java.util.List;
import java.util.Scanner;

@Component
public class CLIRunner implements CommandLineRunner {
    private CharacterService characterService;
    private ProfessionService professionService;
    public CLIRunner(CharacterService characterService, ProfessionService professionService) {
        this.characterService = characterService;
        this.professionService = professionService;
    }

    @Override
    public void run(String... args) {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The App (TM). Type command below or type 'help' to get list of possible commands.");
        while(isRunning) {
            System.out.print("> ");
            String command = scanner.nextLine();

            switch(command) {
                case "exit" -> {
                    isRunning = false;
                }
                case "list professions" -> {
                    professionService.findAll().forEach(System.out::println);
                }
                case "list characters" -> {
                    characterService.findAll().forEach(System.out::println);
                }
                case "add character" -> {
                    System.out.println("Enter character name: ");
                    String name = scanner.nextLine();
                    if(name.isEmpty()) {
                        System.out.println("Name cannot be empty");
                        break;
                    }

                    System.out.println("Enter character age: ");
                    String ageString = scanner.nextLine();
                    if(ageString.isEmpty()) {
                        System.out.println("Age cannot be empty");
                        break;
                    }
                    if(!ageString.matches("\\d+")) {
                        System.out.println("Age must be a number");
                        break;
                    }
                    int age = Integer.parseInt(ageString);
                    if(age <= 0) {
                        System.out.println("Age must be greater than 0");
                        break;
                    }

                    System.out.println("Enter character level: ");
                    String levelString = scanner.nextLine();
                    if(levelString.isEmpty()) {
                        System.out.println("Level cannot be empty");
                        break;
                    }
                    if(!levelString.matches("\\d+")) {
                        System.out.println("Level must be a number");
                        break;
                    }
                    int level = Integer.parseInt(levelString);
                    if(level <= 0) {
                        System.out.println("Level must be greater than 0");
                        break;
                    }

                    System.out.println("Enter character profession (choose a number): ");
                    List<Profession> p = professionService.findAll();
                    for(int i = 0; i < p.size(); i++) {
                        System.out.println((i+1) + ". " + p.get(i).getName() +" "+ p.get(i).getYearsOfExperience());
                    }
                    String choiceString = scanner.nextLine();
                    if(choiceString.isEmpty()) {
                        System.out.println("Profession choice cannot be empty");
                        break;
                    }
                    if(!choiceString.matches("\\d+")) {
                        System.out.println("Profession choice must be a number");
                        break;
                    }
                    int choice = Integer.parseInt(choiceString)-1;
                    if(choice < 0 || choice >= p.size()) {
                        System.out.println("Invalid profession choice");
                        break;
                    }

                    characterService.create(Character.builder()
                            .name(name)
                            .age(age)
                            .level(level)
                            .profession(p.get(choice))
                            .build());
                    System.out.println("Character added successfully");
                }

                case "add profession" -> {
                    System.out.println("Enter profession name: ");
                    String name = scanner.nextLine();
                    if(name.isEmpty()) {
                        System.out.println("Name cannot be empty");
                        break;
                    }

                    System.out.println("Enter years of experience: ");
                    String yearsString = scanner.nextLine();
                    if(yearsString.isEmpty()) {
                        System.out.println("Years of experience cannot be empty");
                        break;
                    }
                    if(!yearsString.matches("-?[0-9]+")) {
                        System.out.println("Years of experience must be a number");
                        break;
                    }
                    int years = Integer.parseInt(yearsString);
                    if(years <= 0) {
                        System.out.println("Years of experience must be greater than 0");
                        break;
                    }

                    professionService.create(Profession.builder()
                            .name(name)
                            .yearsOfExperience(years)
                            .build());
                    System.out.println("Profession added successfully");
                }

                case "delete character" -> {
                    System.out.println("Select character to delete (choose a number): ");
                    List<Character> c = characterService.findAll();
                    for(int i = 0; i < c.size(); i++) {
                        System.out.println((i+1) + ". " + c.get(i).getName());
                    }

                    String choiceString = scanner.nextLine();
                    if(choiceString.isEmpty()) {
                        System.out.println("Character choice cannot be empty");
                        break;
                    }
                    if(!choiceString.matches("-?[0-9]+")) {
                        System.out.println("Character choice must be a number");
                        break;
                    }
                    int choice = Integer.parseInt(choiceString)-1;
                    if(choice < 0 || choice >= c.size()) {
                        System.out.println("Invalid profession choice");
                        break;
                    }

                    characterService.delete(c.get(choice).getId());
                    System.out.println("Character deleted successfully");
                }

                case "delete profession" -> {
                    System.out.println("Select profession to delete (choose a number): ");
                    List<Profession> p = professionService.findAll();
                    for(int i = 0; i < p.size(); i++) {
                        System.out.println((i+1) + ". " + p.get(i).getName());
                    }

                    int choice = Integer.parseInt(scanner.nextLine())-1;
                    if(choice <= 0 || choice >= p.size()) {
                        System.out.println("Invalid profession choice");
                        break;
                    }

                    professionService.delete(p.get(choice).getId());
                    System.out.println("Profession deleted successfully");
                }

                case "help" -> {
                    System.out.println("List of possible commands:");
                    System.out.println("exit - to close the application");
                    System.out.println("help - to display this message");
                    System.out.println("list professions - to display all professions");
                    System.out.println("list characters - to display all characters");
                    System.out.println("add character - to add a new character");
                    System.out.println("add profession - to add a new profession");
                    System.out.println("delete character - to delete a character");
                    System.out.println("delete profession - to delete a profession");
                }

                default -> {
                    System.out.println("Unknown command. Type 'help' to get list of possible commands.");
                }
            }
        }
    }

}
