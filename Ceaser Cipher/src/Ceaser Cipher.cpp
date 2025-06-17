//============================================================================
// Name        : Ceaser Cipher
// Author      : Xander Rivera
// Class       : Computer Programming 1B
/* Description : Your goal is to write a program that encrypts messages using Caesar’s cipher.
 Your program must accept a single non-negative integer from the user for the key. Let’s call it k.
 Your program must then proceed to prompt the user for a string of plaintext and then output that text with each alphabetical character "rotated" by k positions; non-alphabetical characters should be outputted unchanged.
 Your program must preserve case: capitalized letters, though rotated, must remain capitalized letters; lowercase letters, though rotated, must remain lowercase letters.*/
//============================================================================

#include <iostream>
#include <string>

using namespace std;

void Cipher(string userText, int k) {
	for (int i = 0; i < userText.length(); i++) {
		if (isupper(userText.at(i)) == true) {
			char cipherLetter = ((userText.at(i) + k - 'A') % 26) + 'A';
			cout << cipherLetter;
		} else if (islower(userText.at(i)) == true) {
			char cipherLetter = ((userText.at(i) + k - 'a') % 26) + 'a';
			cout << cipherLetter;
		} else {
			cout << userText.at(i);
		}
	}
}

int main() {
	string userText;
	int k;

	cout << "Enter text: ";
	getline(cin, userText);
	cout << "Enter key: ";
	cin >> k;

	Cipher(userText, k);

	return 0;
}
