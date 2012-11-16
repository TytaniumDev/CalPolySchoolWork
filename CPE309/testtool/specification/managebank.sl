(****
  *
  * This file defines objects and operations related to managing the question bank
  * 
  * See Section 2.3 of the Milestone 10 requirements.
  * 
  *)

operation Add
   inputs: qdb:QuestionBank, qbq:QuestionBankQuestion, q:Question;
   outputs: qdb':QuestionBank, qbq':QuestionBankQuestion;
   description: (*
      * Creates a new Question, inserts this Question into a QuestionBankQuestion and adds 
      * the QuestionBankQuestion into the QuestionBank nto a QuestionBankQuestion and 
   *);

   precondition: (*
    * The question trying to be added to the QuestionBank
    * doesn't already exist 
   *)
   (not (exists (qbq in qdb) qbq.qst = q));
   
   postcondition: (*
    * A QuestionBankQuestion is in the QuestionBank if any only if
    * it is the question to be added or it already existed in the 
    * question bank
   *)
   forall (qbq':QuestionBankQuestion)
      (qbq' in qdb') iff ((qbq' = qbq) or (qbq' in qdb));         
end Add;

operation Edit
   inputs: qdb:QuestionBank, qbq:QuestionBankQuestion;
   outputs: qdb':QuestionBank, qbq':QuestionBankQuestion;
   description: (*
      * Manipulates the Question data contained within a QuestionBankQuestion in the QuestionBank      
   *);

   precondition: (*
      * The question being edited already exists in the QuestionBank 
   *)
   qbq in qdb;
   
   postcondition: (*
      * A QuestionBankQuestion is in the QuestionBank if any only if
      * it is the question that has been edited or it already existed in the 
      * question bank
   *)
   forall (qbq':QuestionBankQuestion)
      (qbq' in qdb') iff ((qbq' = qbq) or (qbq' in qdb));  
end Edit;

operation Remove
   inputs: qdb:QuestionBank, qbq:QuestionBankQuestion;
   outputs: qdb':QuestionBank;
   description: (*
      * Removes a selected question from the QuestionBank
   *);

   precondition: (*
      * The question being removed already exists in the QuestionBank 
   *)
   qbq in qdb;
   
   postcondition: (*
      * A QuestionBankQuestion is in the QuestionBank if any only if
      * it already existed in the Question Bank and is NOT the question that 
      * was just removed.
   *)
   forall (qbq':QuestionBankQuestion)
      (qbq' in qdb') iff ((qbq' != qbq) and (qbq' in qdb));  
end Remove;
      
operation Organize
   inputs: colList:ColumnHeadings, cols:Column*;
   outputs: colList':ColumnHeadings, cols':Column*;   
   description: (*
      * Reorganizes the column headings, effectively setting which columns 
      * are viewable in the first five slots in the GUI. The operation places 
      * the 5 Column objects recieved in the order they are recived from left to 
      * right starting at 1
   *);

   precondition: (*
      * There are no more or no less than 5 columns passed into the function
   *)
   #colList = 5;

   postcondition: (*
      * The GUI changes the ordering of the columns displayed to the inputted order. 
      * No change in the ordering is acceptable, since no data is changed, just the GUI.
      * All organized columns will be assigned column positions of 1 - 5
   *)
   forall(cols':Column)
      (cols'.pos <= 5 and cols'.pos >= 1)
   
   and

   (* 
    * There are no two Column with duplicate positions. 
    * Every column must be unique
   *)
   (not (exists (cols' in colList') cols'.pos = cols'.pos));
   
end Organize;
            
operation Sort
   inputs: qb:QuestionBank, clickedCol:Column;
   outputs: qb':QuestionBank;
   description: (*
      * Sorts all of the QuestionBankQuestions by some criterion that was selected
      * by clicking on the label for the clickedCol      
   *);
   
   precondition: (*
      * The QuestionBank is not empty
   *)
   (#qb >= 0);
   
   postcondition: (*
      * The QuestionBank is now sorted by the selected criterion as shown by the 
      * possible sorts below:
   *)
   
   (*
    * Sorted by Course
    *)
   (forall (i:integer | (i >= 1) and (i < #qb))
      qb[i].qst.course < qb[i+1].qst.course) 
      
   or 
   
   (*
    *Sorted by Question Type
    *)
   (forall (i:integer | (i >= 1) and (i < #qb))
      qb[i].qst.type< qb[i+1].qst.type) 
      
   or
  
   (*
    * Sorted by Author
    *)
   (forall (i:integer | (i >= 1) and (i < #qb))
      qb[i].qst.auth < qb[i+1].qst.auth) 
      
   or
   
   (*
    * Sorted by Difficulty
    *)
   (forall (i:integer | (i >= 1) and (i < #qb))
      qb[i].qst.diff < qb[i+1].qst.diff) 
      
   or
   
   (*
    * Sorted alphabetically by Question Text
    *)
   (forall (i:integer | (i >= 1) and (i < #qb))
      qb[i].qst.text < qb[i+1].qst.text) 
      
   or
   
   (*
    * Sorted alphabetically by Answer Text
    *)
   (forall (i:integer | (i >= 1) and (i < #qb))
      qb[i].qst.answer < qb[i+1].qst.answer) 
      
   or
   
   (*
    * Sorted by Suggested Time
    *)
   (forall (i:integer | (i >= 1) and (i < #qb))
      qb[i].qst.time < qb[i+1].qst.time); 
   
end Sort;
            
object Column
   components: id:ColID and name:ColName and pos:ColPosition;
   description: (*
      * The Column object merely represents a column in the GUI. There are no data members other 
      * than the Column's ID and its name as displayed in the GUI because a Column helps 
      * the user viaualize the data but doesn't actually manipulate data 
   *);
end Column;

object ColID = integer
   description: (*
      * The ID of a column. Used to uniquely identify columns.
   *);
end ColID;

object ColPosition = integer
   description: (*
      * The current position of this column (in left to right order).
   *);
end ColPosition;

object ColName = "Question" or "Answer" or "Type" or "Difficulty" or "Suggested Time" 
                 or "Course" or "Author"
   description: (*
      * The text that will be displayed in this column's text area which explains what type
      * of data is currently resting in this column on the GUI
   *);
end ColName;
   
object ColumnHeadings
   components: col:Column*;
   description: (*
      * Stores all of the GUI columns and keeps them in a certain 
      * order which is dependent on how much the user has modified the order
      * of the columns contained herein. This object essentially functions as an 
      * array where the Columns are organized and numbered left to right.
    *);
end ColumnHeadings;
    
object QuestionBank
   components: qstncont:QuestionBankQuestion*;
   description: (*
      * A QuestionBank is what holds all of the questions and has operations performed
      * on it to manipluate questions and their data. The QuestionBankQuestion serves as 
      * a container for a given question in the question bank.
   *);
end QuestionBank;

object QuestionBankQuestion
   components: chkbx:CheckBox and qst:Question;
   description: (*
      * This object represents a row in the QuestionBank as seen by the user.
   *);
end QuestionBankQuestion;

object CheckBox = boolean
   description: (*
      * Determines whether or not the QuestionBankQuestion is currently selected.
   *);
end CheckBox;

object Question
   components: course:Course and auth:Author and text:QuestionText and answer:QuestionAnswer and 
    type:QuestionType and diff:Difficulty and time:SuggestedTime;
   description: (*
      * This is where all the data relating to a question in the QuestionBank is stored. 
   *);
end Question;

object Course
   components: dept:Department and courseNum:CourseNumber;
   description: (*
      * Represents a course in the QuestionBank
   *);
end Course;

object Department = string 
   description: (*
      * The department this question is created for.
   *);
end Department;

object CourseNumber = string
   description: (*
      * The specific course number in the department this question is 
      * created for.      
   *);
end CourseNumber;  

object Author = string 
   description: (*
      * The author of this question (the person who added it to the database) 
   *);
end Author;
   
object QuestionText = string
   description: (*
      * The text for the question.     
   *);
end QuestionText;

object QuestionAnswer
   components: tfA:TrueFalseA or mcA:MultipleChoiceA or matchA:MatchingA or fibA:FillintheBlankA or 
    essA:EssayA or shrtA:ShortAnswerA or codeA:CodeA;
   description: (*
      * The answer to the question. This will vary based on the type of question chosen.
   *);
end QuestionAnswer;

object TrueFalseA
   components: ans:CorrectChoice;
   description: (*
      * The answer to a true for false question (i.e "True" or "False")
   *);
end TrueFalseA;

object CorrectChoice = string
   description: (*
      * The correct choice in a choice-centric question such as True/False or Multiple Choice, to name a couple.
   *);
end CorrectChoice;

object MultipleChoiceA 
   components: ans:CorrectChoice;
   description: (*
      * The answer to a multiple choice question (i.e the single best answer)
   *); 
end MultipleChoiceA;

object QuestionType = "Multiple Choice" or "Fill in the Blank" or "Matching" or "True or False" 
   or "Essay" or "Short Answer" or "Code"
   description: (*
      * The text indicating what kind of question this is. The data in this field will determine which
      * QuestionAnswer will be chosen to represent the answer.
   *);
end QuestionType;

object MatchingA
   components: ans:CorrectPair*;
   description: (*
      * The set of correct matches for a given matching question.
   *); 
end MatchingA;

object CorrectPair
   components: itemA:itemOne and itemB:itemTwo;
   description: (*
      * Represents a pair of correctly matched items such that itemOne and 
      * itemTwo constitute a correct match when placed together.
   *); 
end CorrectPair; 

object itemOne = string
   description: (*
      * The first component of a match of two items.
   *); 
end itemOne;

obj itemTwo = string
   description: (*
      * The second component of a match of two items.
   *); 
end itemTwo;

object FillintheBlankA
   components: ans:QBAnswerText;
   description: (*
      * The correct text to be filled in for a given Fill in the Blank
      * question.
   *);
end FillintheBlankA;

object QBAnswerText = string
   description: (*
      * The text that is the correct answer for a Fill in the Blank question, or in 
      * the case of essays and short answer the suggested answer that guides the determination of  
      * whether or not the question was answered correctly.
   *);
end QBAnswerText;

object EssayA
   components: ans:QBAnswerText;
   description: (*
      * The suggested answer on which the essay question's correctness should 
      * be evaluated.
   *);
end EssayA;

object ShortAnswerA
   components: ans:QBAnswerText;
   description: (*
      * The suggested answer on which the short answer question's correctness should
      * be evaluated.
   *);
end ShortAnswerA;

object CodeA
   components: grScript:Script*;
   description: (*
      * The answer to the code questions are evalauted using the one or more
      * scripts provided by the user.
   *);
end CodeA;

object Difficulty
   components: name:DifficultyName and number:DifficultyNumber;
   description: (*
      * The difficulty of a question represented by a word or words 
      * describing the difficulty level and a corresponding number value 
      * to numberically represent this on a scale of 1 to 5.
   *);
end Difficulty;
   
object DifficultyName = string
description: (*
      * The word or words qualifying how difficult this question is.
   *);
end DifficultyName;

object DifficultyNumber = integer
   description: (*
      * The number value qualifying how difficult this question is.
   *);
end DifficultyNumber;

object SuggestedTime
   components: min:Minutes;
   description: (*
      * the number of minutes this question is designed to take to complete
   *);
end SuggestedTime;

object Minutes = integer
  description: (*
     * the integer representing the number of minutes
  *);
end Minutes;

object Script
   components: location:Path;
   description: (*
      * A script that will be executed to grade a coding question whose physical 
      * location is at some path on the storage medium.
   *);
end Script;
   
object Path = string
   description: (*
      * The path in the filesystem to the script file. 
   *);
end Path;