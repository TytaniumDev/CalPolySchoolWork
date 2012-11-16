(****
  *
  * This file defines objects and operations related to exam handling.
  * 
  * See Sections 2.4 of the Milestone 10 requirements.
  * 
  *)

operation ConnectStudents
   inputs: ;
   outputs: bool:boolean;
   description: (*
      * Indicates whether or not all students that are eligible to take an exam
      * are ready to take it.
      * );

   precondition: (*
      *)
      ;
      
   postcondition: (*
      *)
      ;
end ConnectStudents;

operation StartExam
   inputs: tdb:TestDatabase, t:Test;
   outputs: t':Test;
   description: (*
      * Outputs an exam to be taken by students.
      * );

   precondition: (*
      * The indicated exam is in the exam database.
      *)
      t in tdb;

   postcondition: (*
      * The exam that is to be distributed is the one sent in to the function
      *)
      t' = t;
end StartExam;

object TestPreview
   components: en:ExamName and qpp:QuestionsPerPage;
   description: (*
      * This object represents the dialogue presented in the Previewing Exams scenario.
      * );
end TestPreview;

object TestDistribution
   components: en:ExamName and dt:DistributionType and qpp:QuestionsPerPage and et:ExamType and bo:BacktrackingOption;
   description: (*
      * This object represents everything that is required to distribute a test.
      * );
end TestDistribution;

object DistributionType
   components: p:Proctored or h:Home;
   description: (*
      * This object represents the two distribution methods.
      * );
end DistributionType;

object QuestionsPerPage = integer
   description: (*
      * This object represents how many questions will be viewable per page on an exam.
      * );
end QuestionsPerPage;

object ExamType
   components: g:Graded or p:Practice;
   description: (*
      * This object represents what type of exam will be distributed.
      * );
end ExamType;

object BacktrackingOption = boolean
   description: (*
      * This object indicates whether or not students can edit already-submitted answers.
      * );
end BacktrackingOption;

object ExamName = string
   description: (*
      * The name of the exam.
      * );
end ExamName;

object Proctored
   description: (*
      * A distribution type.
      * );
end Proctored;

object Home
   description: (*
      * A distribution type.
      * );
end Home;

object Graded
   description: (*
      * An exam type.
      * );
end Graded;

object Practice
   description: (*
      * An exam type.
      * );
end Practice;

object StudentConnector
   components: scl:StudentCell*;
   description (*
      * This object indicates to the instructor whether all elgible students are ready to take the exam.
      * );
end StudentConnector;

object StudentCell
   components: cx:CheckorX and un:Username;
   description (*
      * Represents a student and his status for taking the exam.
      * );
end StudentCell;

object CheckorX = boolean
   description: (*
      * Indicates whether or not a student is ready to take an exam.
      * );
end CheckorX;

obj Username = string
   description: (*
      * Represents a user.
      * );
end Username;

object ProctoredSetting
   components: si:StudentInfo and ah:AdminHandler and mt:MiniTest;
   description: (* 
      * This object represents the environment for the instructor while distributing the exam in that setting.
      *);
end ProctoredSetting;

object StudentInfo
   components: sn:StudentName and pc:PercentCompleted and diso:DisqualifyOption;
   description: (*
      * This object contains information about a student and his progress on the current exam.
      * );
end StudentInfo;

object StudentName
   components: fn:FirstName and ln:LastName;
   description (*
      * Used to fully identify a student;
      * );
end StudentName;

object FirstName = string
   description: (*
      * The first name of a student.
      * );
end FirstName;

object LastName = string
   description: (*
      * The last name of a student.
      * );
end LastName;

object PercentCompleted = integer
   description: (* 
      * Represents the progress of a student on the current exam.
      * );
end PercentCompleted;

object DisqualifyOption = boolean
   description: (*
      * Gives the instructor the ability to eliminate a student from taking an exam.
      * );
end DisqualifyOption;   
   
object AdminHandler
   components: tl:TimeLeft and nts:NumTestsSubmitted;
   description: (*
      * This object represents the administerial functions available to an instructor while proctoring an exam.
      * );
end AdminHandler;

object TimeLeft 
   components: m:Minute and s:Second;
   description: (*
      * Represents the time remaining for the current exam.
      * );
end TimeLeft;

object Minute = integer
   description: (*
      * How many minutes are left in the time for the current exam.
      * );
end Minute;

object Second = integer
   description: (*
      * How many seconds are left in the time for the current exam.
      * );
end Second;

object NumTestsSubmitted = integer
   description: (*
      * The number of students who have completed the current exam.
      * );
end NumTestsSubmitted;

object MiniTest
   components: ttql: TestTakingQuestions*;
   description: (*
      * This object represents how much an instructor can view about a student's answer on the current exam.
      *);
end MiniTest;

