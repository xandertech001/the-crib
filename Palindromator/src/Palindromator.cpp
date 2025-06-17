//============================================================================
// Name        : Palindromator.cpp
// Author      : Xander
// Version     : 5/4
// Description : This program will validate if a string of text
//               is a palindrome
//============================================================================

#include <iostream>
#include <string>

using namespace std;

int main() {

	int menu = 1;

	do{
		//variables
		string text;
		string copy1;
		string copy2;

		//prompt
		cout << "Enter your text: ";
		getline(cin, text);

		//traverse forwards and store
		for (int i = 0; i < text.length(); i++) {
			if (isalpha(text.at(i))) {
				copy1 += tolower(text.at(i));
			}
		}

		//traverse backwards and store
		for (int i = text.length() - 1; i >= 0; i--) {
			if (isalpha(text.at(i))) {
				copy2 += tolower(text.at(i));
			}
		}

		//if the two copies of the strings are the same, its a palindrome
		if (copy1 == copy2){
			cout << "Yes! Your string is a palindrome!" << endl;
		}
		else{
			cout << "No! Your string is not a palindrome!" << endl;
		}

		//prompt
		cout << "\nWould you like to check another string of text? (1 - yes | 2 - no): ";
		cin >> menu;
		cin.ignore();

		//repeat if needed
	}while(menu == 1);

	return 0;
}
