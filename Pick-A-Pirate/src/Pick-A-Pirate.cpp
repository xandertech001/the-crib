//============================================================================
// Name        : Pick-A-Pirate.cpp
// Author      : Xander
// Version     : 6/2
// Description : This program will ask the user to input a selected pair of words to swap.
//============================================================================

#include <iostream>
#include <string>
using namespace std;

string replace(string eng, string pir, string txt) {

	int found = -1;

	//Find every instance and update the string with the replacement and then return final string once all instances are found and replaced.
	do {
		found = txt.find(eng, found + 1);
		if (found != -1) {
			txt = txt.substr(0, found) + pir + txt.substr(found + eng.length());
		}
	} while (found != -1);

	return txt;
}

int main() {

	//Variables
	string english;
	string pirate;
	string phrase;

	//Prompts and input capture
	cout << "Enter an English word to swap: ";
	getline(cin, english);

	cout << "Enter a Pirate replacement word: ";
	getline(cin, pirate);

	cout << "Enter your phrase: ";
	getline(cin, phrase);

	//Final prompt + function call
	cout << "Prirate version: " << replace(english, pirate, phrase);

	return 0;

}
