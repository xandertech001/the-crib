/*
 * Class: CMSC203 
 * Instructor: Professor Grinberg
 * Description: This program tests a users extrasensory perception (ESP) by having them guess randomly selected colors from a list in a file.
 * Due: 6/17/2025
 * Platform/compiler: Java 17 / VS code
 * I pledge that I have completed the programming assignment independently. I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Xander Rivera
 */

 import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.Random;
 import java.util.Scanner;
 
 public class ESPGame {
 
     public static void main(String[] args) throws IOException {
         // Declare color constants (up to 16)
         final String COLOR1 = "black";
         final String COLOR2 = "white";
         final String COLOR3 = "gray";
         final String COLOR4 = "silver";
         final String COLOR5 = "maroon";
         final String COLOR6 = "red";
         final String COLOR7 = "purple";
         final String COLOR8 = "fuchsia";
         final String COLOR9 = "green";
         final String COLOR10 = "lime";
         final String COLOR11 = "olive";
         final String COLOR12 = "yellow";
         final String COLOR13 = "navy";
         final String COLOR14 = "blue";
         final String COLOR15 = "teal";
         final String COLOR16 = "aqua";
 
         final int MAX_COLORS = 16;
         Scanner scanner = new Scanner(System.in);
         String playAgain;
 
         do {
             int option = 0;
             // Menu loop with input validation
             while (option < 1 || option > 4) {
                 System.out.println("\nWelcome to ESP - extrasensory perception!");
                 System.out.println("Would you please choose one of the 4 options from the menu:");
                 System.out.println("1. Display first 16 colors");
                 System.out.println("2. Display first 10 colors");
                 System.out.println("3. Display first 5 colors");
                 System.out.println("4. Exit");
                 System.out.print("Enter the option: ");
                 if (scanner.hasNextInt()) {
                     option = scanner.nextInt();
                     scanner.nextLine(); // clear newline
                     if (option < 1 || option > 4) {
                         System.out.println("Invalid choice. Please enter a number from 1 to 4.");
                     }
                 } else {
                     System.out.println("Invalid input. Please enter a number.");
                     scanner.nextLine(); // discard bad input
                 }
             }
 
             if (option == 4) {
                 break;
             }
 
             System.out.print("Enter the filename: ");
             String filename = scanner.nextLine();
 
             File colorFile = new File(filename);
             if (!colorFile.exists()) {
                 System.out.println("File not found. Exiting...");
                 return;
             }
 
             // Read and print color options
             Scanner fileScanner = new Scanner(colorFile);
             int limit = (option == 1) ? 16 : (option == 2) ? 10 : 5;
             System.out.println("\nThere are colors from a file:");
             int count = 0;
             String displayedColors = "";
             while (fileScanner.hasNextLine() && count < limit) {
                 count++;
                 String color = fileScanner.nextLine().toLowerCase();
                 System.out.println(count + " " + color);
                 displayedColors += color + "\n";
             }
             fileScanner.close();
 
             int correct = 0;
             Random rand = new Random();
 
             // 3 rounds of guessing
             for (int i = 1; i <= 3; i++) {
                 System.out.println("\nRound " + i);
                 System.out.println("I am thinking of a color.");
                 System.out.println("Is it one of the list of colors above?");
                 String guess;
                 boolean validGuess = false;
 
                 do {
                     System.out.print("Enter your guess: ");
                     guess = scanner.nextLine().toLowerCase();
                     Scanner checker = new Scanner(displayedColors);
                     while (checker.hasNextLine()) {
                         String line = checker.nextLine();
                         if (line.equalsIgnoreCase(guess)) {
                             validGuess = true;
                             break;
                         }
                     }
                     checker.close();
                     if (!validGuess) {
                         System.out.println("Invalid color. Please enter one of the listed colors exactly.");
                     }
                 } while (!validGuess);
 
                 int selected = rand.nextInt(MAX_COLORS) + 1;
                 String chosenColor = "";
 
                 if (selected == 1) chosenColor = COLOR1;
                 else if (selected == 2) chosenColor = COLOR2;
                 else if (selected == 3) chosenColor = COLOR3;
                 else if (selected == 4) chosenColor = COLOR4;
                 else if (selected == 5) chosenColor = COLOR5;
                 else if (selected == 6) chosenColor = COLOR6;
                 else if (selected == 7) chosenColor = COLOR7;
                 else if (selected == 8) chosenColor = COLOR8;
                 else if (selected == 9) chosenColor = COLOR9;
                 else if (selected == 10) chosenColor = COLOR10;
                 else if (selected == 11) chosenColor = COLOR11;
                 else if (selected == 12) chosenColor = COLOR12;
                 else if (selected == 13) chosenColor = COLOR13;
                 else if (selected == 14) chosenColor = COLOR14;
                 else if (selected == 15) chosenColor = COLOR15;
                 else if (selected == 16) chosenColor = COLOR16;
 
                 System.out.println("I was thinking of " + chosenColor + ".");
 
                 if (guess.equalsIgnoreCase(chosenColor)) {
                     correct++;
                 }
             }
 
             System.out.println("\nGame Over");
             System.out.println("You guessed " + correct + " out of 3 colors correctly.");
 
             // Ask if user wants to play again
             System.out.print("\nWould you like to continue a Game? Type Yes/No: ");
             playAgain = scanner.nextLine();
 
         } while (playAgain.equalsIgnoreCase("yes"));
 
         // Collect and print user info
         System.out.print("\nEnter your name: ");
         String userName = scanner.nextLine();
 
         System.out.print("Describe yourself: ");
         String description = scanner.nextLine();
 
         System.out.print("Due Date (MM/DD): ");
         String dueDate = scanner.nextLine();
 
         System.out.println("\nUsername: " + userName);
         System.out.println("User Description: " + description);
         System.out.println("Date: " + dueDate);
 
         // Write to output file
         FileWriter output = new FileWriter("EspGameResults.txt");
         output.write("Game Over\n");
         output.write("Due Date: " + dueDate + "\n");
         output.write("Username: " + userName + "\n");
         output.write("User Description: " + description + "\n");
         output.write("Date: " + dueDate + "\n");
         output.close();
 
         System.out.println("\nGame result saved to EspGameResults.txt");
         System.out.println("Programmer: Xander Rivera");
 
         scanner.close();
     }
 }
 
