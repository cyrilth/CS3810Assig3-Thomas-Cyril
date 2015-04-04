/*
 * Cyril Thomas CS3810 DS&A Assignment 3 04/06/14
 * StudentListApp Class :- Main Class to test RecordList Class using Link and Student Class
 * 
 * Strategy:
 * 	(01) Try and Catch in a do while loop is created to check whether User Input is Integers or not where required. 
 * 	(02) Switch Case statement was used inside Try and catch.
 *  (03) All remove functions and the display function had if condition to check whether it is empty or not.
 * */

import java.util.*;
import java.io.*;

public class StudentListApp 
{

	public static void main(String[] args)
	
	{
		RecordList newList = new RecordList();
		Scanner scan = new Scanner(System.in);
		int input;
		String name;
		int number;
		String Id;
		Student newStudent = new Student();
		
		
		do
		{
			System.out.println("\nEnter: 1 to Add Student to Front of the List");
			System.out.println("Enter: 2 to Add Student to Last of the List");
			System.out.println("Enter: 3 to Remove Student from front of the List");
			System.out.println("Enter: 4 to Remove Student from Last of the List");
			System.out.println("Enter: 5 to Insert After a Student on the List");
			System.out.println("Enter: 6 to Delete a Specfic Student");
			System.out.println("Enter: 7 to Display from front of the List");
			System.out.println("Enter: 8 to Display from Last of the List");
			System.out.println("Enter: 9 to Sort the List");
			System.out.println("Enter: 0 to Quit");
			System.out.print("\nEnter : ");
			
			
			/*try
			{*/
				input = scan.nextInt();
						
				switch(input)
				{
					case 1:
					{
						scan.nextLine();
						System.out.print("\nEnter Student Name: ");
						name = scan.nextLine();
						System.out.print("\nEnter Student Id (integers): ");
						number = scan.nextInt();
						Id = Integer.toString(number);
						newStudent =new Student(name, Id);
						newList.insertFirst(newStudent);
						scan.nextLine();
						break;
					}//Gets input from the user to create Student object and then insert the student object into Front of  RecordList
					
					case 2:
					{
						scan.nextLine();
						System.out.print("\nEnter Student Name: ");
						name = scan.nextLine();
						System.out.print("\nEnter Student Id (integers): ");
						number = scan.nextInt();
						Id = Integer.toString(number);
						newStudent =new Student(name, Id);
						newList.insertLast(newStudent);
						scan.nextLine();
						break;
					}//Gets input from the user to create Student object and then insert the student object into Last of  RecordList
					
					case 3:
					{
						if(newList.isEmpty())
						{
							System.out.println("The List is Empty");
							scan.nextLine();
							break;
						}
						else
						{
							Link newTemp = newList.deleteFirst();
							System.out.println(newTemp.toString());
							scan.nextLine();
							break;
						}
					}//Removes Student object from the front of the RecordList
					
					case 4:
					{
						if(newList.isEmpty())
						{
							System.out.println("The List is Empty");
							scan.nextLine();
							break;
						}
						else
						{
							Link newTemp = newList.deleteLast();
							System.out.println(newTemp.toString());
							scan.nextLine();
							break;
						}
					}//Removes Student object from the last of the RecordList
					
					case 5:
					{
						scan.nextLine();
						System.out.print("\nEnter the name of the Student Already on the List: ");
						String tempName = scan.nextLine();
						System.out.print("\nEnter the Id of the Student Already on the List: ");
						int tempNumber = scan.nextInt();
						String tempId = Integer.toString(tempNumber);
						Student tempStudent = new Student(tempName, tempId);
						scan.nextLine();
						System.out.print("\nEnter new Student name: ");
						name = scan.nextLine();
						System.out.print("\nEnter new Student Id (integers): ");
						number = scan.nextInt();
						Id = Integer.toString(number);
						newStudent =new Student(name, Id);
						
						boolean success =newList.insertAfter(tempStudent, newStudent);
						if(success)
							System.out.println("\nNew Student added to the list");
						else
							System.out.println("\nAddition Failed. Please Try again!!!");
						scan.nextLine();
						break;
					}//Takes Input from user to match it with existing student and also to create a new student object to insert after the matched student
					
					case 6:
					{
						scan.nextLine();
						System.out.print("\nEnter Student Name to remove: ");
						name = scan.nextLine();
						System.out.print("\nEnter Student Id (integers) to remove: ");
						number = scan.nextInt();
						Id = Integer.toString(number);
						newStudent =new Student(name, Id);
						Link newTemp = newList.deleteKey(newStudent);
						System.out.println(newTemp.toString());
						scan.nextLine();
						break;
					}//Deletes a Specific student by matching the inputed student values.
					
					case 7:
					{
						if(!(newList.isEmpty()))
						{
							System.out.println(newList.displayForward());
							scan.nextLine();
							break;
						}
						else
						{
							System.out.println("The List is Empty");
							scan.nextLine();
							break;
						}
					}//Display's all the student starting from the front of the list.
					
					case 8:
					{
						if(!(newList.isEmpty()))
						{
							System.out.println(newList.displayBackward());
							scan.nextLine();
							break;
						}
						else
						{
							System.out.println("The List is Empty");
							break;
						}
					}//Display's all the student starting from the front of the list.
					
					case 9:
					{
						if(newList.isEmpty())
						{
							System.out.println("The List is Empty");
							scan.nextLine();
							break;
						}
						else
						{
							newList.insertSortList();
							System.out.println("List has been sorted");
							scan.nextLine();
							break;
						}
							
					}//If there are contents inside the Recordlist then this option uses insertion sort to sort out the list. 
					
					default:
					{
						System.out.println("Quitting!!!");
						System.exit(0);
						break;
					}//Exist if any integers other than 1 to 9 is inputed.
				}
			/*}
			
			catch (Exception e)
			{
				System.out.println("Invalid Input: Only Positive Integer!!! Please Press Enter to Continue");
				System.out.println("Error: " + e.getMessage());
				scan.nextLine();
			}*/
			
		}while(true);

	}
 
}
