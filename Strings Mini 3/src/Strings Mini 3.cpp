//============================================================================
// Name        : Mini Strings 3
// Author      : Xander
// Version     : 5/12
// Description : Write ONE program that includes ALL of the mini-problems described below in a single .cpp file.  Be sure to label each function you write with a comment as well as proving the normal multi-line header comment, and normal single line comments throughout. Your main() should execute BOTH mini1 and mini2 before ending.  See the link below for more details.
//============================================================================

#include <iostream>
#include <string>
using namespace std;

void Triples(string phrase){
	int len3mod = phrase.length()%3;

	if(len3mod != 0){
		phrase.resize(phrase.length()+(3 - len3mod), '*');
	}

	for (int i = 0; i < phrase.length(); i += 3){
		cout << phrase.substr(i,3) << endl;
	}
}

int LookWithin(string w1, string w2){
	string s2test;
	for(int i = 0; i < w2.length(); i++){
		s2test = w2.substr(i, w1.length());
		cout << s2test << endl;
		if (s2test == w1)
			return i;
	}
	return -1;
}

int main() {

	string ui;

	//MINI 1
	cout << "Enter some text: ";
	getline(cin, ui);

	Triples(ui);

	//MINI 2

	string ui1;
	string ui2;

	cout << "Enter your text 1: ";
	getline(cin, ui1);


	cout << "Enter your text 2: ";
	getline(cin, ui2);

	int index = LookWithin(ui1,ui2);

	if (index == -1){
		cout << "The word " << ui1 << " was not found in the phrase " << ui2 << endl;
	}
	else {
		cout << "The word " << ui1 << " was found in the phrase " << ui2 << " starting at index " << index << endl;
	}

	return 0;
}
