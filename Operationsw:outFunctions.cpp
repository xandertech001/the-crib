/* 
Xander Rivera 
Computer Programing 1A (C++)
9/9/21
Simple calculations 

This program will model different opperations and output various math equations. 
*/

//Preprocesor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Main Function
int main() { 

//1st question

  //These are the variables for the sides of the triangle 

  //base
  int sideA = 3;  
  //height
  int sideB = 4;  
  //hypotenuse
  int sideC = 5; 

  //This outputs the question (question 1)
  cout << "First problem: Calculate the area and perimeter of a right triangle with a base of 3, height of 4, and hypotenuse of 5.\n"; 
  cout << "\n"; 

  //Displays "answer" string
  cout << "Answer: \n\n";

  //This caculates the area = A = ab/2
  cout << "Area = " << (sideA * sideB ) / 2 << "\n";
  //This caculates the perimeter = a + b + c = P
  cout << "Perimeter = " << sideA + sideB + sideC << "\n"; 
  cout << "\n\n";

//2nd question

  //These are the variables used to find the unit value

  //Total gallons
  int gallons = 8;  
  //Miles traveled with 8 gallons
  double milesTraveled = 420.3; 

  //This outputs the question (question 2)
  cout << "Second problem: Calculate the number of miles per gallon used by a car that has travelled 420.3 miles on a full 8 gallon tank of gas.\n";
  cout << "\n"; 

  //Displays "answer" string
  cout << "Answer: \n\n";

  //This calculates how many miles can you go with one gallon = total miles traveled / gallons = miles per gallon
  cout << "Miles per gallon = " << milesTraveled / gallons << "\n";
  cout << "\n\n"; 

//3rd  question
  // These are the variables containing each jump preformed 

  //1st jump
  int jump1 = 3; 
  //2nd jump
  double jump2 = 3.2;
  //3rd jump
  double jump3 = 2.9;   
  //4th jump
  double jump4 = 2.7;

  //This outputs the question (question 3)
  cout << "Third problem: Calculate the average jump length of a long-jumper whose jumps were 2.7m, 3m, 3.2m, and 2.9m. Hint: use parentheses!\n";
  cout << "\n"; 

  //Displays "answer" string
  cout << "Answer: \n\n";

  //This caculates the average = (a + b + c + d) / 4
  cout << "Average = " << (jump1 + jump2 + jump3 + jump4) / 4 << "\n";
  cout << "\n\n";

//4th question
  //This variable demonstrates the total number of seconds we are converting into hours and minutes
  int totalSeconds = 20100; 

  //This outputs the question (question 4)
  cout << "Fourth problem: Calculate the total number of whole hours and whole minutes that a total time of 20100 seconds contain.\n"; 
  cout << "\n"; 

  //Displays "answer" string
  cout << "Answer: \n\n";

  //This caculates the total amount of hours (seconds / 60) / 60)
  cout << "Hours = " << (totalSeconds / 60) / 60 << "\n"; 
  //This caculates the total amount of minutes ((seconds / 60) / 60) % 60 
  cout << "Minutes = " << (totalSeconds / 60) % 60 << "\n";  
  cout << "\n\n";

  return 0;
}