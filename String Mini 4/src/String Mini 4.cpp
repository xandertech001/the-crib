//============================================================================
// Name        : String Mini 4
// Author      : Xander
// Version     : 6/1
// Description : Write ONE program that includes ALL of the mini-problems described below in a single .cpp file.  Be sure to label each function you write with a comment as well as proving the normal multi-line header comment, and normal single line comments throughout. Your main() should execute BOTH mini1 and mini2 before ending.
//============================================================================

#include <iostream>
#include <string>
using namespace std;

//MINI 1
//An acronym is a word formed from the first letters of a few words.
string Acro(string input){

	string output1;
	int found = -1;

	output1 += toupper(input[0]);

	do{
		found = input.find(" ", found+1);

		if(found !=-1){
			output1 += toupper(input[found+1]);
		}

	}while (found != -1);


	return output1;
}

//MINI 2
//Write a function called VowelCounter that takes a string as a parameter and then determines the total number of vowels it contains.
int vowelCount(string input){

	int vowels = 0;
	int found = -1;


	do{
		found = input.find_first_of("aeiouAEIOU", found+1);

			if(found !=-1){
				vowels++;
			}

		}while (found != -1);

	return vowels;
}


int main() {

	string ui1;

	cout << "Enter your text: ";
	getline(cin,ui1);

	cout << "Acronym: " <<  Acro(ui1) << endl;


	string ui2;

	cout << "Enter your text: ";
	getline(cin,ui2);

	cout << "Number of vowels: " << vowelCount(ui2);

	return 0;
}
