/*
 * CPE 103 Section 07/08 - Project 4
 * Written by Tyler Holland
 * Instructor: Hasmik Gharibyan
 */
public class Student
{
   private long id;
   private String name; //Last name
   
   public Student(long number, String lastName) //Constructor
   {
      id = number;
      name = lastName;
   }
   
   /*
    * Overwrites the default equals method
    * @param other an Object to be compared to this Student for equality
    * @return true if the Students are equal, false otherwise
    * Precondition: other is a valid Student type
    * Postcondition: the equality of other vs this Student is known
    */
   public boolean equals(Object other)
   {
      if(other == null)
      {
         return false;
      }
      else if(other.getClass() != this.getClass())
      {
         return false;
      }
      else if(this.id != ((Student)other).id)
      {
         return false;
      }
      return true;
   }
   
   /*
    * Converts the Student into a readable String
    * @return the String with student ID and last name
    * Precondition: this Student exists
    * Postcondition: A String with this Student's identification is returned
    */
   public String toString()
   {
      String answer;
      answer = ("{id: " + id + ", name: " + name + "}");
      return answer;
   }
   
   /*
    * Converts the Student into its hashcode form
    * @return the int hashCode value
    * Precondition: this Student exists
    * Postcondition: The hashCode value is returned
    */
   public int hashCode()
   {
      int hash = ((Long)id).hashCode();
      return hash;
   }
}
