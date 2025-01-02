package org.example;


import java.util.Locale;
import java.util.Scanner;//Import the scanner class.Aside from taking user input, this class will also be used to read file
import java.io.FileWriter;//Import this class to write to file
import java.io.IOException;//Import this file to handle errors
import java.io.File;//Import the file class
import java.io.FileNotFoundException;//Import this class to handle error when reading file
public class Team_Member {


    static void homeMenu(){//Display menu
       System.out.println("1.Menu");
       System.out.println("2.Create new analysis");
       System.out.println("3.Save new analysis");
       System.out.println("4.View analysis report");
    }

    static void createFile(){//Create a new file called "textanalysis.txt"
        try {
            File myCreation = new File("textanalysis.txt");
            myCreation.createNewFile();
        } catch (IOException e) {
            System.out.println("Error");//If error occurs throw an IOException
            e.printStackTrace();
        }
    }

    static void analysisOpt(){
//Assign each option to a fixed variable
        final int createAnalysis = 1;
        final int saveAnalysis = 2;
        final int viewAnalysis = 3;
        final int exitMenu = 4;
        int choice;//Create a variable called choice

do {
    //Prompt user to pick an option
    System.out.println("Please pick an option from the menu:");
    Scanner input = new Scanner(System.in);
    choice = input.nextInt();//Read user input into the choice variable
    String text = null;//Create a variable called text

    //Call the feedback analysis class to analyze text
    Feedback_Analysis myObj = new Feedback_Analysis();//Create a new object

    switch (choice){
        case createAnalysis:
            //Prompt user to enter text
            System.out.println("Enter text here:");
             text = input.nextLine();//Read user input into the text variable

            //Analyse the input(text) that was written into the text variable
             myObj.testAnalysis(text);

             break;

        case saveAnalysis:
            //Prompt user to make a choice between 'S' and 'N'
            System.out.println("Click 'S' to save or 'N' to exit");
            String opt = input.nextLine().toLowerCase();
           // Feedback_Analysis myObj2 = new Feedback_Analysis();
            String view =  myObj.testAnalysis(text);//Assign the text analysis to a variable
            createFile();//Call the createFile method
            if (opt == "S") {
                try {
                    //Write the text and text analysis to a file ,if user choice is 'S'
                    FileWriter myWord = new FileWriter("textanalysis.txt");
                    myWord.write(text + view);
                    System.out.println("This analysis has been saved successfully");
                } catch (IOException e) {
                    System.out.println("Error");//If error occurs throw an IOException
                    e.printStackTrace();
                }
            } else if (opt == "N"){
                continue;
            }
            break;

        case viewAnalysis:
            //Read text from the  text analysis.txt file to view it
              try{
                 File mySight = new File("textanalysis.txt");
                 Scanner reader = new Scanner(mySight);
                 while (reader.hasNextLine()) {
                     String data = reader.nextLine();
                     System.out.println(data);

                 }
                 reader.close();
               } catch (FileNotFoundException e){
                  System.out.println("Error");
                    e.printStackTrace();//If error occurs throw an IOException
               }

            break;

        case exitMenu:
            //prompt user for a choice
            System.out.println("Are you sure you want to exit the menu");
            String answer = input.nextLine().toUpperCase();
            if (answer == "yes"){
                //If choice is "yes" exit
                System.out.println("Exiting...");
                System.out.println("Have a great day!");//Print message
            } else if (answer == "no"){//If choice is "no" return to menu
                System.out.println("Returning to menu ...");
                continue;
            }

            break;
        }

    }while (choice != exitMenu);

    }

    public static void analyseFeedback(){
        homeMenu();//Call the homeMenu method

       analysisOpt();//Call the analysisOpt method



    }

}

