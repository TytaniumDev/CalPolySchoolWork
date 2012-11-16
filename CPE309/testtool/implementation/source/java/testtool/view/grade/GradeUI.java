package testtool.view.grade;

import testtool.*;
import javax.swing.*;
import java.awt.*;

/****
 *
 * Class GradeUI is a companion view to the Grade model class.  
 *                                                                          <p>
 * GradeUI contains an instance of the view classes that are companion
 * to each of the Grade Model classes.  Here is the correspondence:
 *                                                                        <pre>
 *     <strong>Model Class              Companion View Class</strong>
 *     -----------------------------------------------
 *     Grade.addFeedback               Grade.addFeedback
 *     Grade.byStudent                 Grade.gradeByQuestion
 *     Grade.byQuestion                Grade.gradeByStudent
 *                                                                       </pre>
 *     
 * Each of these view classes contains all of the interface components needed
 * for UI access to their companion model's methods and data.
 *                                                                          <p>
 * The GradeUI will consist of a sidebar, as well as a main UI view which will 
 * display all the current questions for a particular Student's test, or all 
 * student's particular question.
 *
 * @author Nathan Mock (nmock@calpoly.edu)
 * @version 12jan11
 *
 */

public class GradeUI {
   public GradeUI() {
      
   }
   
   /**
    * Shows the UI to allow the instructor to leave feedback on a specific
    * question.
    */
   public void addFeedback(Student s, Question q) {
      
   }
   
   /**
    * Shows the UI to allow the instructor to grade all student tests by
    * a specific question given a specific test.
    */
   public void gradeByQuestion(Question q, Test t) {
      
   }
   
   /**
    * Shows the UI to allow the instructor to grade all questions by
    * a specific student given a test
    */
   public void gradeByStudent(Student s, Test t) {
      
   }
   
   /**
    * Shows the UI to automatically grade a test
    */
   public boolean gradeAutomatically (Student s, Test t) {
      
   }
}