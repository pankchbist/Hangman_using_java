package com.mycompany.hangmangame;
import java.util.Random;
import java.util.Scanner;
public class Hangmangame {
    private static String[] words = {"java", "hangman", "programming", "computer", "developer"};
    private static int maxAttempts = 6; // Max attempts for the player

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];
        char[] guessedWord = new char[secretWord.length()];
        for (int i = 0; i < secretWord.length(); i++) {
            guessedWord[i] = '_';  
        }

        int remainingAttempts = maxAttempts;
        boolean wordGuessed = false;

        System.out.println("Welcome to Hangman!");
        System.out.println("Try to guess the word.");
        while (remainingAttempts > 0 && !wordGuessed) {
            System.out.println("\nWord: " + new String(guessedWord));
            System.out.println("Remaining attempts: " + remainingAttempts);
            System.out.print("Enter a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);
            boolean correctGuess = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    guessedWord[i] = guess;  // Update guessedWord
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                System.out.println("Good guess!");
            } else {
                remainingAttempts--; // Decrease attempts if guess is incorrect
                System.out.println("Incorrect guess.");
            }

            wordGuessed = true;
            for (int i = 0; i < guessedWord.length; i++) {
                if (guessedWord[i] == '_') {
                    wordGuessed = false;
                    break;
                }
            }
        }
        if (wordGuessed) {
            System.out.println("\nCongratulations! You guessed the word: " + secretWord);
        } else {
            System.out.println("\nGame Over! The word was: " + secretWord);
        }

        scanner.close();
    }
}
