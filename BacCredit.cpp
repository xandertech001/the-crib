/*
Hawa Holmes & Xander Rivera
Bad Credit
1/17/22

This program will prompt the user for a cedit card number, then report whether it is a valid American Express, MasterCard, or Visa card number.
*/

//Preprocessor directives
#include <iostream>

//standard user namespace
using namespace std; 

//variable used to hold user input
long long userNumber; 

//counting digit function
int count_digit	(long long userNumber) 
{
  int count = 0;
  while(userNumber != 0) 
	{
    userNumber = userNumber / 10;
    count++;
  }
	return count;
} 

//return the sum of the two digits
int getDigit(int number)
{
  if (number < 9){
    return number;
	}
	else 
	{
  return number / 10 + number % 10;
	}
}

//return sum of even-place digits in number
int sumOfDoubleEvenPlace(long long userNumber)
{
  int sum = 0;
	int length = count_digit(userNumber);
	string cardNumber = to_string(userNumber) ;
  for (int i = length - 2; i >= 0; i -= 2)
	{
    sum = sum + getDigit(int(cardNumber[i] - '0') * 2);
	}
  return sum;
}

//return sum of odd-place digits in number
int sumOfOddPlace(long long userNumber)
{
  int sum = 0;
  int length = count_digit(userNumber);
	string cardNumber = to_string(userNumber) ;
  for (int i = length - 1; i >= 0; i -= 2)
	{
    sum = sum + cardNumber[i] - '0';
	}
  return sum;
}

int main() 
{	
  
	//user input prompt
  cout<<"Enter a credit card number: "; 
	//take in user input as userNumber
	cin>>userNumber; 

	//determining the length of card
	int length = count_digit(userNumber); 

	//variables used to determine if the length is good
	bool visaLength = false; 
	bool mcLength = false; 
	bool amexLength = false; 

	//switch using length 
	switch (length) 
	{ 
		//when credit card number = 16
		case 16: 
		{ 
			visaLength = true; 
			mcLength = true;
			break;
		}
		//when credit card number = 13
		case 13: 
		{ 
			visaLength = true;
			break;
		}
    //when credit card number = 15
		case 15: 
		{ 
			amexLength = true;
			break;
		} 
		//when credit card number != 16, 13, 15:
		default: 
		{ 
			cout << "(Length) Invalid card number." << endl;
			break;
		}
	}
	
  
	//bool variables checking for the first number 
	bool visa1num = false; 
	bool mc1num = false; 
	bool amex1num = false; 

	//converts userNumber into a string called cardNumber
	string cardNumber = to_string(userNumber) ;
  
	//switch using first position of cardNumber
	switch (cardNumber[0])
	{ 
    //when first position = 4
		case '4': 
		{  
			visa1num = true;
			break;
		} 
    //when first position = 5
		case '5': 
		{ 
			mc1num = true; 
			break;
		} 
    //when first position = 3
		case '3': 
		{ 
			amex1num = true; 
			break;
		}
		//when first postion != 3, 4, 5:
		default: 
		{ 
			cout << "(First number) Invalid card number." << endl;
			break;
		}
	}


	//bools used to validate second number in cardNumber
	bool mc2num = false; 
	bool amex2num = false; 

	//if statement to only find brands MC and AMEX
	if (amex1num == true || mc1num == true) 
	{
		//switch using second position of cardNumber
		switch (cardNumber[1]) 
		{ 
			//when second number = 1, 2, 3, 5
			case '1': 
			case '2': 
			case '3': 
			case '5': 
			{ 
				mc2num = true;  
			}
      //when second number = 4
			case '4': 
			{
				//if first number -> amex
				if (amex1num == true)
				{ 
					amex2num = true;
				} 
				//if first number -> mc 
				else if (mc1num == true)
				{ 
					mc2num = true;
				}
				break;
			} 
			//when second number = 7
			case '7': 
			{ 
        //if first number -> amex
				if (amex1num == true) 
				{ 
					amex2num = true;
				}
				break;
			}
			//when second number != 1, 2, 3, 4, 5, 7
			default: 
			{ 
				cout << "(Second number) Invalid card number." << endl;
			}
			break;
		}
	}


	//bool variable to validate checksum equation
	bool checksum = false; 

	//if checksum = 0
	if ((sumOfDoubleEvenPlace(userNumber) + sumOfOddPlace(userNumber))% 10 == 0) 
	{ 
		checksum = true; 
	}
	//if checksum did not equate to 0 it failed 
	else 
	{ 
		cout << "(CheckSum) Invalid card number." << endl;
	}


	//only output numbers that went through checksum successfuly 
  if (checksum == true)
  {
		//if it passed all checks for visa
		if (visaLength == true && visa1num == true)
    {
      cout<<"This is a valid VISA card." << endl;
    }
    //if it passed all checks for mastercard
    else if (mcLength == true && mc1num == true && mc2num == true)
    {
      cout<<"This is a valid MasterCard card." << endl;
    }
    //if it passed all checks for amex
    else if (amexLength == true && amex1num == true && amex2num == true)
    {
      cout<<"This is a valid American Express card." << endl;
    }
  }


	//return 0 if successful 
	return 0;
}