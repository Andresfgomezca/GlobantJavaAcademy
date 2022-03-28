package PasswordCracker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PassWordCracker {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> pass;
        String passwordAttempt;

        System.out.println("password");
        pass = Arrays.asList(scan.nextLine().toLowerCase().split("\\s+"));
        System.out.println("Password attempt");
        passwordAttempt = scan.nextLine().toLowerCase();

        List<String> coincidences = passWordCracker(pass, passwordAttempt);

        String coincidencesCompare = coincidences.stream().collect(Collectors.joining());

        if (coincidencesCompare.equals(passwordAttempt)) {
            System.out.println(coincidences.stream().collect(Collectors.joining(" ")));
        } else {
            System.out.println("WRONG PASSWORD");
        }


    }

    static List<String> passWordCracker(List<String> passwords, String passwordAttempt) {
        return passwords.stream()
                .filter(passwordAttempt::startsWith)
                .flatMap(password -> Stream.concat(Stream.of(password), passWordCracker(passwords, passwordAttempt.substring(password.length())).stream()))
                .collect(Collectors.toList());
    }

}