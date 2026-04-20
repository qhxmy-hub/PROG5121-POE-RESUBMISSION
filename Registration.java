package com.mycompany.registration;
import java.util.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


public class Registration {

    public void main(String[] args) {

        Scanner obj = new Scanner(System.in);

        Login user = new Login();

        int choice;

        do {
            System.out.println("\n MENU ");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            choice = obj.nextInt();
            obj.nextLine();

            switch (choice) {

                case 1 -> register(user, obj);

                case 2 -> login(user, obj);

                case 3 -> System.out.println("Goodbye!");

                default -> System.out.println("Invalid Option.");
            }

        } while (choice != 3);

        obj.close();
    }

    // REGISTRATION PROCESS
    public  void register(Login user, Scanner obj) { 

        System.out.println("\n REGISTER ");

        // USERNAME INPUT
        while (true) {
            System.out.print("Enter username: ");
            String usernameInput = obj.nextLine();

            if(user.checkUserName(usernameInput)) {
                System.out.println("Username successfully captured!");
                user.userName = usernameInput;
                break;
            }else{
                System.out.println("Username must contain a '_' ");
                System.out.println("Username characters should not be more than 5 characters in length.");
            }
        }

        // PASSWORD INPUT
        while (true) {
            System.out.print("Enter password: ");
            String passwordInput = obj.nextLine();

            if(user.checkPasswordComplexity(passwordInput)) {
                System.out.println("Password successfully captured!");
                user.Password = passwordInput;
                break;
            }else{
                System.out.println("Password is not correctly formatted.");
                System.out.println("Password to contain at least 8 characters.");
                System.out.println("Password must contain a Uppercase."); 
                System.out.println("Password should contain a number.");
                System.out.println("Password must contain a special character.");
            }
        }

        // CELL PHONE NUMBER INPUT
        while(true) {
            System.out.print("Enter phone (+27...): ");
            String phoneInput = obj.nextLine();

            if(user.checkCellPhoneNumber(phoneInput)) { 
                System.out.println("Cell Phone Number successfully added!");
                user.cellPhoneNumber = phoneInput;
                break;
            }else{
                System.out.println("Cell Phone Number incorrectly formatted.");
                System.out.println("Cell Phone Number does not include international code.");
            }
        }

        System.out.println("Registration Successful!\n");
    }

    // LOGIN PROCESS
    public static void login(Login user, Scanner obj) { 

        System.out.println("\n LOGIN ");

        System.out.print("Enter username: ");
        String username = obj.nextLine();

        System.out.print("Enter password: ");
        String password = obj.nextLine();

        boolean status = user.loginUser(username, password);
        System.out.println(user.returnLoginStatus(status));
    }
}
   

    
   