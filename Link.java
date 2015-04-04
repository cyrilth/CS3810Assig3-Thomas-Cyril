/*
 *Cyril Thomas CS3810 DS&A Assignment 3 04/06/14
 *Link Class : Defining A node containing Student, Next and Previous. 
 *
 *Student Class APIs:
 *	(1) Parameterized Constructor Student			: - (a) @param Student newStudent : to set the Student data type inside Link.
 *	(2) public Student getStudent()					: -  to retrieve student object stored in a link.
 *	(3) public Link getNext()						: -  to retrieve the reference of the next node in a linear sequence.
 *	(4) public Link getPre()						: -  to retrieve the reference of the previous node in a linear sequence.
 *	(5) public void setStudent(Student newStudent)	: -  @param Student newStudent to set a student in an existing node. 
 *  (6) public void setNext(Link newNext)			: -  @param Link newNext to set a reference a link in an existing node.
 *  (7) public void setPrev(Link newPrev)			: -  @param Link newPrev to set a reference to a link in an existing node.
 *  (8) public String toString()					: -  to display student name and id, using toString from Student Class.
 *  
 *  Strategy: - To Create an Link object known as node which contains student data type and link(referencing itself) data type for next and previous. 
 */
public class Link 
{
	private Student student;
	private Link next;
	private Link prev;
	
	public Link (Student newStudent)
	{
		student = newStudent;
	}//Refer to (1) at APIs
	
	public Student getStudent()
	{
		return student;
	}//Refer to (2) at APIs
	
	public Link getNext()
	{
		return next;
	}//Refer to (3) at APIs
	
	public Link getPrev ()
	{
		return prev;
	}//Refer to (4) at APIs
	
	public void setStudent(Student newStudent)
	{
		student = newStudent;
	}//Refer to (5) at APIs
	
	public void setNext(Link newNext)
	{
		next = newNext;
	}//Refer to (6) at APIs
	
	public void setPrev(Link newPrev)
	{
		prev = newPrev;
	}//Refer to (7) at APIs
	
	public String toString ()
	{
		return student.toString();
	}//Refer to (8) at APIs
}
