(* Figure 2.5.4 and .6: Results *)

obj Results = QuestionResult*
   description:  (*
      * the graded responses for a student
   *);
end Results;

obj Grade = integer 
   description: (*
      * the student's overall score for the test
   *);
end Grade;

object QuestionResult
   components: qn:QuestionNumber and a:Answer and ca:QuestionAnswer and
      f:Feedback and s:Score;
   description: (*
      * a graded test result that is viewed by the student upon completion
   *);

operation ManualGrade
   inputs: qn:QuestionResult;
   outputs: qn':QuestionResult;
   description: (*
      * Adds an instructor's specified score and feedback to a question
   *);

   postcondition:
      (*
       * The question must have a grade
       *)
      (qn.s);
end ManualGrade;


operation AutoGrade
   inputs: qn:QuestionResult;
   outputs: qn':QuestionResult;
   description: (*
      * Autogrades a single question
   *);

   precondition:
      (*
       * The question being graded has not been graded already
       *)
      (not qn.s);

   postcondition:
