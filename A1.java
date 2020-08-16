//imports necessary utils
import java.util.Random;
import java.util.Scanner;
/* Class        : Driver
   Description  : contains the main method program(), 
                  as well as 2 other methods essential for the program to run
   Author       : Rhyme Bulbul, S3850912
*/
public class A1 {  
    /*ALGORITHM
    BEGIN
        CREATE an instance of a Scanner to take user input
            CONTINUE to ask the user to select which function is needed 
                     3 times till valid input is entered
                CALL corresponding method to accomplish users desired function
                DISPLAY result
                EXIT program
    END
    */
    public void program() {
        //displays program menu options & asks user which function of the program is desired
        System.out.println("Welcome to Multifunction Program \n********************************* \n#Menu: \n\n*1. Unit Converter. \n\n*2. Check Lotto. \n\n*********************************\nPlease enter which function you would like to use:\n");

        //creates Scanner, takes user input & store it to call users desired method later
        Scanner scanner = new Scanner(System.in);
        int switchVariable = 0;
        switchVariable = scanner.nextInt();
        scanner.nextLine();

        //continues to ask user for input for the second time if input was invalid
        if (!(switchVariable == 1) && !(switchVariable == 2)) {
            System.out.println("Please enter which function you would like to use:");
            switchVariable = scanner.nextInt();
            scanner.nextLine();

            //continues to ask user for input for the third time if input was invalid
            if (!(switchVariable == 1) && !(switchVariable == 2)) {
                System.out.println("Please enter which function you would like to use:");
                switchVariable = scanner.nextInt();
                scanner.nextLine();

                //no longer continues to ask user for input since invalid data has already been entered 3 times
                if (!(switchVariable == 1) && !(switchVariable == 2)) {
                    System.out.println("You have entered an invalid input 3 times");
                } 
            } 
        } 
         
        //switches to menu option user has input via keyboard
        switch (switchVariable) {
            /*method for unit conversion is called & the result is displayed to the user*/
            case 1: {
                //Asks the user to select one of the available conversion types & stores   
                System.out.println("Welcome to Unit Converter \n\nPlease select one of the following conversions: \n\n0.Celsius to Fahrenheit. \n1.Kelvin to Fahrenheit. \n2.Celsius to Kelvin. \n3.Fahrenheit to Kelvin. \n4.Fahrenheit to Celsius. \n5.Kelvin to Celsius.\nPlease enter conversion type from the list:\n");
                int conversionType = scanner.nextInt();
                scanner.nextLine();

                //requests user for the value of date user wants converted & stores it as a double
                System.out.println("Please enter the measure of the data you want converted:");
                double conversionData = scanner.nextDouble();
                scanner.nextLine();
                
                //calls method convert, passes given arguments & displays the returned value & then exits
                System.out.printf("%f degrees.\nCalculations done.", convert(conversionType, conversionData));
                break;
            }

            //method for lotto checking is called & relevent lotto data is shown to the user
            case 2: {
                //asks the user to enter their 3 guessed lotto numbers within the given range 1 to 24
                System.out.println("Welcome to Lotto Checker\n");
                System.out.println("Please Enter your first lotto number:\n");
                int lottoNumber1 = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Please Enter your second lotto number:\n");
                int lottoNumber2 = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Please Enter your third lotto number:\n");
                int lottoNumber3 = scanner.nextInt();
                scanner.nextLine();

                //calls method checklotto & displays String returned, then exits
                System.out.printf("Lotto results published.\n %s", checkLotto(lottoNumber1, lottoNumber2, lottoNumber3));
                System.out.println("");
                break;
            }

            //incase none of the options are selected
            default: {
                System.out.println("You have selected none of the available functions.");
                break;
            }
        }
        //closes scanner, informs user & exits program
        scanner.close();
        System.out.println("Exiting program...\n***Program closed***");
    }
    /*ALGORITHM
    BEGIN
        SWITCH to conversion type as passed as argument
            performs required calculations & stores to a variable
        RETURNS the answer from the variable
    END
    */
    private double convert(int operation, double number1) {

        //defines temperature constant values required for unit conversion & variable to return answer
        final double FAHRENHEIT_CONSTANT = 32;
        final double KELVIN_CONSTANT = 273.15;
        final double CELSIUS_CONSTANT = 5.0/9;
        double answerReturned;
        //takes argument provided for unit conversion & switches to it
        switch (operation) {
            //performs required calculations to convert from celsius to fahrenheit
            case 0:
                System.out.printf("%f degrees Celsius in Fahrenheit is ", number1);
                answerReturned = ((number1 / CELSIUS_CONSTANT) + FAHRENHEIT_CONSTANT);
                break;
            //performs required calculations to convert from kelvin to fahrenheit
            case 1:
                System.out.printf("%f degrees Kelvin  in Fahrenheit is ", number1);
                answerReturned = (((number1 - KELVIN_CONSTANT) / CELSIUS_CONSTANT) + FAHRENHEIT_CONSTANT);
                break;
            //performs required calculations to convert from celsius to kelvin
            case 2:
                System.out.printf("%f degrees Celsius in Kelvin is ", number1);
                answerReturned = (number1 + KELVIN_CONSTANT);
                break;
            //performs required calculations to convert from fahrenheit to kelvin
            case 3:
                System.out.printf("%f degrees Fahrenheit in Kelvin is ", number1);
                answerReturned = ((number1 - FAHRENHEIT_CONSTANT) * CELSIUS_CONSTANT + KELVIN_CONSTANT);
                break;
            //performs required calculations to convert from fahrenheit to celsius
            case 4:
                System.out.printf("%f degrees Fahrenheit in Celsius is ", number1);
                answerReturned = ((number1-FAHRENHEIT_CONSTANT) * CELSIUS_CONSTANT);
                break;
            //performs required calculations to convert from kelvin to celsius
            case 5:
                System.out.printf("%f degrees Kelvin in Celsius is ", number1);
                answerReturned = (number1-KELVIN_CONSTANT);
                break;
            //returns a default value of -1 incase none of defined switches are used
            default:
                answerReturned =  -1.0;
                break; 
        }
        return answerReturned;
    }
    /*ALGORITHM
    BEGIN
        IF passed arguments are within defined range
            CREATE 8 random numbers & store them
                IF guess is equal to any random lotto number, store to variable & increase count by 1
        STORE lotto results in a formatted String
        RETURN formatted String
    END
    */
    private String checkLotto(int chosen1, int chosen2, int chosen3) {
        //defines upper range for possible lotto numbers proceeds if passed arguments are valid
        final int upperLotto = 24;
        if(((chosen1 < 1 ) || (chosen1 > upperLotto )) || ((chosen2 < 1 ) || (chosen2 > upperLotto )) || ((chosen3 < 1 ) || (chosen3 > upperLotto ))){
            return("You are trying to guess a lotto number out of the range 1 to 24.");
        }  else {
            //creating a new random number generator & storing 8 random numbers within the range
            Random random = new Random();
            int number1 = random.nextInt(upperLotto) +1;
            int number2 = random.nextInt(upperLotto) +1;
            int number3 = random.nextInt(upperLotto) +1;
            int number4 = random.nextInt(upperLotto) +1;
            int number5 = random.nextInt(upperLotto) +1;
            int number6 = random.nextInt(upperLotto) +1;
            int number7 = random.nextInt(upperLotto) +1;
            int number8 = random.nextInt(upperLotto) +1;
            //defining variables to store lotto results
            int correctGuessCount = 0;
            String correctChosen1;
            String correctChosen2;
            String correctChosen3;
            String answerReturned;
            //stores guesses if a valid lotto number, otherwise stores an empty String
            if ((chosen1 == number1) || (chosen1 == number2) || (chosen1 == number3) || (chosen1 == number4) ||
                    (chosen1 == number5) || (chosen1 == number6) || (chosen1 == number7) || (chosen1 == number8)) {
                        correctChosen1  = Integer.toString(chosen1);
                        correctGuessCount++;
            } 
            else correctChosen1 = "";

            if ((chosen2 == number1) || (chosen2 == number2) || (chosen2 == number3) || (chosen2 == number4) ||
                    (chosen2 == number5) || (chosen2 == number6) || (chosen2 == number7) || (chosen2 == number8)) {
                        correctChosen2 = Integer.toString(chosen2);
                        correctGuessCount++;
            } 
            else correctChosen2 = "";

            if ((chosen3 == number1) || (chosen3 == number2) || (chosen3 == number3) || (chosen3 == number4) ||
                    (chosen3 == number5) || (chosen3 == number6) || (chosen3 == number7) || (chosen3 == number8)) {
                    correctChosen3 = Integer.toString(chosen3);
                    correctGuessCount++;
            } 
            else correctChosen3 = "";
            //Formats & stores lotto data based on whether there were any correct draws or not in a String
            if (correctGuessCount == 0) {
                answerReturned = String.format("Numbers %d, %d, %d, %d, %d, %d, %d & %d were drawn, and you chose numbers %d,% d,% d. Amount of correct guesses in the draw is %d. You didn't correctly guess any numbers.",
                 number1,  number2,  number3,  number4,  number5, number6, number7, number8, chosen1, chosen2, chosen3, correctGuessCount);
            } else {
                answerReturned = String.format("Numbers %d, %d, %d, %d, %d, %d, %d & %d were drawn, and you chose numbers %d,% d,% d. Amount of correct guesses in the draw is %d. You correctly guessed %s %s %s. ",
                 number1,  number2,  number3,  number4,  number5, number6, number7, number8, chosen1, chosen2, chosen3, correctGuessCount , correctChosen1, correctChosen2, correctChosen3);
            }
            //returns formatted strings
            return answerReturned;
        }
    }
}
