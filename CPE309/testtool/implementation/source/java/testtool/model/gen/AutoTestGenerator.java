package testtool.model.gen;

import java.util.Date;

/**
 * This class represents an object that is used to automatically generate tests.
 *
 * @author Marcus Ortiz (mportiz@calpoly.edu)
 * @version 12jan11
 */
public class AutoTestGenerator
{
  /** The course that generated questions should be pertaining to */
  private String course;
  
  /** The number of questions to be generated */
  private int quantity;
  
  /** The time limit in minutes for the generated test */
  private int timeLimit;
  
  /** A date that generated questions should not have been used since */
  private Date usedSince;
  
  /** The title of the generated test */
  private String title;
  
  /** The current date as of the time of generation? */
  private Date date;
  
  public AutoTestGenerator(String course, int quantity, int timeLimit, Date usedSince, String title, Date date)
  {
    // TODO
  }
  
  /**
   * This method runs the automatic test generator and produces a test matching the requirements.
   *
   * @return a test that matches the given requirements
   */
  public Test generate()
  {
    // TODO
  }
}
