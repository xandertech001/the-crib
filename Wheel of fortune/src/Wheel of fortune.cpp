//============================================================================
// Name        : No Wheel! No Fortune!
// Author      : Xander
// Version     : 5/11
// Description : No Wheel! No Fortune! is a really budget version of the game show Wheel of Fortune in which there is neither wheel NOR a fortune! BUT - A single human player has five chances to guess a hidden puzzle letter by letter to win NOTHING! If they make five incorrect guesses(the letter they guess is not contained in the puzzle) they lose and leave the game with shame as their only penalty.
//============================================================================

#include <iostream>
#include <string>
using namespace std;

//STRING ARRAYS
string puzzles[] = {"MINI COOPER", "TWIZZLERS", "JUPITER", "YOUTUBE", "MONOPOLY"};
string categories[] = {"Cars", "Candies", "Planets", "Media Platforms", "Board Games"};

//Selects a random answer from the list. Stores it and the corresponding category for use during the game.
void setAnserrAndCategory(string &thePuzzle, string &theCategory, string puzzles[], string categories[]){
	int randnum = rand()%5;
	thePuzzle = puzzles[randnum];
	theCategory = categories[randnum];
}

//Creates and returns a string of equal length to the answer in which all letters have been converted to underscores. Spaces are kept in their existing positions.
string hideAnswer(string thePuzzle){

	for (int i = 0; i < thePuzzle.length(); i++){
		if (isalpha(thePuzzle.at(i))) {
			thePuzzle.at(i) = '_';
		}
	}
	return thePuzzle;
}

//“Uncovers” the location of any occurrences of the user’s guessed letter in the hidden version of the answer (those spots are changed back from underscore to the guessed letter).
//Returns true if it actually found the guess and false if it did not.
bool vannaWhite(string &hiddenAnswer, string thePuzzle, char userGuess) {

	for (int i = 0; i < thePuzzle.length(); i++) {
		if (userGuess == thePuzzle.at(i)) {
			hiddenAnswer.at(i) = userGuess;
		}
	}

	if (!(thePuzzle == hiddenAnswer)) {
		return true;
	}
	else {
		return false;
	}
}

//Prints out the hidden version of the answer with an extra space inserted between each character of the puzzle. One the next line, displays the corresponding category.
void showsHidden (string hiddenAnswer, string theCategory){
	cout << "\n" << hiddenAnswer << endl;
	cout << "Category: " << theCategory << endl;
	cout << "================" << endl;
}


//Prompts the user to input a guess. Returns the uppercase version of that letter.
char makeGuess(){
	char guess;
	cout << "Enter a guess: ";
	cin >> guess;

	guess = toupper(guess);

	return guess;
}
//If the user is out of guesses, print “You Lose” along with the answer and return true.  If no underscores remain in the puzzle copy, print “You Win!” and returns true.  Otherwise returns false.  Use to control game loop.
bool gameOver(int Guesses, string thePuzzle, string hiddenAnswer){

	if (Guesses == 0){
		cout << "You Lose!" << endl;
		cout << "Answer: " << thePuzzle << endl;
		return false;
	}

	int underscores = 0;

	for (int i = 0; i < hiddenAnswer.length(); i++){
		if (isalpha(hiddenAnswer.at(i)) == false) {
			underscores++;
		}
	}

	if (underscores == 0){
		cout << hiddenAnswer << endl;
		cout << "You Win!" << endl;
		cout << "Answer: " << thePuzzle << endl;
		return false;

	}
	else {
		return true;
	}
}

int main() {

	//Seed
	srand(time(0));

	//Variables
	string thePuzzle;
	string theCategory;

	int Guesses = 5;
	char userGuess;

	//Array for multiple guesses of the same letter
	bool letterGuesses [26];

	for (int i = 0; i < 26; i++){
		letterGuesses[i] = false;
	}

	//Set category and puzzle
	setAnserrAndCategory(thePuzzle, theCategory, puzzles, categories);

	//Hide answer
	string hiddenAnswer = hideAnswer(thePuzzle);

	//Make a copy of that hidden answer, used to validate guesses that werent correct/revealed
	string copyHidden = hiddenAnswer;

	//Do while the player hasn't won
	do{

	//Re-copy hidden answer
	copyHidden = hiddenAnswer;

	//Shows player's progress on the answer
	showsHidden(hiddenAnswer, theCategory);

	//Store user guess
	userGuess = makeGuess();

	//Check to see if that guess was within the answer
	vannaWhite(hiddenAnswer, thePuzzle, userGuess);

	//Variable to check muiltiple guesses of the same letter
	int charIndex = (int)userGuess - 65;

	//If that letter wasnt guessed previously, mark it as true; meaning now it was used, If that was previously guessed, prompt again
	if (!(letterGuesses[charIndex] == true)){
		letterGuesses[charIndex] = true;
	}
	else{
		cout << "\nYou have already guessed this letter. Try again: " << endl;
	}

	//If the copy does not match the original answer, meaning the player did not input a new/valid letter
	if (copyHidden == hiddenAnswer){
		//Decrease guesses by 1 and update
		Guesses--;
		cout << "Incorrect guesses left: " << Guesses << endl;
	}
	}while (gameOver(Guesses, thePuzzle, hiddenAnswer) == true);

	return 0;
}
