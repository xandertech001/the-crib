/*

First, write code to answer the two questions below. The code does not need to compile;
you can just assume your answers would exist in some main method. Write your answers in this file.

    1. Imagine you have a primitive integer variable called numCars. Write an if statement
    that prints out "small" if the number of cars is less than two, "medium" if the number of 
    cars is between three and four, and "large" otherwise. (2 pts)

    int numCars = some number; 

    if (numCars < 2 ){ 
        System.out.println("small");
    }else if (numCars >= 3 && numCars <= 4){ 
        System.out.println("medium");
    }

    2. Imagine the user enters a primitve integer in a variable called number. Write an if 
    statement that prints out "fizz" if the number is divisible by 3, "buzz" if the number
    is divisible by 7, and "fizzbuzz" if the number is divisibile by both 3 and 7. Your 
    code should only print out one value for each such number. Be careful about how 
    you order your if-else statements here! (2 pts)

    int number = some number; 

    if (number % 3 == 0){ 
        if (number % 7 == 0){ 
        System.out.println("fizzball");
        }       
        System.out.println("fizz");
    }else if (number % 7 == 0){ 
        System.out.println("buzz");
    }

Next, trace through the code in each problem below by hand. Add the results of your trace into the 
this file; you can include comments in the code below, or write your answers here below. Then, run this file
to see if your result matches the expected result. (10 pts)

Submit Homework2.java to blackboard. 

Note the new syntax of using the String type in Java -- we will go over this
in more detail later in the semester.

*/

public class Homework2{

    public static void problem1(){
      int x = 10;
      boolean y = false;
      String result = "";
  
      if(x >= 10){*
          if (!y){*
              result = "medium";*
          }else{
              result = "average";
          }
      }else if(x >= 13){
          if(!y){
              result = "large";
          }else{
              result = "big";
          }
      }else
          result = "small";
  
    }
  
    public static void problem2(){
      int x = 10;
      boolean y = true;
      String result = "";
  
      if(x >= 10){*
          if (!y){
              result = "medium";
          }else{*
              result = "average";*
          }
      }else if(x >= 13){
          if(!y){
              result = "large";
          }else{
              result = "big";
          }
      }else
          result = "small";
  
    }
  
    public static void problem3(){
      int x = 16;
      boolean y = false;
      String result = "";
  
      if(x >= 10){*
          if (!y){*
              result = "medium";*
          }else{
              result = "average";
          }
      }else if(x >= 13){
          if(!y){
              result = "large";
          }else{
              result = "big";
          }
      }else
          result = "small";
  
    }
  
    public static void problem4(){
      int x = 16;
      boolean y = true;
      String result = "";
  
      if(x >= 10){*
          if (!y){*
              result = "medium";
          }else{*
              result = "average";*
          }
      }else if(x >= 13){
          if(!y){
              result = "large";
          }else{
              result = "big";
          }
      }else
          result = "small";
  
    }
  
    public static void problem5(){
      int x = 5;
      boolean y = true;
      String result = "";
  
      if(x >= 10){*
          if (!y){
              result = "medium";
          }else{
              result = "average";
          }
      }else if(x >= 13){*
          if(!y){
              result = "large";
          }else{
              result = "big";
          }
      }else*
          result = "small";*
  
    }
  
    public static void problem6(){
      boolean result = false || (false || true);
        //result is true
    }
  
    public static void problem7(){
      int x = 7;
      int result = 0;
  
      if(x >= 7){*
        result = 1;*
      }
      if (x >= 6){*
        result = 2;*
      }
  
    }
  
    public static void problem8(){
      int x = 7;
      int result = 0;
  
      if(x >= 7){*
        result = 1;*
      }
      if (x < 6){
        result = 2;
      }else{
        result = 3;
      }
  
    }
  
    public static void problem9(){
      boolean result = false && (false || true);
        //result is false
    }
  
    public static void problem10(){
      int num1 = 1;
      boolean condition = true && (num1 == 2);
      int result = num1;
      //result = 1
  
    }
  
    public static void main(String[] args){
      System.out.println("We expected medium for problem1");
      System.out.println("We expected average for problem2");
      System.out.println("We expected medium for problem3");
      System.out.println("We expected average for problem4");
      System.out.println("We expected small for problem5");
      System.out.println("We expected true for problem6");
      System.out.println("We expected 2 for problem7");
      System.out.println("We expected 3 for problem8");
      System.out.println("We expected false for problem9");
      System.out.println("We expected 1 for problem10");
    }
  
  }