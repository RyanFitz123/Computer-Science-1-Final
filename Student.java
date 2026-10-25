package Final;
//Connects the files in the package

import java.util.Scanner;
//Imports a library

public class Student {
    //This class creates Student objects and provides interactivity with the objects

    Scanner input = new Scanner(System.in);
    //Creates a scanner object

    String name;
    int grade;
    //Attributes for Student

    Student(){
        
    }
    //Constructor

    void inputName(){
        name = input.next();
    }
    //Method to enter the student name

    void inputGrade(){
        grade = input.nextInt();
    }
    //Method to enter the student grade    
}