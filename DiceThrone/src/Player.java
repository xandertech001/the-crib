//Player class
import java.util.Random;


//This is the player class that holds all of the information and attributes for the characters.
class Player {

    /*This is the declaration of the variables used for the characters.
    The player's name is a string.*/
    String PlayerName;
    /*The player's clase is a string.*/
    String PlayerClass;
    /*The character's health is an integer.*/
    int PlayerHealth;
    /*The character's experience is an integer.*/
    int experience;
    /*The character's strength is an integer.*/
    int strength;
    /*The character's agility is an integer.*/
    int agility;
    /*The character's resilience is an integer.*/
    int resilience;
    /*The character's defence is an integer.*/
    int deftness;
    /*The character's magic defence is an integer.*/
    int magical_might;
    /*The character's health pool is an integer.*/
    int healtPool;

    /*Assigns the player name and the Player Class */

    Player(String givenName, String givenClass) {
        /*The player's name is equal to the given name.*/
        this.PlayerName = givenName;
        /*The player's class is equal to the given class.*/
        this.PlayerClass = givenClass;
    } //end player

    /*This function sets the attributes for each character and how they are unique in combat and during rounds.*/
    void setAttributes() {

        /*If the player's class is Warrior, do the following:*/
        if (this.PlayerClass == "Warrior") {
            /*Set the variables of the class to these integers.*/
            this.PlayerHealth = 26;
            this.strength = 6;
            this.agility = 2;
            this.resilience = 6;
            this.magical_might = 0;
            /*All of the previous attributes are added together and divided by 2 to determine the character's health pool.*/
            this.healtPool = (this.PlayerHealth + this.strength + this.agility + this.resilience + this.magical_might) / 2;
        } //end if 
        /*If the player's class is Mage, do the following:*/
        if (this.PlayerClass == "Mage") {
            /*Set the variables of the class to these integers.*/
            this.PlayerHealth = 20;
            this.strength = 0;
            this.agility = 1;
            this.resilience = 6;
            this.magical_might = 6;
            /*All of the previous attributes are added together and divided by 2 to determine the character's health pool.*/
            this.healtPool = (this.PlayerHealth + this.strength + this.agility + this.resilience + this.magical_might) / 2;
        } //end if
    } //end function

    /*This function  will  print out the player stats*/
    void introduceSelf() {
        /*Output these statements*/
        System.out.println("My name is " + this.PlayerName);
        System.out.println("My Class is " + this.PlayerClass);
        System.out.println("My Health is " + this.PlayerHealth);
        System.out.println("My agility is " + this.agility);
        System.out.println("My resilience is " + this.resilience);
        System.out.println("My magical_might is " + this.magical_might);
        System.out.println("My healtPool is " + this.healtPool);
        System.out.println("");
    } //end function

    /*This is the function to resolve the damage applied to each player.*/
   
    void ApplyDamage(int Damage) {
        /*It will subtract damage from the health pool and make it the new health total.*/
        this.healtPool = this.healtPool - Damage;
        /*Output these statements*/
        System.out.println(this.PlayerName + " was hit for " + Damage + " Damage. " + this.PlayerClass + "'s healtpool is now: " + this.healtPool);
        System.out.println("");
    } //end function

    /*This is the function that will simulate die being rolled.*/
    int rolldice() {

        /*Total number of dice is set to  3*/
        int numberOfDice = 3;

        /*Initializing the Random object for generating random numbers.*/
        Random ranNum = new Random();

        /*Output this statement*/
        System.out.print(this.PlayerName + " You rolled: ");
        
        /*Both the total rolled and the integer for the random number are set to 0*/
        int total = 0; 
        int randomNumber = 0; 


        for (int i = 0; i < numberOfDice; i++) {

            // Generating the random number and storing it in the 'randomNumber' variable.*/
            randomNumber = ranNum.nextInt(6) + 1;
            total = total + randomNumber;
            /*Output these statement.*/
            System.out.print(randomNumber);
            System.out.print(" ");
        } //end for

        /*Output these statement.*/
        System.out.println("");
        System.out.println("Total: " + total);
        /*Return total rolled.*/
        return total;

    } //end function

