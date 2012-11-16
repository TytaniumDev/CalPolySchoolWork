module Core;
  import module.QuestionDB;
    
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
   
  object TestQuestion extends QuestionDB.Question
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
end Core;