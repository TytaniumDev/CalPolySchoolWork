(****
 *
 * Module userTest defines the objects and operations related to 
 * user and test database operations in the test tool.
 *
 *)﻿

module userTest;
  from module QuestionDB import all;
    
  object UserDB
     components: User*;
     operations: AddUser, DeleteUser, EditUser, FindUser;

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
     operations: AddTest, EditTest, FindTest;
     description: (*
         The TestDB contains zero or more Tests.
     *);
  end TestDB;
   
  object TestReport
     components: average and  score and Test;
     description: (*
         A TestReport contains data for an individual User’s test results.
     *);
  end TestReport;
   
  object average =  integer;
  object score = integer;
   
  object Test
     components: name and message and Teacher and Proctor and Student and TestQuestion*;
     description: (*
         A Test contains set of testQuestions, a Teacher, a Student and a message from the Teacher to the Student.
     *);
  end Test;
   
  object ProctoredTest extends Test
     components: Proctor;
     description: (*
         A ProctoredTest contains a Proctor.
     *);
  end ProctoredTest;

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

  operation AddUser
    inputs: UserDB, User;
    outputs: UserDB;
    description: (*
      Add the given User to the UserDB. 
      Preconditions: all fields except email must be not null and emplid, userType must be a unique combination.
    *);
  end AddUser;
  
  operation DeleteUser
    inputs: UserDB, emplid, userType;
    outputs: UserDB;
    description: (*
      Delete the given User from the UserDB. 
      Preconditions: giving just an emplid will remove all instances of the user, giving a userType in addition
                     only deletes that unique combination.     
    *);
  end DeleteUser;
  
  operation EditUser
    inputs: UserDB, User;
    outputs: UserDB;
    description: (*
      Looks up user with emplid from User from the UserDB and changes all fields except for userType. 
      Preconditions: emplid of given user must match that of User in UserDB.
    *);
  end EditUser;
  
  operation GetUser
    inputs: UserDB, emplid, userType;
    outputs: User;
    description: (*
      Returns instance of User with given emplid and userType from the UserDB. 
      Preconditions: emplid and userType must match that of User in UserDB.
    *);
  end FindUser;

  operation AddTest
    inputs: TestDB, Test;
    outputs: TestDB;
    description: (*
      Add the given Test to the TestDB. 
      Preconditions: all fields except message and proctor must be not null and Teacher, name must be a unique combination.
    *);
  end AddTest;
  
  operation EditTest
    inputs: TestDB, Test;
    outputs: TestDB;
    description: (*
      Looks up test with name and Teacher from Test from the TestDB and changes all fields except for name and Teacher. 
      Preconditions: name and Teacher combination must exist in TestDB.
    *);
  end EditTest;
  
  operation GetTest
    inputs: TestDB, name, User;
    outputs: Test;
    description: (*
      Returns instance of Test with given name and User from the UserDB. 
      Preconditions: User and name must match that of Test in TestDB.
    *);
  end FindTest;
end userTest;
