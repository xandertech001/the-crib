/* 
Xander Rivera 
Computer Programming 1A (C++)
3/7/22
Mini Programs: Value Returning Functions

This program will use functions and return values to output different equations/responces.
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 

/*getMin function compares both numbers to find the 
lowest value of the two, and then returns it.*/
double getMin (double num1, double num2){ 

  if (num1 > num2)
  { 
    return num2;  
  }
  else if (num2 > num1)
  { 
    return num1;    
  }
  else 
  { 
    return num1;   
  }
}

/*getMax function compares both numbers to find the 
highest value of the two, and then returns it.*/
double getMax (double num1, double num2){ 

  if (num1 < num2)
  { 
    return num2;  
  }
  else if (num2 < num1)
  { 
    return num1;    
  }
  else 
  { 
    return num1;   
  }
}

/*Perfect function will run a loop to count factors and then add 
it to a total, if the number of factors added together = the original number, 
it's a perfect number. It will return string saying yes or no depending if it 
was perfect or not. */
string Perfect(int theNum) {

  int total = 0; 
  
  for(int i = 1; i < theNum; i++){ 
    if(theNum%i==0){ 
      total = i+total; 
    }
  }
  if (total == theNum){ 
    return "yes";  
  }
  else { 
    return "no";   
  }
} 

//Main Function
int main() { 

  //MINI 1 OUTPUT

  double first=0;
  double second=0;
 
  cout<<"\nEnter first value: ";
	cin>>first;
  cout<<"Enter second value: ";
  cin>>second;
  cout<<"Low: "<<getMin(first,second)<<endl;

  //MINI 2 OUTPUT

  cout<<"\nEnter first value: ";
  cin>>first;
  cout<<"Enter second value: ";
  cin>>second;
  cout<<"High: "<<getMax(first,second)<<endl;

  //MINI 3 OUTPUT
  
  int number;
  cout<<"\nEnter number to test: ";
  cin>>number;
  if(Perfect(number)=="yes"){ 
    cout<<number<<" is Perfect!"<<endl;
  }
  else{ 
    cout<<number<<" is not perfect."<<endl;
  }
  
}