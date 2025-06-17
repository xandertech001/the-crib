/* 
Xander Rivera 
Computer Programming 1A (C++)
3/10/22
Reference Parameters

This program will utilize reference parameters to 
acsess variables within main and change them 
to answer various outputs/mini problems.
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std;  

//MINI 1
void Raise (double &yOne, double &yTwo, double &yThree){ 
  
  double salary = 0; 
  cout << "Enter current salary: "; 
  cin >> salary; 

  yOne = salary * 1.07; 
  yTwo = yOne * 1.06;
  yThree = yTwo * 1.05;
}

//MINI 2
void findLoHi(int x, int y, int &lo, int &hi)
{
  if (x > y){ 
    hi = x; 
    lo = y;
  }
  else{ 
    hi = y; 
    lo = x;
  }
} 

//MINI 3
void daysToHoursMins (int days, int &hours, int &mins) { 
  hours = days * 24;
  mins = hours * 60; 
}


//Main Function
int main() { 


  //MINI 1
  double yNext=0;
  double yTwoAway=0;
  double yThreeAway=0;
  Raise(yNext,yTwoAway,yThreeAway);
	cout.setf(ios::fixed);
	cout.precision(2);
  cout<<"Next Year: $"<<yNext<<" 2 Years: $"<<yTwoAway<<" 3 Years: $"<<yThreeAway << endl;
 

  //MINI 2
  int first=0;
  int second=0;
  int min=0;
  int max=0;
 
  cout<<"Enter first int: ";
  cin>>first;
  cout<<"Enter second int: ";
  cin>>second;
  findLoHi(first,second,min,max);
  cout<<"Low: "<<min<<" High: "<<max<<endl;

  

  //MINI 3
  int days;
  int hours=0;
  int minutes=0;  	
  cout<<"Enter number of days:";
  cin>>days;
  daysToHoursMins(days, hours, minutes);
  cout<<days<<"day(s) is "<<hours<<" hours or "<<minutes<<" minutes"<<endl; 

  return 0;
}