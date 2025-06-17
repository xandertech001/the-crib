//============================================================================
// Name        : Mini-String2.cpp
// Author      : Xander
// Version     : 5/4
// Description : This program will reverse one string of text and replace all instances
//				 of 'a' and 'e' with '@' and '3' respectively
//============================================================================

#include <iostream>
#include <string>
using namespace std;

string Reverse(string theString) {
	string rs;
	for (int i = theString.length() - 1; i >= 0; i--) {
		rs += theString.at(i);
	}
	return rs;
}

string Numerate(string theString) {
	string ns;
	for (int i = 0; i < theString.length(); i++) {

		theString.at(i) = tolower(theString.at(i));

		if (theString.at(i) == 'a') {
			theString.at(i) = '@';
		}
		else if (theString.at(i) == 'e') {
			theString.at(i) = '3';
		}

		if (!(theString.at(i) == ' ')) {
			ns+=theString.at(i);
		}
	}
	return ns;
}

int main() {

	string input;

	//Mini 1
	cout << "Enter your text: ";
	getline(cin,input);

	input = Reverse(input);
	cout << "New Version: " << input << endl << endl;

	//Mini 2
	cout << "Enter another text: ";
	getline(cin,input);

	input = Numerate(input);
	cout << "New Version: " << input << endl;


	return 0;
}
