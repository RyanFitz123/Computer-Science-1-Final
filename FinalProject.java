package Final;
//Connects the files in the package

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
//Imports libraries

public class FinalProject {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        //Initializes scanner

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> grades = new ArrayList<Integer>();
        //Creates and ArrayList for names and grades
        
        System.out.println("Welcome to Student Grade Management System");
        
        System.out.println("1. Add Student and Grade");
        System.out.println("2. Display All Students and Grades");
        System.out.println("3. Find a Student's Grade");
        System.out.println("4. Calculate Class Average");
        System.out.println("5. Find Highest and Lowest Grades");
        System.out.println("6. Exit");
        //Prints out user choices

        while (true){
            //This while loop is so that you can always choose an option after you complete the past option you chose
            
            while (true){
                //This while loop is for repeating the same choice in case of an exception
                
                try {
                    
                    System.out.println("Enter your choice: ");
                    int choice = input.nextInt();    
                    //User enters their choice which becomes a variable
                    
                    if (choice == 1){
                    //If user chooses 1

                    Student newStudent = new Student();
                    //Creates a new student object

                    while (true) {
                        //Repeats student name input until entered correctly

                        try {
                            System.out.println("Enter student name: ");
                            newStudent.inputName();
                            //Uses a method of Student to enter a name

                            break;

                        } catch (Exception e) {
                            System.out.println("Invalid name! Please input a string.");
                        }
                    }

                    while (true) {
                        //Repeats student grade input until entered correctly

                        try {
                            while (true){
                                System.out.println("Enter student grade: ");
                                newStudent.inputGrade();
                                //Uses a method of Student to enter a grade

                                if (newStudent.grade >= 0 && newStudent.grade <= 100){
                                    //If the grade is between 0 and 100 the loop will end

                                    break;

                                } else {
                                    System.out.println("Invalid grade! Please enter a vlue between 0 and 100.");
                                }
                            }
                            
                            break;

                        } catch (Exception e) {
                            System.out.println("Invalid grade! Please input an integer.");
                        }
                    }

                    names.add(newStudent.name);
                    grades.add(newStudent.grade);
                    //Adds the name to the names ArrayList and the grade to the grades ArrayList

                } else if (choice == 2){
                    //If user chooses 2

                    if (grades.size() > 0){
                        //If there are students in the system the choice will proceed
                        
                        System.out.println("List of Students and Grades: ");
                        
                        for (int i = 0; i < names.size(); i++){
                            System.out.println(names.get(i) + " - " + grades.get(i));
                        }
                        //Loops through the ArrayLists to display the names and grades
                    } else {
                        //If there are no students in the system the following will print
                        System.out.println("There are no students in the system! Please add students.");
                    }

                } else if (choice == 3){
                    //If user chooses 3

                    if (grades.size() > 0){
                        //If there are students in the system the choice will proceed

                        while (true){
                            //Loops until student name is entered correctly
                            try {

                                System.out.println("Enter student name: ");
                                int target = names.indexOf(input.next());
                                //Finds the index of the name being searched for and sets it as the variable "target"

                                System.out.println(names.get(target) + "'s Grade: " + grades.get(target));
                                //Prints the name and grade of the target index

                                break;

                            } catch (Exception e) {
                                
                                System.out.println("Invalid name! Please input a correct name.");
                            
                            }
                        }
                    } else {
                        //If there are no students in the system the following will print
                        System.out.println("There are no students in the system! Please add students.");
                    }

                } else if (choice == 4){
                    //If user chooses 4

                    if (grades.size() > 0){
                        //If there are students in the system the choice will proceed
                        
                        System.out.println("Class Average: " + gradesAverage(grades));
                        //Uses the gradesAverage function at the bottom
                    } else {
                        //If there are no students in the system the following will print
                        System.out.println("There are no students in the system! Please add students.");
                    }

                } else if (choice == 5){
                    //If user chooses 5

                    if (grades.size() > 0){
                        //If there are students in the system the choice will proceed
                        
                        int targetHigh = grades.indexOf(Collections.max(grades));
                        int targetLow = grades.indexOf(Collections.min(grades));
                        //Collections.max/min finds the max/min element in the grades ArrayList and sets its index to the "targetHigh/targetLow" variable (/ is used for interchangeable words, ex. max can replace the word min)

                        System.out.println("Highest Grade: " + names.get(targetHigh) + " - " + grades.get(targetHigh));
                        System.out.println("Lowest Grade: " + names.get(targetLow) + " - " + grades.get(targetLow));
                        //Prints the highest and lowest grades as well as the names of the students with those grades
                    } else {
                        //If there are no students in the system the following will print
                        System.out.println("There are no students in the system! Please add students.");
                    }

                } else if (choice == 6){
                    //If user chooses 6

                    System.out.println("Exiting...");
                    System.exit(0);
                    //Exits the program

                } else {
                    //If user chooses anything else it will tell the user and loop again
                    System.out.println("Invalid input! Please choose an option between 1 and 6.");
                }

                break; 

                } catch (Exception e) {
                    System.out.println("Invalid input! Please choose an option.");
                }
            }

            System.out.println();
            //This is for readability. It adds a line after each iteration

        }
    }


static double gradesAverage (ArrayList<Integer> grades) {
    //This function takes in an ArrayList with integers and calculates the average of all the numbers

    double numerator = 0;
    double denominator = 0;
    //Initializes the numerator and denominator variables

    for (int i = 0; i < grades.size(); i++){
        //This loop will do a loop for every element in the grades ArrayList

        numerator = numerator + grades.get(i);
        //Adds a grade the numerator

        denominator = i + 1;
        //Adds the total amount of grades added to the numerator to the denominator
    }

    double average = numerator / denominator;
    //Calculates the average by dividing

    return average;
    //Returns the average
}
}