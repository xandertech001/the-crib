/* 
Xander Rivera 
Computer Programming 1A (C++)
12/17/21
Array for Grade Analysis 

This program will be able to take in user inputted scores and store them into a list that will then output the min, max, average, and duplicates. 
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Main Function
int main() { 	 

	//variables
	double max; 
	double min; 
	double average;  

	//Array declar.
	double scores [10];  

	//Loop 10 times
	for (int i = 0; i < 10; i++) { 
		//user input capture
		cout << "Score " << i+1 << ": ";  
		cin >> scores[i];
	} 

	//set min to the first postion in the list
	min = scores[0]; 
	//set max to the first postion in the list
	max = scores[0];

	//loop 10 times
	for (int i = 0; i < 10; i++) {    

		//check min
		if (scores[i]<min) { 
			min=scores[i];
		}//end if 

		//check max
		if (scores[i]>max) { 
			max=scores[i];
		}//end if 

		//add for average
		average+=scores[i];
	}//end for

	//divide by 10 to get average
	average = average/10; 

	//output max, min, and average 
	cout << "Lowest score: " << min << endl; 
	cout << "Highest score: " << max << endl; 
	cout << "Average score: " << average << endl;

	/*loop 9 times (not 10 because we already have a loop that checks the last index)*/
	for (int o = 0; o < 9; o++) { 
		/*Loop up to 10 times starting from 1 + o's position within the list*/
		for (int j = o+1; j < 10; j++) {  
			//If they are the same, they are a duplicate
			if (scores[o] == scores [j]) { 
				cout << scores[o] << " is a dulpicate!" << endl; 
			}//end if
		}//end second for
	}//end first for
}//end main