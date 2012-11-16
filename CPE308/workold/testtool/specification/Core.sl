object QuestionDB
  components: Question*;
  operations: AddQuestion, DeleteQuestion, EditQuestion, FindQuestion;
  description: (*
    A QuestionDB contains zero or more Questions.
  *);
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
  outputs: Question*;
  description: (*
    Find a question by id, difficulty, timeAllowed, lastUsed, content, answer, htmlAttachment, or questionType.
    It is possible to search for more than one field at once. However, each type of variable does not have to be input.
    If the user just wanted to search by id, that is the only variable that needs to be not null. Null variables will
    be ignored in the searching.
    Once a possible match is found, it is put into a list of Questions as a result that the user can view.
  *);
end FindQuestion;

object UserDB
   components: User*;
   operations: AddUser, DeleteUser, ChangeUser, FindUser;

   description: (*
       A UserDB contains zero or more Users.
   *);
end UserDB;

object User
   components: emplid and  login and password and name and email and userType;
   description: (*
       A User contains data for an individual User in the UserDB.
   *);
end User;
 
object emplid = string;
object login = string;
object password = string;
object name = string;
object email = string;
object userType = Teacher or Proctor or Student;
object Teacher;
object Proctor;
object Student;
 
object TestDB
   components: Test*;
   description: (*
       The TestDB contains zero or more Tests.
   *);
end TestReport;
 
object TestReport
   components: average and  score and Test;
   description: (*
       A TestReport contains data for an individual User’s test results.
   *);
end TestReport;
 
object average =  integer;
object score = integer;
 
object Test
   components: message and Teacher and Proctor and Student and TestQuestion*;
   description: (*
       A Test contains set of testQuestions, a Teacher, a Proctor, a Student and a message from the Teacher to the Student.
   *);
end Test;
 
object message = string;
 
object TestQuestion extends Question
   components: number and pointsPossible and pointsEarned and studentAnswer and teacherFeedback and gradingStatus;
   description: (*
       A testQuestion contains things necessary for a testQuestion...
   *);
end TestQuestion;
 
object number = integer;
object pointsPossible = integer;
object pointsEarned = integer;
object studentAnswer = string;
object teacherFeedback = string;
object gradingStatus = taken or gradedComputer or gradedUser;
object taken;
object gradedComputer;
object gradedUser;


operation gradeTest
inputs: Test;
outputs: TestReport;
description: (*
   This operation takes in a completed test and generates a test report.
*);
end gradeTest;

operation courseScores
inputs: Test*;
outputs: TestReport;
description: (*
   This operation takes in a group of completed tests from a specific course and generates a test report based of all the tests administered for the course.
*);
end courseScores;

operation studentScores
inputs: Test*;
outputs: TestReport;
description: (*
   This operation takes in a group of completed tests from a specific student and generates a test report based of all the tests completed for the student.
*);
end studentScores;

operation analyzeScores
inputs: Test*, Option;
outputs: TestReport;
description: (*
   This operation takes in a group of the same completed tests and generates a test report based on the option(Question, Type, Point Value) the user has specified.
*);
end analyzeScores;
object Option = string;

object TestGeneraterLazy
    components: testName and class and totalQuestions and totalTime;
    operations: testPreview, nextStep;
    description: (*
      A TestGeneratorLazy contains the least amount of information necessary to generate a test.
    *);
end TestGeneratorLazy;
object testName = string;
object class = string;
object totalQuestions = integer;
object totalTime = integer;


object TestGeneratorLessLazy
    components: difficulty and includeByProf and discludeSince and keywords;
    operations: testPreview, nextStep;
    description: (*
      A TestGeneratorLessLazy contains more refining information than a TestGeneratorLazy about how to generate a test.
*);
end TestGeneratorLessLazy;

object includeByProf = string;
object discludeSince = string;
object keywords = string;


object TestGeneratorManual
    components: questions and difficulty and lastUsed and timeReq and author;
    operations: testPreview, generate, addQuestion, deleteQuestion, editQuestion;
    description: (*
      A TestGeneratorManual contains all the information a professor needs to manually edit his test. 
*);

end TestGeneratorManual;
object questions = string;
object timeReq = integer;
object author = string;

operation generate
inputs: Question*;
outputs: Test;
description: (*
    This operation takes in Question objects and makes it into a Test.
*);
end generate;


operation testPreview
inputs: Question*;
outputs: Question*;
description: (*
    This operation takes in Question objects and displays them to the Instructor
*);
end testPreview;


operation addQuestion
inputs: Question;
outputs: Test;
description: (*
    This operation takes in a Question object and adds it to the Test
*);
end addQuestion;


operation deleteQuestion
inputs: Question*;
outputs: Question*;
description: (*
    This operation takes in a Question* and deletes 1 Question object from it
*);
end deleteQuestion;


operation EditQuestion
inputs: QuestionDB, Question, Test;
outputs: Test;
description: (*
    This operation takes in a Question. The Instructor can remove the Question from the Test, or he can search for a particular Question in the QuestionDB. Then the Instructor can add the Question to the Test.
*);
end EditQuestion;
