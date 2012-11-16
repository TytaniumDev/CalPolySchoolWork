object TestGeneraterLazy
    components: Test and testName and class and totalQuestions and totalTime;
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
    components: Test and difficulty and numQuestions and includeByProf and discludeSince and discludeByProf and questionTypes and keywords;
    operations: testPreview, nextStep;
    description: (*
      A TestGeneratorLessLazy contains more refining information than a TestGeneratorLazy about how to generate a test.
*);
end TestGeneratorLessLazy;

object includeByProf = string;
object discludeSince = string;
object keywords = string;
object difficulty = integer;
object numQuestions = integer;
object discludeByProf = string;
object questionTypes = string;


object TestGeneratorManual
    components: Test and questions and difficulty and lastUsed and timeReq and author;
    operations: testPreview, generate,  deleteQuestion, editQuestion, addQuestion;
    description: (*
      A TestGeneratorManual contains all the information a professor needs to manually edit his test. 
*);

end TestGeneratorManual;
object questions = integer;
object timeReq = integer;
object author = string;
object lastUsed = string;


operation nextStep
inputs: T:Test, tN:testName, cl:class, tQ:totalQuestions, tT:totalTime;
outputs: Test;
description: (*
    This operation takes in input objects and outputs a Test.
*);
preconditions (tQ >= 0) and (tT >= 0);
end nextStep;


operation nextStep
   inputs: T:Test, di:difficulty, nQ:numQuestions, iP:includeByProf, dS:discludeSince, dP:discludeByProf, qT:questionTypes, kw:keywords;
   outputs: Test;
   description: (*
    This operation takes in input objects and outputs a Test.
*);
preconditions (di > 0) and (nQ > 0) 
(*
 *Difficulty can be 0 or less and number of Questions cant be 0 or less. Else, other inputs can be left empty.
 * )
end nextStep;


operation generate
inputs: Test;
outputs: Test;
description: (*
    This operation takes in Question objects and makes it into a Test.
*);
end generate;


operation testPreview
inputs: Test;
outputs:Test;
description: (*
    This operation takes in a Test and displays them to the Instructor
*);
end testPreview;


operation deleteQuestion
inputs: T:Test, Q:Question;
outputs: T':Test;
description: (*
    This operation takes in a Test and deletes 1 Question object from it
*);
precondition: (Q in T);
postcondition: (forall (Q' in T) (Q' in T') iff ((Q' in T)))
end deleteQuestion;


operation EditQuestion
inputs: QDB:QuestionDB, Q:Question, T:Test;
outputs: T':Test;
description: (*
    This operation takes in a Question. The Instructor can remove the Question from the Test, or he can search for a particular Question in the QuestionDB. Then the Instructor can add the Question to the Test.
*);
precondition: (Q in T);
end EditQuestion;


operation addQuestion
inputs: T:Test, Q:Question, QDB:QuestionDB;
outputs: T':Test;
description: (*
	This operation takes in a Question and adds it to the Test
*)
precondition: (Q in QDB);
postcondition: (Q in T');
end addQuestion;


