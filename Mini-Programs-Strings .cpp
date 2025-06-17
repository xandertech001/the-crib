/* 
Xander Rivera 
Computer Programming 1A (C++)
4/6/22
Mini Programs: Strings 

Mini Problem #1 
Write a function called Separate() that takes as parameter a 
string, and outputs it one letter at a time, each on a new line. 
In main, allow the user to input the text of the string that 
you will pass to the function. You should test a variety of inputs 
to ensure you have covered all possible cases. 
Please note that input could be more than one word(remember to use getline!).
You must make use of .length() in your function.

Mini Problem #2 
Write a function called CleanUp() that takes as parameter a 
string and a desired total length.If the desired total length 
is longer than the current length of the string, then ask the 
user what character s/he would like to pad it with in order to 
reach the desired length.  If the desired total length is shorter
than the current length of the string, truncate the extra characters
from the right-hand side so that the string is now the shorter,
desired length. If the string is already at the desired length, 
make no changes. 
Return the altered string once all processing has been completed. 
In main, allow the user to input the text of the string and the desired length
to pass to the function. Once the function has performed its work,
print out the new version of the string in main. 
You must make use of resize() in your function.
*/

//Preprocessor directive library
#include <iostream> 
#include <string>

//Standard namespace
using namespace std; 

//Used to seperate text
void Seperate(string userText){ 
//Look for the length of the text adding a new line at the end of each position
	for (int i = 0; i < userText.length(); i++){ 
		cout << userText.at(i) << endl;
	}
} 

//Used to orginize text based on length/pad parameters 
string CleanUp(string text, int length)
{
	//If length is more than length of text
	if (length > text.length())
	{ 
		//Pad variable declaration 
		char pad;

		//Prompt and grab char
		cout << "Pad with?: ";  
		cin >> pad; 

		//Resize text passing length and pad parameters 
	  text.resize(length, pad);

		//Return final text version
		return "New version: " + text;
	}

	//If length is less than length of text
	if (length < text.length())
	{ 
		//Resize text passing length 
	  text.resize(length);

		//Return final text version
		return "New version: " + text;
	}
	//(When desired length = text length) -> return original text 
	return "New version: " + text;
}

//Main Function
int main() { 

	//Mini Problem #1

	//String declaration 
	string userText; 

	//Prompt and grab text
	cout << "Enter text: "; 
	getline(cin, userText); 

	//Function call
	Seperate(userText);

	//Mini Problem #2

	//Variable for user's desired length
	int userLength;

	//String declaration 
	string userText2; 

	//Prompt and grab text
	cout << "Enter text: "; 
	getline(cin, userText2); 

	//For malicious input (input under 0)
	do{ 

		//Prompt and grab number
		cout << "Desired length (positive)?: "; 
		cin >> userLength; 
		
	}while (!(userLength >= 0));

	//Function call and output final output
	cout <<  CleanUp(userText2, userLength);
}