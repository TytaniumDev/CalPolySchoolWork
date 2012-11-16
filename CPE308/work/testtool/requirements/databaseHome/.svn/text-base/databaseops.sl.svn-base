(****
 *
 * Module QuestionDB defines the objects and operations related to 
 * question database operations in the test tool.
 *
 *)
module QuestionDB;

  export QuestionDB;
  export Question;
  export questionType;
  
  object QuestionDB
    components: Question*;
    operations: AddQuestion, DeleteQuestion, EditQuestion, FindQuestion;
    description: (*
      A QuestionDB contains zero or more Questions.
    *)
  end QuestionDB;
  
  object Question
    components: id and difficulty and timeAllowed and lastUsed and content and answer and htmlAttachment and questionType;
    description: (*
      A Question contains data for an individual Question in the QuestionDB.
    *);
  end Question;
  
  object id = integer;
  object difficulty = integer;
  object timeAllowed = integer;
  object lastUsed = string;
  object content = string;
  object answer = string;
  object htmlAttachment = string;
  object questionType = CheckBoxes or DrawnAnswer or Essay or FillInTheBlank or Matching or MultipleChoice or PointAndClick or Programming or ShortAnswer or TrueFalse;
  
  object CheckBoxes;
  object DrawnAnswer;
  object Essay;
  object FillInTheBlank;
  object Matching;
  object MultipleChoice;
  object PointAndClick;
  object Programming;
  object ShortAnswer;
  object TrueFalse;
  
  
  operation AddQuestion
    inputs: QuestionDB, difficulty, timeAllowed, content, answer, htmlAttachment, questionType;
    outputs: QuestionDB;
    description: (*
      Add the given question to the QuestionDB. 
      The variable lastUsed is set to null because the question was just added. 
      The variable id is set to the next availiable integer, starting from 1 for the first question.
      The htmlAttachment is optional, but all of the other variables are required.
      As for constraints: the difficulty is an number between 1 and 5, and timeAllowed can be up to a 3 digit number
      representing minutes.
    *);
  end AddQuestion;
  
  operation DeleteQuestion
    inputs: QuestionDB, Question;
    outputs: QuestionDB;
    description: (*
      Delete the given question from the QuestionDB. The given question must already be in the QuestionDB.
      The returned QuestionDB no longer has Question in it.      
    *);
  end DeleteQuestion;
  
  operation EditQuestion
    inputs: QuestionDB, Question, difficulty, timeAllowed, content, answer, htmlAttachment, questionType;
    outputs: QuestionDB;
    description: (*
      Edit the given question in the QuestionDB. The same things happen as if the user was adding a question,
      but instead of putting a new question in the QuestionDB the given question is simply changed to match the given inputs.
      The htmlAttachment is optional, but all of the other variables are required.
      As for constraints: the difficulty is an number between 1 and 5, and timeAllowed can be up to a 3 digit number
      representing minutes.
    *);
  end EditQuestion;
  
  operation FindQuestion
    inputs: QuestionDB, id, difficulty, timeAllowed, lastUsed, content, answer, htmlAttachment, questionType;
    outputs: Question*
    description: (*
      Find a question by id, difficulty, timeAllowed, lastUsed, content, answer, htmlAttachment, or questionType.
      It is possible to search for more than one field at once. However, each type of variable does not have to be input.
      If the user just wanted to search by id, that is the only variable that needs to be not null. Null variables will
      be ignored in the searching.
      Once a possible match is found, it is put into a list of Questions as a result that the user can view.
    *);
  end FindQuestion;