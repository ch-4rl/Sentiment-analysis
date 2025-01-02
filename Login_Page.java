package org.example;

import java.util.Scanner;
//This class is for the login page
public  class Login_Page {

     String login1; //Create a class attribute
     String username;
    String password = "Password: ";// Declare the variable as private

    static void nextPage() {
        System.out.println("You've successfully logged in");//Let the users know when they've successfully logged in
    }


    static void welcomeMethod() {
        //Greet the users
        System.out.println("WELCOME TO WHITE PANDA");
        System.out.println("Sign in");
    }

    public void signInMethod() {
        //Ask if they already have an account
        System.out.println("Please sign in");

    }


    public static void loginAccount() {

        welcomeMethod();//Call the welcomeMethod method

        Login_Page signIn = new Login_Page();

        signIn.signInMethod();//Call the signInMethod method
        Scanner scan = new Scanner(System.in);

        System.out.println(signIn.login1);//Print the content in the login1 attribute
        int length1 ;
        do {
         System.out.println(signIn.username);
            String name = scan.nextLine();//Prompt the user for their username
            length1 = name.length();
            if (length1 > 10){
                System.out.println("Invalid username");//Make sure they don't exceed a specific number of characters, else print "Invalid username"
                break;
            }
        } while (length1 <= 10);

        int length2;
        do {
          System.out.println(signIn.password);
          String passcode = scan.nextLine();//Prompt the user for their password
          length2 = passcode.length();
          if (length2 != 8){
            System.out.println("Invalid password");//Make sure they don't exceed a specific number of characters, else print "Invalid password"
           break;
          }
        }while (length2 == 8);


        nextPage();//Call the nextPage method
        Team_Member.analyseFeedback();//Call Team_Member class



    }
}


