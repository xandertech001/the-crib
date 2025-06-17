/* 
Xander Rivera 
Computer Programming 1A (C++)
11/30/21
Primes in a Range

My program will output the number of prime numbers between a givin range.
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

//Main Function
int main() {

	//Variables for user input 
	int num1,num2; 
	//Variables for counting primes 
  int prime = 0,notprime = 0;

	//Prompt and store as the first number for the range
	cout << "Enter starting number: ";
	cin >> num1;
	//Prompt and store as the second number for the range
	cout << "Enter ending number: ";
	cin >> num2;		

	/*For loop: Loop as long as the first number is less or equal to the second one, when it still is, add 1 to the first input*/ 
  for(int i = num1 ; i <= num2; i++)
     {
			 /*For loop: Loop as long as the first number is not greater or equal than 2*/
       for(int j = 2; j <= i/2; j++)
            {
							/*If the first number's remander is 0 after being divided by 2;*/
	          	if(i % j == 0) 
							//It is not prime
              notprime++;
            } 
						/*If the first number divided by 2 isn't 0, then it's prime, (0 & 1 are not prime numbers)*/
            if(notprime == 0 && i != 1)
            { 
							//Add one to prime to show it's prime
							prime++;
							//Reset it back to 0 because it's prime
            	notprime = 0;
            }
			//Set the notprime variable back to 0 back to 0
      notprime = 0;
     }
	/*Output final total of primes within the first and second inputs by the user*/
 	cout << "\nNumber of primes in range: " << prime << endl;
	//Return 0 if successful 
	return 0; 
}