/*
 * Class: CMSC203 
 * Instructor: Professor Eivazi
 * Description: ESP Game - Tests extrasensory perception by having the user guess randomly selected colors.
 * Due: 09/15/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Xander Alfredo Rivera
 */

// Imports for all useful methods used in this program
import java.util.*;
import java.io.*;

public class ESPGame {

	// Final variables for our round count and the name of the file made post-game when documenting the player's score
    final static String FILE_OUTPUT = "EspGameResults.txt";
    final static int ROUNDS = 3;

    // Final variables for our color names 
    final static String COLOR1 = "black";
    final static String COLOR2 = "white";
    final static String COLOR3 = "gray";
    final static String COLOR4 = "silver";
    final static String COLOR5 = "maroon";
    final static String COLOR6 = "red";
    final static String COLOR7 = "purple";
    final static String COLOR8 = "fuchsia";
    final static String COLOR9 = "green";
    final static String COLOR10 = "lime";
    final static String COLOR11 = "olive";
    final static String COLOR12 = "yellow";
    final static String COLOR13 = "navy";
    final static String COLOR14 = "blue";
    final static String COLOR15 = "teal";
    final static String COLOR16 = "aqua";

    public static void main(String[] args) throws FileNotFoundException {
    	
    	// Scanner for input
        Scanner keyboard = new Scanner(System.in);
        // Random number declaration
        Random rand = new Random();
        // Variable for menu 
        int menu = 1;

        while (menu == 1) {
        	
        	// Initial prompt
            System.out.println("\nCMSC203 Assignment1: Test your ESP skills!");
            System.out.println("Welcome to ESP - extrasensory perception!");
            System.out.println("Would you please choose one of the 4 options from the menu:");
            System.out.println("1 - Read and display the first 16 names of colors from a file.");
            System.out.println("2 - Read and display the first 10 names of colors from a file.");
            System.out.println("3 - Read and display the first 5 names of colors from a file.");
            System.out.println("4 - Exit from the program");

            System.out.print("Enter the option: ");
            int userInput = keyboard.nextInt();

            // Verifying input
            if (userInput <= 0 || userInput >= 5) {
                System.out.println("\nIncorrect choice, please select again.");
                menu = 1;
                continue;
            } else if (userInput == 4) {
                break;
            }

            // Limit variable for number of colors 
            int limit;
            if (userInput == 1) {
                limit = 16;
            } else if (userInput == 2) {
                limit = 10;
            } else {
                limit = 5;
            }

            keyboard.nextLine(); // clear buffer
            System.out.print("Enter the filename: ");
            String filename = keyboard.nextLine();

            try {
            	// Making an object for the file to sit as we read from it
                File colorFile = new File(filename);
                Scanner fileScanner = new Scanner(colorFile);

                System.out.println("There are " + limit + " colors from the file:");
                
                // Count used to better show # of colors when displaying
                int count = 0;
                while (fileScanner.hasNextLine() && count < limit) {
                    String color = fileScanner.nextLine().trim().toLowerCase();
                    count++;
                    System.out.println(count + " " + color);
                }
                
                fileScanner.close();

                // Game guess rounds 
                int correctGuesses = 0;
                
                // Ensures via final variable ROUNDS that theres only 3 rounds
                for (int round = 1; round <= ROUNDS; round++) {
                	
                	// Random number that computer generates. +1 so we have no 0
                	// Doesn't go beond 16 because the limit is 15 +1 so 16
                    int randomNumber = rand.nextInt(limit) + 1;
                    String computerColor = "";

                    // Associate a number with the color
                    if (randomNumber == 1) computerColor = COLOR1;
                    else if (randomNumber == 2) computerColor = COLOR2;
                    else if (randomNumber == 3) computerColor = COLOR3;
                    else if (randomNumber == 4) computerColor = COLOR4;
                    else if (randomNumber == 5) computerColor = COLOR5;
                    else if (randomNumber == 6) computerColor = COLOR6;
                    else if (randomNumber == 7) computerColor = COLOR7;
                    else if (randomNumber == 8) computerColor = COLOR8;
                    else if (randomNumber == 9) computerColor = COLOR9;
                    else if (randomNumber == 10) computerColor = COLOR10;
                    else if (randomNumber == 11) computerColor = COLOR11;
                    else if (randomNumber == 12) computerColor = COLOR12;
                    else if (randomNumber == 13) computerColor = COLOR13;
                    else if (randomNumber == 14) computerColor = COLOR14;
                    else if (randomNumber == 15) computerColor = COLOR15;
                    else if (randomNumber == 16) computerColor = COLOR16;

                    // User guesses
                    System.out.print("\nRound " + round + ": Enter your guess: ");
                    String userGuess = keyboard.nextLine().toLowerCase();

                    // Validate guess: must match one of the constants up to the limit
                    boolean valid = false;
                    while (!valid) {
                        if ((limit >= 1 && userGuess.equals(COLOR1)) ||
                            (limit >= 2 && userGuess.equals(COLOR2)) ||
                            (limit >= 3 && userGuess.equals(COLOR3)) ||
                            (limit >= 4 && userGuess.equals(COLOR4)) ||
                            (limit >= 5 && userGuess.equals(COLOR5)) ||
                            (limit >= 6 && userGuess.equals(COLOR6)) ||
                            (limit >= 7 && userGuess.equals(COLOR7)) ||
                            (limit >= 8 && userGuess.equals(COLOR8)) ||
                            (limit >= 9 && userGuess.equals(COLOR9)) ||
                            (limit >= 10 && userGuess.equals(COLOR10)) ||
                            (limit >= 11 && userGuess.equals(COLOR11)) ||
                            (limit >= 12 && userGuess.equals(COLOR12)) ||
                            (limit >= 13 && userGuess.equals(COLOR13)) ||
                            (limit >= 14 && userGuess.equals(COLOR14)) ||
                            (limit >= 15 && userGuess.equals(COLOR15)) ||
                            (limit >= 16 && userGuess.equals(COLOR16))) {
                            valid = true;
                        } else {
                            System.out.print("Invalid guess, enter a color from the list: ");
                            userGuess = keyboard.nextLine().trim().toLowerCase();
                        }
                    }

                    // Output computer guess then compares the user's guess
                    System.out.println("Computer chose: " + computerColor);
                    if (userGuess.equals(computerColor)) {
                        System.out.println("Correct!");
                        correctGuesses++;
                    } else {
                        System.out.println("Wrong!");
                    }
                }

                // Collect user info after 3 rounds
                System.out.print("\nEnter your name: ");
                String name = keyboard.nextLine();
                System.out.print("Enter a sentence that describes yourself: ");
                String description = keyboard.nextLine();
                System.out.print("Enter due date (MM/DD/YY): ");
                String dueDate = keyboard.nextLine();

                // Display results
                System.out.println("\nGame Over");
                System.out.println("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.");
                System.out.println("Due Date: " + dueDate);
                System.out.println("Username: " + name);
                System.out.println("User Description: " + description);

                // Save results to file
                PrintWriter writer = new PrintWriter(new FileOutputStream(FILE_OUTPUT, true));
                writer.println("\nGame Over");
                writer.println("You guessed " + correctGuesses + " out of " + ROUNDS + " colors correctly.");
                writer.println("Due Date: " + dueDate);
                writer.println("Username: " + name);
                writer.println("User Description: " + description);
                writer.close();

                // Case catch for no file found
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Please try again.");
                menu = 1;
            }
        }

        // Always close scanners.
        keyboard.close();
    }
}
