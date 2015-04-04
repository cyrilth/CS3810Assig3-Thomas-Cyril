/*
 * Cyril Thomas CS3810 DS&A Assignment 3 04/06/14 
 * RecordList Class : - Adding operations to a Link node and using First and Last as a reference point in a link. 
 * 
 * RecordList Class APIs:
 * 	(01) public boolean isEmpty										: - returns true if first equals null;
 * 	(02) public void insertFirst(Student newFirst)					: - @param Student newFirst to pass an Student Object into the front of the List.
 * 	(03) public void insertLast(Student newLast)					: - @param Student newLast to pass an Student Object into the last of the List.
 * 	(04) public Link deleteFirst()									: - moves the current first reference point to next link and returns the current Link node.
 * 	(05) public Link deleteLast()									: - moves the current last reference point to the previous link and returns the current Link node.
 * 	(06) public boolean insertAfter(Student key, Student newData)	: - @param Student key & Student newData, this method allows user to add a new student data specifically 
 * 																		after an existing student and returns a boolean value.
 * 	(07) public Link deleteKey(Student key)							: - @param Student key to delete a match student to the key and returning the deleted student.
 * 	(08) public String displayForward()								: - displays the list from the first reference point and returns the concatenated String.
 *  (09) public String displayBackward()							: - displays the list from the last reference point (reverse order) and returns the concatenated String.
 *  (11) public String toString()									: - (same as displayForward).
 *  (11) public void insertSortList()								: - uses insertion sort method to sort the list in ascending order using Student ID. 
 *  
 *  Strategy:
 * 	(06) insertAfter() = Creating a Current reference point my using Link current = first. Then keep on traversing the current list until a match is found by using the equals method
 * 						 created in the student class which compares name and id. If the current is null, that means the list is empty and a false boolean value is returned. Then a 
 * 						 a new Link node is created with the new Student data. After that an if else statement is used to check whether the current is point to last node. If the current
 * 						 is pointing to the last node then the new Link next node is set to null and the last reference point is assigned to new Link. Else, new Link next is changed to 
 * 						 current next and current next's previous is changed to new link. Also then the new Link previous node is changed to current and current next node is changed to 
 *                       new Link. If the operation is successful a true boolean value is returned. 
 *                       
 *	(11) insertSortList() = Creating a Current reference point my using Link current = first and initializing count to zero. Then using a while loop to traverse the list using current != null.
 *							Then creating a temp Student object and referencing that to current student object and also creating a temp Start link object and assigning it to current. Then initializing
 *                          int q to count and i. Then using a if else statement to avoid null pointer exception. If tempStart previous equals null then i is assigned zero else i is assigned 
 *                          tempStart previous Student id. Also j is assigned tempStudent id. Then using another while loop within the current while loop using the condition to if q > 0 and i >j.
 *                          If the condition matches the second while loop then temp Start student is set to tempStart previous student after that tempStart is assigned tempStart previous and then q is
 *                          decremented. Once out of the second while loop but still inside the first while loop count is incremented and tempStart Student is assigned tempStudent and then current is 
 *                          moved to current next.    
 */
public class RecordList 
{
	private Link first;
	private Link last;
	
	public RecordList()
	{
		first = null;
		last = null;
	}//Default Constructor
	
	public boolean isEmpty()
	{
		return first==null;
	}//Refer to (01) at APIs
	
	public void insertFirst(Student newFirst)
	{
		Link newLink = new Link(newFirst);
		
		if(isEmpty())
			last = newLink;
		else
			first.setPrev(newLink);
		
		newLink.setNext(first);
		first = newLink;
	}//Refer to (02) at APIs
	
	public void insertLast(Student newLast)
	{
		Link newLink = new Link(newLast);
		if(isEmpty())
			first = newLink;
		else
		{
			last.setNext(newLink);
			newLink.setPrev(last);
		}
		
	last = newLink;
	}//Refer to (03) at APIs
	
	public Link deleteFirst()
	{
		Link temp = first;
		if(first.getNext() == null)
			first = null;
		else
			first.getNext().setPrev(null);
		
		first = first.getNext();
		return temp;
	}//Refer to (04) at APIs
	
	public Link deleteLast()
	{
		Link temp = last;
		
		if(first.getNext()==null)
			first = null;
		else
			last.getPrev().setNext(null);
		
		last = last.getPrev();
		return temp;
	}//Refer to (05) at APIs
	
	public boolean insertAfter(Student key, Student newData)
	{
		Link current = first;
		
		while(!(current.getStudent().equals(key)))
		{
			current = current.getNext();
			if(current == null)
				return false;
		}
		
		Link newLink = new Link(newData);
		
		if(current == last)
		{
			newLink.setNext(null);
			last = newLink;
		}
		else
		{
			newLink.setNext(current.getNext());
			current.getNext().setPrev(newLink);
		}
		
		newLink.setPrev(current);
		current.setNext(newLink);
		return true;
	}//Refer to (06) at APIs and Strategy
	
	public Link deleteKey(Student key)
	{
		Link current = first;
		
		while(!(current.getStudent().equals(key)))
		{
			current=current.getNext();
			if(current == null)
				return null;
		}
		
		if(current==first)
			first = current.getNext();
		else
			current.getPrev().setNext(current.getNext());
		
		if(current==last)
			last = current.getPrev();
		else
			current.getNext().setPrev(current.getPrev());
		
		return current;
	}//Refer to (07) at APIs
	
	public String displayForward()
	{
		Link current = first;
		String temp = "";
		
		while(current != null)
		{
			temp += current.toString();
			current = current.getNext();
		}
		return temp;
	}//Refer to (08) at APIs
	
	public String displayBackward()
	{
		Link current = last;
		String temp = "";
		
		while(current != null)
		{
			temp += current.toString();
			current = current.getPrev();
		}
		return temp;
	}//Refer to (09) at APIs
	
	public String toString()
	{
		Link current = first;
		String temp = "";
		
		while(current != null)
		{
			temp += current.toString();
			current = current.getNext();
		}
		
		return temp;
	}//Refer to (10) at APIs
	

	
	public void insertSortList()
	{
		Link current = first;
		
		int count = 0;
		
		while(current != null)
		{
			Student tempStudent = current.getStudent();
			Link tempStart = current;
			
			int q = count;
			int i;
			
			if(tempStart.getPrev() == null)
				i = 0;
			else
				i = Integer.parseInt(tempStart.getPrev().getStudent().getId());
			
			int j = Integer.parseInt(tempStudent.getId());
			
			while(q >0 && i > j)
			{
				tempStart.setStudent(tempStart.getPrev().getStudent());
				tempStart = tempStart.getPrev();
				q--;
			}
			
			count++;
			tempStart.setStudent(tempStudent);
			
			current = current.getNext();
		}
	}//Refer to (11) at APIs and Strategy. 
	
	
}
