/* 
Xander Rivera 
Computer Programming 1A (C++)
11/9/21
The Necklace Problem 

This program will count the steps needed to complete the necklace of two numbers. 
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Main Function
int main() { 

	//Variables used to hold the original numbers inputted by the user 
	int num1old, num2old; 

	//Prompt and store first number
	cout << "Enter the first number: "; 
	cin >> num1old; 

	//Prompt and store second number
	cout << "Enter the second number: "; 
	cin >> num2old; 

	//Output original numbers for the beginning of the necklace 
	cout << num1old << " " << num2old << " "; 

	//Set new variables equal to the original, these variables we will use in our calculations
	int num1new = num1old, num2new = num2old;  
	//Set a step variable that acts of a counter, this will be outputed later. 
	int steps = 0;  

	//Do this section of code while the original number is not equal to the number after calculations.
	do{ 
			/*Set new variable that is equal to the first and second numbers from the user, get the mod of the sum to not go over 10*/
		  int sum = (num1new + num2new) % 10; 

			//Output the outcome after the calculation.
			cout << sum << " ";

			/*Set the second number equal to the first, and the second number equal to the new number after calculations.*/
			num1new = num2new;
	  	num2new = sum;

			//Add one to our step variable to track number of calculations. 
			++steps; 
		} while (num1old != num1new || num2old != num2new);

	//Output number of steps counted 
	cout << "\nYour numbers required " << steps << " steps."; 

	//Return 0 if successful 
	return 0; 
}