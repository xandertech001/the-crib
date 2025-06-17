/* 
Xander Rivera 
Computer Programming 1A (C++)
11/3/21
Mini-Problems-Conditional-Loops

The console will display various problems using while as a loop to output the desired sum or patter of numbers.
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Main Function
int main() { 
 
	//PROBLEM 1 

	//variables for counter and user input
	int count = 1; 
	double userinput1; 

	//Prompt and store in userinput1
	cout << "Please enter a whole number: "; 
	cin >> userinput1; 
	cin.ignore(); 

	//while the input is greater than zero
	while (userinput1 > 0) 
		{ 
			//output the input 
			cout << userinput1 << endl; 
			//take one off from the input and repeat until you get to 1
			userinput1--; 
		} 

	//Prompt and store in userinput1
	cout << "\n\nPlease enter a whole number: "; 
	cin >> userinput1; 
	cin.ignore(); 

	//while the count is less than or equal to the user input
	while (count <= userinput1) 
		{ 
			//output the count 
			cout << count << endl;  
			//add one to the count until you get to the user input 
			count++; 
		} 

	//variables
  double sum = 0;
	double userinput2;
	//set count back to 0
	count = 0; 

	//prompt and store in userinput2
  cout << "\n\nEnter a number: ";
  cin >> userinput2;

	//while the input is above 0
  while (userinput2 > 0) { 
			//add the input into sum
      sum+=userinput2; 
			//add one to the count
			count++;
			//prompt again
      cout << "Enter a number: ";
      cin >> userinput2;
    }
	//output the average by dividing the sum of the numnbers by the count of the loop
  cout << "\nThe average is " << sum / count << endl;
    
	//return 0 if successful
  return 0;
}