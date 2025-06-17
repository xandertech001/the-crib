/* 
Xander Rivera 
Computer Programming 1A (C++)
2/28/22
Mini-Problems: Default Parameters and Overload Functions

This program will use function parameters to output various text/symbols within different patterns.
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std;


//Draw function that will print a # of times depending on the parameter
void Draw(int times, string text = "$") {

  for (int repeats = 0; repeats < times; repeats++){ 
    cout << text << endl;
  }
  cout << endl; 
}


/*There is no difference between these functions besides 
the parameters's data types, it's the same function and we 
write it twice to support a string and an int */
void BlockOfValues(int symbol, int side = 5){ 
 for (int row = 0; row < side; row++){ 
    for (int i = 0; i < side; i++){ 
      cout << symbol << " ";  
    }
   cout << endl;
  } 
}

void BlockOfValues(string symbol, int side = 5){ 
 for (int row = 0; row < side; row++){ 
    for (int i = 0; i < side; i++){ 
      cout << symbol << " ";  
    }
   cout << endl;
  } 
}


//Main Function
int main() { 


  //Function call with a parameter of 5 + default parameter (didn't specify)
  Draw(5);
 
  cout<<endl;

  //Function call with a parameter of 10 and a @ string
  Draw(10, "@"); 


  //Function call with a parameter of 8 and 3 (int)
  BlockOfValues(8, 3);
  cout<<endl;

  //SAME function call but with a parameter of "hi" (string) and 4 (int)
  BlockOfValues("hi",4);
  cout<<endl;

  //Function call with a parameter of "Z" (string) + default parameter (didn't specify)
  BlockOfValues("Z");

  return 0; 

}