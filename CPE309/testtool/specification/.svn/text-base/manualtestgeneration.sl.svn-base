(*
  *
  * This file defines objects and operations related to the manual test generation.
  * 
  * See Sections 2.2 of the Milestone 10 requirements.
  * 
*)

operation AddToQuestionQueue
   inputs: t:QText, qdbq:QuestionDBQuestion, qq:QuestionQueue;
   outputs: qq':QuestionQueue, qdbq':QuestionDBQuestion;
   description: (*
      * Creates a new QuestionQueueQuestion from the QuestionDB, inserts this QuestionQueueQuestion 
	  * into a QuestionQueue
   *);

   precondition: (*
    * The question trying to be added to the QuestionQueue
    * doesn't already exist in the QuestionQueue 
   *)
   (not (exists (qdbq in qq) qdbq.txt = t));
   
   postcondition: (*
    * The QuestionQueueQuestion is in the QuestionQueue if and only if the questions already 
	* exists in the database or it is not yet in the Question Queue
   *)
   forall (qdbq:QuestionQueue)
      (qdbq' in qq') iff (qdbq'.txt = t);         
end AddToQuestionQueue;

operation DeleteQuestionsFromQueue
  inputs: t:QText, qdbq:QuestionDBQuestion, qq:QuestionQueue;
   outputs: qq':QuestionQueue, qdbq':QuestionDBQuestion;
  description: (*
     * Removes a selected question from the QuestionQueue
  *);

  precondition: (*
    * The question trying to be deleted from the QuestionQueue
    * exists in the QuestionQueue 
   *)
   ((exists (qdbq in qq) qdbq.txt = t));
  
  postcondition: (*
    * The QuestionQueueQuestion is not in the QuestionQueue if and only if the questions exist 
	* in the database or if it is not yet in the Question Queue
   *)
   forall (qdbq:QuestionQueue)
      (qdbq' in qq') iff not((qdbq'.txt = t));
end DeleteQuestionsFromQueue;

operation NarrowDownResults
  inputs: qdb:QuestionDB, qdbq:QuestionDBQuestion, st:SearchTerm;
  outputs: qdb':QuestionDB,qdbq':QuestionDBQuestion;
  description: (*
    * Returns a modified question DB with questions containing only the specified 
	* search term
  *);

  precondition: (*
    * There are questions in the question DB containing the search term
  *)
  forall (qdbq in qdb)
    (* ???? *)
	(st = qdbq.txt);

  postcondition: (*
    *  The modified question DB contains only questions with the specified search term
  *)
  forall (qdbq:QuestionDB) (
    ((qdbq' in qdb') iff (st = qdbq'.txt))
  );
end NarrowDownResults;

object QuestionDBQuestion
   components: course:QCourse and auth:QAuthor and txt:QText and answer:QAnswer and 
    type:QType and diff:QDifficulty;
   description: (*
      * This is where all the data relating to a question in the QuestionDB is stored. 
   *);
end QuestionDBQuestion;

object QuestionQueueQuestion
   components: qst:QuestionDBQuestion;
   description: (*
      * This is where all the data relating to a question in the QuestionQueueQuestion is stored. 
   *);
end QuestionQueueQuestion;

object QCourse = string
   description: (*
      * Represents a course in the QuestionDB
   *);
end QCourse;

object QAuthor = string 
   description: (*
      * The author of this question (the person who added it to the database) 
   *);
end QAuthor;
   
object QText = string
   description: (*
      * The text for the question.     
   *);
end QText;

object QAnswer = string
   description: (*
      * The answer for the question.     
   *);
end QText;

object QType = "Multiple Choice" or "Fill in the Blank" or "Matching" or "True or False" 
   or "Essay" or "Short Answer" or "Code"
   description: (*
      * The text indicating what kind of question this is. The data in this field will determine which
      * QuestionAnswer will be chosen to represent the answer.
   *);
end QType;

object QDifficulty = integer
   description: (*
      * The difficulty of a question represented by a integer 
      * on a scale of 1 to 5.
   *);
end Difficulty;

object SearchTerm = string
   description: (*
      * The search term to search for.     
   *);
end SearchTerm;

object QuestionDB
   components: qdbq:QuestionDBQuestion*;
   description: (*
      * A QuestionDB is what holds all of the questions and has operations performed
      * on it to manipluate questions and their data. The QuestionDBQuestion serves as 
      * a container for a given question in the question bank.
   *);
end QuestionDB;

object QuestionQueue
  components: qdbq:QuestionDBQuestion*;
end QuestionQueue;