    /*This function take a number and select an ability based on the value */
    int selectAbility(int RandomDiceSum) {
    	
        /*Damage is an integer and equals 0.*/
        int damage = 0;

        /*Output the class*/
        System.out.println(this.PlayerClass);

        /*Switch is used to determine which class that character is.*/
        switch (this.PlayerClass) {
            /*If the case is that the character is a Warrior, do the following:*/
            case "Warrior":

                /*If the sum of the random dice is less than 6, do the following:*/
                if (RandomDiceSum < 6) {
                    /*Set the damage equal to that of ability 1.*/
                    damage = this.Ability(1);
                } //end if 
                /*if not then if the sum of the random dice is greater than or equal to 6 and is less than 12, do the following:*/
                else if (RandomDiceSum >= 6 && RandomDiceSum < 12) {
                    /*Set the damage equal to that of ability 2.*/
                    damage = this.Ability(2);
                } //end if 
                /*if neither of the following were true, do the following:*/
                else {
                    /*Set the damage equal to that of ability 3.*/
                    damage = this.Ability(3);
                } //end else

                /*Stop*/
                break;
                /*If the case is that the character is a Mage, do the following:*/
            case "Mage":
                /*If the sum of the random dice is less than 6, do the following:*/
                if (RandomDiceSum < 6) {
                    /*If the sum of the random dice is less than 6, do the following:*/
                    damage = this.Ability(1);
                } //end if 
                /*If not then if the sum of the random dice is greater than or equal to 6 and is less than 12, do the following:*/
                else if (RandomDiceSum >= 6 && RandomDiceSum < 12) {
                    /*Set the damage equal to that of ability 2.*/
                    damage = this.Ability(2);
                } //end if 
                /*If neither of the following were true, do the following:*/
                else {
                    /*Set the damage equal to that of ability 3.*/
                    damage = this.Ability(3);
                } //end else
        } //end switch 
        /*Return the damage amount.*/
        return damage;

    } //end function

    /*This is the function that declares each ability for each class.*/
    /*Set the variable attack as an integer.*/
    int Ability(int attack) {
        /*Ability damage is set to 0.*/
        int AbilityDamage = 0;
        /*Switch is used to determine which class that character is.*/
        switch (this.PlayerClass) {
            /*If the case is that the character is a Warrior, do the following:*/
            case "Warrior":
                /*If the attack amount is equal to 1, do the following:*/
                if (attack == 1) {
                    /*Output this statement.*/
                    System.out.println("The Warrior ability BASH was activated.");
                    /*Set ability damage to 2.*/
                    AbilityDamage = 2;

                } //end if
                /*If the above if statement was not true, and if the attack amount is equal to 2, do the following:*/
                else if (attack == 2) {
                    /*Output this statement.*/
                    System.out.println("The Warrior ability Thunderstrike was activated.");
                    /*Set ability damage to 4.*/
                    AbilityDamage = 4;
                } //end if 
                /*If both above if statements was not true, do the following:*/
                else {
                    /*Output this statement.*/
                    System.out.println("The Warrior ability OverPower was activated.");
                    /*Set ability damage to 6.*/
                    AbilityDamage = 6;
                } //end else
                /*Stop*/
                break;

                /*If the case is that the character is a Mage, do the following:*/
            case "Mage":
                /*If the attack amount is equal to 1, do the following:*/
                if (attack == 1) {
                    /*Output this statement.*/
                    System.out.println("The Mage ability Burning Soul was casted.");
                    /*Set ability damage to 4.*/
                    AbilityDamage = 4;
                } //end if
                else if (attack == 2) {
                    /*Output this statement.*/
                    System.out.println("The Mage ability Pyro blast casted.");
                    /*Set ability damage to 5.*/
                    AbilityDamage = 5;
                } //end if
                else {
                    /*Output this statement.*/
                    System.out.println("The Mage ability Meteorite casted.");
                    /*Set ability damage to 8.*/
                    AbilityDamage = 8;
                } //end else
                /*Stop*/
                break;

        } //end switch 
        /*Return the total damage delt by an ability*/
        return AbilityDamage;
    } /*End Function selectAbility*/

} /* end class */





