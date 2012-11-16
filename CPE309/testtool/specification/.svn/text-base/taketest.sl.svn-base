(****
  *
  * This file defines objects and operations related to the test taking screen.
  * 
  *)

(* Figure 2.5.2: Test Listing *)

obj StudentTestList = TestListing;
obj TestListing = Title and DueBy;
obj DueBy = Date;
obj Date = Month and Day and Year;

(* Figure 2.5.3: Test Screen *)

obj TestScreen = TestSection and TotalPages;
obj TestSection = PageNumber and TestTakingQuestion*;
obj TestTakingQuestion = QuestionText and QuestionNumber and MultipleChoice or ShortAnswer or Coding;
obj MultipleChoice = Option* and MCAnswer;
obj ShortAnswer = TestAnswer;
obj Coding = Script;

obj Option = ChoiceNum and Text;
obj MCAnswer = ChoiceNum;

obj PageNumber = integer;
obj TotalPages = integer;
obj QuestionNumber = integer;
obj TestAnswer = string;
obj ChoiceNum = string;
obj Text = string;

operation SubmitTest
   inputs: ts:TestSection*;
   outputs: ts':TestSection*;
   description: (*
      * Submits an exam
   *);
end SubmitTest;

operation NextPage
   inputs: ts:TestSection;
   outputs: ts':TestSection;
   description: (*
      * Grabs the next page
      * );
   postcondition: ts' != ts
end NextPage;

operation PrevPage
   inputs: ts:TestSection;
   outputs: ts':TestSection;
   description: (*
      * Grabs the prev page
      * );
   postcondition: ts' != ts
end PrevPage;

operation TakeTest
   inputs: tl:StudentTestListing;
   outputs: ts':TestSection;
   description: (* Starts a test *);
end TakeTest;

(* Figure 2.5.5 *)

obj ExamGrades = ExamName and GradeReceived;

obj AverageGrade = integer;
obj ExamName = string;
obj GradeReceived = integer;
