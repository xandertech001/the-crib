/* 
Xander Rivera 
Computer Programming 1A (C++)
11/17/21
Interative Loops 

My program will output various problems that include interative loops (for loops). 
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//constant used for width and formatting 
const int x = 15; 

//Main Function
int main() { 

	//problem 1 

	//variable for primary user input 
	int input1; 
	
	//prompt user and take that input and store it in input1
	cout << "How many boxes?: ";  
	cin >> input1; 

	//For loop, set i = 1 and as it is less or greater than the user input, add onto i
	for (int i = 1; i <= input1; i++) {  
		//prompt to user
		cout << "\tBOB & PATRICK'S SEASHELL EMPORIUM" << endl; 
		cout << "\tUNDER THE SEA, MD 12345" << endl;  
		//i = all numbers before input and input = total number of boxes
		cout << "\tBOX NUMBER " << i << " OF " << input1 << endl << endl; 
	}

	//problem 2 

	//second primary user input variable
	int input2; 

	//prompt the user and store it in input1
	cout << "Enter starting value: "; 
	cin >> input1;  

	//promt the user and store it in input2
	cout << "Enter ending value: "; 
	cin >> input2;   

	//set format to the left
	cout.setf(ios::left); 

	//set the width to a constant 
	cout.width(x); 
	//output headers
	cout << "X";  
	cout.width(x); 
	cout << "X SQUARED"; 
	cout.width(x); 
	cout << "X CUBED" << endl;  

	/*for loop, set i = to the first input as that is where the table is going to start and as that is less than or equal to the second number, it will output until it's within the desired numbers. */
	for (int i = input1; i <= input2; i++) {  

		/*output i value, then squared which is i multiplied by itself and squared, i muiltiplied 3 times by itself.*/
		cout.width(x); 
		cout << i; 
		cout.width(x); 
		cout << i * i; 
		cout.width(x); 
		cout << i * i * i << endl << endl; 

	} 

	//problem 3 

	//char variable because we are dealing with grades
	char grd; 
	//use passed variable to count number of passed 
	int passed = 0; 

	//for loop, set i = 0 and as that is less than 10, add 1 (this will loop 10 times)
	for (int i = 0; i < 10; i++) { 
		 
		//prompt and store user input in grd (grade)
		cout << "Enter a grade: "; 
	  cin >> grd;   

		//change char input to uppercase to hit if statement
		grd = toupper(grd);

			//if they are A, B, C, or D, it means it's a passing grade
			if (grd == 'A' || grd == 'B' || grd == 'C' || grd == 'D') {  
				//add 1 to passed everytime A, B, C, or D is entered 
				passed++; 
		}
	}

	//output number of passing students
	cout << passed << " sudents passed." << endl;  
	/*the number of failed is just 10 subtract whoever failed because we only run it 10 times*/
	cout << 10 - passed << " students failed." << endl; 

	//return 0 if successful. 
	return 0; 
}