//============================================================================
// Name        : Word Scrambler 1.0
// Author      : Xander
// Version     : 5/29/22
// Description : Write a program that prompts the user to enter in a phrase and then shuffles the pieces of that phrase.  When finished, the word should appear scrambled. All letters in the scrambled phrase will appear the same number of times as before.
//============================================================================

#include <iostream>
#include <string>
using namespace std;

string Split(string text){

	//Variables
	int left;
	int mid;

	//Set left (left most chunk)
	left=rand()%(text.length()-2)+1;

	text.substr(0,left);

	//Set mid (mind  chunk)
	mid=rand()%(text.length()-left-1)+1;

	text.substr(left,mid);

	text.substr(left+mid);


	//String combined with new generated chunks
	string combined = text.substr((left+mid))+text.substr(left,mid)+text.substr(0,left);

	return combined;
}

int main() {
	//seed
	srand(time(0));

	//Variables
	int menu = 1;
	int scramble;
	string text;

	//While loop
	while (menu == 1){

		//Prompts
		cout << "\nHow many times would you like to shuffle the phrase?: ";
		cin >> scramble;
		cin.ignore();

		cout << "\nEnter the phrase to scramble: ";
		getline(cin,text);

		//Loop for every shuffle wanted by the user
		for (int i = 0; i < scramble; i++){
			//Function call with label
			cout << "\nPermutation #" << i+1 << ":" << Split(text) << endl;
		}

		//Prompt
		cout << "\nAgain? 1=Yes, 2=No: ";
		cin >> menu;
	}
	//Prompt
	cout << "\nGoodbye!";
}
