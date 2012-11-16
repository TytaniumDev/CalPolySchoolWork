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
