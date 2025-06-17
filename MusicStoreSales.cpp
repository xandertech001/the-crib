/* 
Xander Rivera 
Computer Programing 1A (C++)
9/23/21
Music store

This program will take user input and use outputs to display various music sales and compare them to each other. 
*/

//Preprocesor directive library
#include <iostream> 
//Standard namespace
using namespace std; 

//Constant format int
const int width = 25;

//Main Function
int main() { 

  //Variables to contain name of the first artist and album
  string artistName1;
  string albumName1;

  //Variables to contain name of the second artist and album
  string artistName2;
  string albumName2;

  //Variables to contain name of the third artist and album
  string artistName3;
  string albumName3;

  //Variables to contain the first albums sold on the west and east coasts 
  long eastSales1; 
  long westSales1; 

  //Variables to contain the second albums sold on the west and east coasts 
  long eastSales2; 
  long westSales2; 

  //Variables to contain the third albums sold on the west and east coasts 
  long eastSales3; 
  long westSales3; 

  //Variable to constain the first price of the albums
  double cost1;
  double cost2; 
  double cost3; 


  //1st Artist

  //Ask for for name of the first artist 
  cout << "\nArtist 1: ";
  //Save user input as the artist's name 
  getline(cin,artistName1);

  //Ask for the name of the album 
  cout << artistName1 << "'s album: "; 
  //Save user input as the artist's album name 
  getline(cin,albumName1); 

  //Ask for how many album copies sold on the east coast 
  cout << "Copies of " << artistName1 << "'s " << albumName1 << " sold on the east coast: "; 
  //Save user input as the number of albums sold on the east coast 
  cin >> eastSales1;
  //Ignore enter key 
  cin.ignore(); 

  //Ask for how many album copies sold on the west coast 
  cout << "Copies of " << artistName1 << "'s " << albumName1 << " sold on the west coast: "; 
  //Save user input as the number of albums sold on the west coast 
  cin >> westSales1;
  //Ignore enter key 
  cin.ignore(); 

  //Ask for the cost of the album 
  cout << "Cost of " << albumName1 << ": $"; 
  //Save user input as the cost of the album 
  cin >> cost1;
  //Ignore enter key 
  cin.ignore(); 


  //2st Artist

  //Ask for for name of the second artist 
  cout << "\nArtist 2: ";
  //Save user input as the artist's name 
  getline(cin,artistName2);

  //Ask for the name of the album 
  cout << artistName2 << "'s album: "; 
  //Save user input as the artist's album name 
  getline(cin,albumName2); 

  //Ask for how many album copies sold on the east coast 
  cout << "Copies of " << artistName2 << "'s " << albumName2 << " sold on the east coast: "; 
  //Save user input as the number of albums sold on the east coast 
  cin >> eastSales2;
  //Ignore enter key 
  cin.ignore(); 

  //Ask for how many album copies sold on the west coast 
  cout << "Copies of " << artistName2 << "'s " << albumName2 << " sold on the west coast: "; 
  //Save user input as the number of albums sold on the west coast 
  cin >> westSales2;
  //Ignore enter key 
  cin.ignore(); 

  //Ask for the cost of the album 
  cout << "Cost of " << albumName2 << ": $"; 
  //Save user input as the cost of the album 
  cin >> cost2;
  //Ignore enter key 
  cin.ignore(); 


  //3st Artist

  //Ask for for name of the second artist 
  cout << "\nArtist 3: ";
  //Save user input as the artist's name 
  getline(cin,artistName3);

  //Ask for the name of the album 
  cout << artistName3 << "'s album: "; 
  //Save user input as the artist's album name 
  getline(cin,albumName3); 

  //Ask for how many album copies sold on the east coast 
  cout << "Copies of " << artistName3 << "'s " << albumName3 << " sold on the east coast: "; 
  //Save user input as the number of albums sold on the east coast 
  cin >> eastSales3;
  //Ignore enter key 
  cin.ignore(); 

  //Ask for how many album copies sold on the west coast 
  cout << "Copies of " << artistName3 << "'s " << albumName3 << " sold on the west coast: "; 
  //Save user input as the number of albums sold on the west coast 
  cin >> westSales3;
  //Ignore enter key 
  cin.ignore(); 

  //Ask for the cost of the album 
  cout << "Cost of " << albumName3 << ": $"; 
  //Save user input as the cost of the album 
  cin >> cost3;
  //Ignore enter key 
  cin.ignore(); 



  //Final Music Output



  //Set format to start from the left
  cout.setf(ios::left);

  //Restrict decimal limit to 2 
  cout.setf(ios::fixed);
  cout.precision(2); 


  //Boarder 
  cout << "\n***************************************|^-_results_-^|***************************************\n";


  //Artists


  //Set width to the constant of 25
  cout.width(width); 
  //Output lable artist
  cout << "Artist";

  //Set width to the constant of 25
  cout.width(width); 
  //Output artist 1's name
  cout << artistName1; 

  //Set width to the constant of 25
  cout.width(width); 
  //Output artist 2's name
  cout << artistName2;  

  //Set width to the constant of 25
  cout.width(width); 
  //Output artist 3's name
  cout << artistName3 << endl;

  //Albums


  //Set width to the constant of 25
  cout.width(width);  
  //Output lable album
  cout << "Album";

  //Set width to the constant of 25
  cout.width(width); 
  //Output album 1's title
  cout << albumName1; 

  //Set width to the constant of 25
  cout.width(width); 
  //Output album 2's title
  cout << albumName2; 

  //Set width to the constant of 25
  cout.width(width); 
  //Output album 3's title
  cout << albumName3 << endl;


  //Total sold 


  //Set width to the constant of 25
  cout.width(width); 
  //Output lable total sold 
  cout << "Total Sold"; 

  //Set width to the constant of 25
  cout.width(width); 
  //Output the sum of sales for album 1
  cout << westSales1 + eastSales1;

  //Set width to the constant of 25
  cout.width(width);
  //Output the sum of sales for album 2
  cout << eastSales2 + westSales2;

  //Set width to the constant of 25
  cout.width(width);
  //Output the sum of sales for album 3
  cout << eastSales3 + westSales3 << endl; 

  //Total money made  


  //Set width to the constant of 25
  cout.width(width); 
  //Output lable for the total profit 
  cout << "Total $"; 

  //Set width to the constant of 25
  cout.width(width); 
  //Output total profit of album 1
  cout << (westSales1 + eastSales1) * cost1;

  //Set width to the constant of 25
  cout.width(width);
  //Output total profit of album 2
  cout << (eastSales2 + westSales2) * cost2;

  //Set width to the constant of 25
  cout.width(width);
  //Output total profit of album 3
  cout << (eastSales3 + westSales3) * cost3 << endl; 

  //Percent of albumns 

  //Use decimal number to turn the final percent to a decimal
  double myDeci = 1.0;

  //Set width to the constant of 25
  cout.width(width); 
  //Output percent of albums lable
  cout << "Percent Albums"; 

  //Set width to the constant of 25
  cout.width(width); 
  //Output the percent of album sold by album 1
  cout << (((westSales1 + eastSales1) * myDeci)  / (((westSales1 + eastSales1)* myDeci) + ((westSales2 + eastSales2)* myDeci) + ((westSales3 + eastSales3)* myDeci))) * 100;

  //Set width to the constant of 25
  cout.width(width); 
  //Output the percent of album sold by album 2
  cout << (((westSales2 + eastSales2) * myDeci)  / (((westSales1 + eastSales1)* myDeci) + ((westSales2 + eastSales2)* myDeci) + ((westSales3 + eastSales3)* myDeci))) * 100;


  //Set width to the constant of 25
  cout.width(width); 
  //Output the percent of album sold by album 3
  cout << (((westSales3 + eastSales3) * myDeci)  / (((westSales1 + eastSales1)* myDeci) + ((westSales2 + eastSales2)* myDeci) + ((westSales3 + eastSales3)* myDeci))) * 100 << endl;


  //Percent of profit


  //Set width to the constant of 25
  cout.width(width); 
  //Output total percent of profit lable 
  cout << "Percent $"; 

  //Set width to the constant of 25
  cout.width(width); 
  //Output total profit precent of album 1
  cout << ((westSales1 + eastSales1) * cost1) / (((westSales1 + eastSales1) * cost1) + ((westSales2 + eastSales2) * cost2) + ((westSales3 + eastSales3) * cost3)) * 100;

  //Set width to the constant of 25
  cout.width(width); 
  //Output total profit precent of album 2
  cout << ((westSales2 + eastSales2) * cost2) / (((westSales1 + eastSales1) * cost1) + ((westSales2 + eastSales2) * cost2) + ((westSales3 + eastSales3) * cost3)) * 100;

  //Set width to the constant of 25
  cout.width(width); 
  //Output total profit precent of album 3
  cout << ((westSales3 + eastSales3) * cost3) / (((westSales1 + eastSales1) * cost1) + ((westSales2 + eastSales2) * cost2) + ((westSales3 + eastSales3) * cost3)) * 100;


  //Boarder 
  cout << "\n***************************************|^-_results_-^|***************************************\n";

  //Return 0 if successful 
  return 0; 
}//End main