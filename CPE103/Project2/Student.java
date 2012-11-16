/*
 * CPE 103 Section 07/08 - Project 2
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
public class Student implements Comparable<Student>
{
   private long studentID; //positive integer value (greater than 0)
   private String lastname; //No spaces in last name
   
   public Student(long ID, String name)
   {
      studentID = ID;
      lastname = name;
   }

   /*
    * Precondition: Students can't have the same ID number
    * Postcondition: returns 1 if this student's ID is > than the other's,
    *                returns 0 if this student's ID is = to the others,
    *                and returns -1 if this student's ID is < than the other's
    */
   public int compareTo(Student other)//only compare student ID
   {
      if(this.studentID < other.studentID)
      {
         return -1;
      }
      else if(this.studentID == other.studentID)
      {
         return 0;
      }
      else
      {
         return 1;
      }
   }
   
   /*
    * Precondition: this student has valid instance variables
    * Postcondition: Returns the String of the student, with ID and last name
    */
   public String toString()//based on specifications and spaced for clarification
   {
      String result = "{ id:";
      result = result.concat("" + studentID);
      result = result.concat(",name:");
      result = result.concat("" + lastname);
      result = result.concat(" }");
      
      return result;
   }
}
