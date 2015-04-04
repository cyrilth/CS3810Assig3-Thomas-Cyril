/*
 * Cyril Thomas CS3810 DS&A Assignment 3 04/06/14
 * Student Class :- Defining a Student by their name and id. 
 * 
 * Student Class APIs:
 * (1) Parameterized Constructor Student 	:- 	(a) @param String newName :- to set student name.
 * 												(b) @param String newId :- to set student id.
 * (2) public void setName(String newName)	:-  @param String newName to set student name.
 * (3) public void setId(String newId)		:-  @param String newId to set student id.
 * (4) public String getName()				:- to retrieve student name.
 * (5) public String getId()				:- to retrieve student id.
 * (6) public String getId()				:- to retrieve student id. 
 * (7) public boolean equals(Student right) :- (a) @param Student right :- to pass another student object 
 * 											   (b) Used to compare two different student objects. 
 * (8) public String toString()				:- returns String to display student name and id. 
 * 
 *  Strategy :- To Create a Student object containing String name and String id. 
 */
public class Student 
{
	private String name;
	private String id;
	
	public Student ()
	{
		name = "Unknown";
		id = "Unknown";
	}//Default Constructor
	
	public Student (String newName, String newId)
	{
		name = newName;
		id = newId;
	}//Refer to (1) at APIs
	
	public void  setName(String newName)
	{
		name = newName;
	}//Refer to (2) at APIs
	
	public void setId(String newId)
	{
		id = newId;
	}//Refer to (3) at APIs
	
	public String getName()
	{
		return name;
	}//Refer to (4) at APIs
	
	public String getId()
	{
		return id;
	}//Refer to (6) at APIs
	
	public boolean equals(Student right)
	{
		if((name.equals(right.name))&&(id.equals(right.id)))
			return true;
		else
			return false;
	}//Refer to (7) at APIs
	
	public String toString()
	{
		return ("ID: " + id + "\tName: " + name + "\n");
	}//Refer to (8) at APIs
	
}
