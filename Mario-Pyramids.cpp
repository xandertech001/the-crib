/* 
Xander Rivera 
Computer Programming 1A (C++)
2/24/22
Mario Pyramids 

This program will recreate mario half and full pyramids to at which the user can control the height.
*/

//Preprocessor directive library
#include <iostream> 

//Standard namespace
using namespace std; 


//Printing function to lay lines of bricks 
void placeBricks(int length, char symbol){ 
	for(int i = 0; i < length; i++) { 
		cout << symbol;
	}
} 

//Printing function for bricks on the left side
void leftPyramid(int height){
  for (int i = 1; i<=height; i++){ 
		placeBricks(i, '#'); 
		cout << endl;
	} 
} 

//Printing function for bricks on the right side
void rightPyramid(int height){ 
	for(int i = 1; i <= height; i++){ 
		for (int j = i; j < height; j++){ 
			cout << " ";
		}	
		placeBricks(i, '#'); 
		cout << endl;
	}
}

//Printing function for bricks on both sides
void oneOne(int height){ 
	for(int i = 1; i <= height; i++){ 
		for (int j = i; j < height; j++){
			cout << " ";
		}
		placeBricks(i, '#');
		cout << " ";
		placeBricks(i, '#');
		cout << endl;;
	}		
}

//Main Function
int main() {  

  //variables for menu, height, and user selection within menu
	int menu = 1, inputHeight, userSelection;

  //While loop that acts as a menu
	while (menu == 1){  

    //Menu layout
    cout << "\n\t1) Left Pyramid" << endl;
		cout << "\t2) Right Pyramid" << endl;
		cout << "\t3) Level 1-1 Pyramid" << endl;
	  cout << "\t4) Quit" << endl; 
    cout << "-------------------------------" << endl;

    //Take in user selection
    cin >> userSelection; 

    //Switch for different menu options
    switch (userSelection){ 

      //For when the user wants a left pyramid
      case 1:{ 

        //Do while to prevent malicious input
        do { 
        cout << "Enter the height of the pyramid (within 1 - 23): " << endl;
        cin >> inputHeight;
        }while ((inputHeight <= 0 || inputHeight > 23));
        cout << endl;

        //Function call for pyramid
        leftPyramid(inputHeight);
        break;
      }

      //For when the user wants a right pyramid
      case 2:{ 

        //Do while to prevent malicious input
        do { 
        cout << "Enter the height of the pyramid (within 1 - 23): " << endl;
        cin >> inputHeight;
        }while ((inputHeight <= 0 || inputHeight > 23));
        cout << endl;

        //Function call for pyramid
        rightPyramid(inputHeight);
        break;
      } 

      //For when the user wants a full (1 - 1) pyramid
      case 3: {

        //Do while to prevent malicious input
        do { 
        cout << "Enter the height of the pyramid (within 1 - 23): " << endl;
        cin >> inputHeight;
        }while ((inputHeight <= 0 || inputHeight > 23));
        cout << endl;

        //Function call for pyramid
        oneOne(inputHeight);
        break;
      }

      //When the user wants to quit
      case 4: {
        menu = 0;
        break;
      }
    }//end switch
	}//end while
}//end main