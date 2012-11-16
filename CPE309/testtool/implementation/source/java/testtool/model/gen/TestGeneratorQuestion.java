package testtool.model.gen;

/**
 * This class represents a question object that is used in generated tests.
 *
 * @author Marcus Ortiz (mportiz@calpoly.edu)
 * @version 12jan11
 */
public class TestGeneratorQuestion
{
  /** The question text */
  private String question;
  
  /** The answer text */
  private String answer;
  
  /** The course associated with this question */
  private String course;
  
  /** The name of the author of this question */
  private String author;
  
  /** A difficulty rating for the question: (1-5) */
  private int difficulty;
  
  /** The number of minutes allowed for a student to answer the question */
  private int timeLimit;
  
  /** The question type */
  private String type;
  
  /** The point value associated with this question in a test */
  private int value;
}
