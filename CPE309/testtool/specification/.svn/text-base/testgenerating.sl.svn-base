(*
  *
  * This file defines objects and operations related to the test generation.
  * 
  * See Sections 2.2 of the Milestone 10 requirements.
  * 
*)

operation AddQuestions
  inputs: ql:QuestionList, testQs:TestGeneratorQuestion*, q:TGQuestion;
  outputs: ql':QuestionList, testQs':TestGeneratorQuestion*;
  description: (*
    * Adds one or more questions to the Test Generator under the Question List
  *);

  precondition: (*
    * The questions have not been added to the test generator
  *)
  forall (testQs:TestGeneratorQuestion)
    (not (exists (testQs in ql)  testQs.qst = q ));

  postcondition: (*
    *  The TestGeneratorQuestions are in the TestGenerator if any only if
    *  they are the TestGeneratorQuestions to be added
  *)
  forall (testQs':TestGeneratorQuestion) (
    forall (testQs:TestGeneratorQuestion) (
    ((testQs' in ql') iff (testQs'.qst = testQs.qst)) 
    ));
  
end AddQuestions;

operation AddAttribute
  inputs: al:AttributeList, testA:TestAttribute*, tex:AttributeText;
  outputs: al':AttributeList, testA':TestAttribute*;
  description: (*
    * Adds one or more attributes to the Test Generator under the AttributeList
  *);

  precondition: (*
    * The attributes have not been added to the test generator
  *)
  forall (testA:TestAttribute)
    (not (exists (testA in al) testA.aText = tex));

  postcondition: (*
    *  The TestAttributes are in the TestGenerator if and only if
    *  they are the TestAttributes to be added
  *)
  forall (testA':TestAttribute) (
    forall (testA:TestAttribute) (
    ((testA' in al') iff ((testA'.aText = testA.aText)) or (testA'.img = testA.img))
    )
  );
end AddAttribute;

operation ReplaceTestQuestion
  inputs: ql:QuestionList, tq:TestGeneratorQuestion, q:TGQuestion; 
  outputs: ql':QuestionList, tq':TestGeneratorQuestion;
  description: (*
    * Replaces the selected test question with a new selected one
  *);
  
  precondition: (*
    * The TestGeneratorQuestion has not been added to the test generator
  *)
   (not (exists (tq in ql)  tq.qst = q ));

  postcondition: (*
    *  The TestGeneratorQuestion is in the QuestionList if and only if
    *  it is the TestQuestion to be added
  *)
  forall (tq:TestGeneratorQuestion) (
    ((tq' in ql') iff (tq'.qst = tq.qst))
  );
end ReplaceTestQuestion;   

operation DeleteTestQuestion
  inputs: ql:QuestionList, tq:TestGeneratorQuestion, q:TGQuestion;
  outputs: ql':QuestionList, tq':TestGeneratorQuestion;
  description: (*
    * Removes the selected test TestGeneratorQuestion from the test
  *);

  precondition: (*
    * The TestGeneratorQuestion exists in the test
  *)
   (exists (tq in ql)  tq.qst = q );

  postcondition: (*
    *  The TestGeneratorQuestion is not in the QuestionList if and only if
    *  it is the TestQuestion that was removed
  *)
  forall (tq:TestGeneratorQuestion) (
    (not ((tq' in ql')) iff (tq'.qst != tq.qst))
  );
end DeleteTestQuestion;

operation SaveTest
  inputs: tst:Test, tdb:TestDatabase, title:TestTitle;
  outputs: tst':Test, tdb':TestDatabase;
  description: (*
    * Saves the test to the test database
  *);

  precondition: (*
    * The test does not exist in the TestDatabase already
  *)
  (not (exists (tst in tdb)  tst.TG.tTitle = title));

  postcondition: (*
    *  The Test is in the TestDatabse if and only if
    *  the test title is the one that was saved
  *)
  forall (tst:TestDatabase) (
    (tst' in tdb') iff (tst'.TG.tTitle = title) 
  );
end SaveTest;

operation PreviewTest
  inputs: TG:TestGenerator, qlc:QuestionListCount;
  outputs: TG':TestGenerator, qlc':QuestionListCount;
  description: (*
    * ability to preview a test before it is saved
  *);

  precondition: (*
    * ql is not empty
  *)
  qlc > 1;

  postcondition: (*
    *  question list count remains the same
  *)
  qlc' = qlc;
end PreviewTest;

operation CancelOp
  inputs: TG:TestGenerator, title:TestTitle;
  outputs: TG':TestGenerator, title':TestTitle;
  description: (*
    * cancels any operation
  *);

  precondition: (*
    * there is a test generator that was being modified
  *)
  TG.tTitle = title;

  postcondition: (*
    *  the test generator remains the same
  *)
  TG'.tTitle = TG.tTitle;
end CancelOp;

object TestGeneratorQuestion
  components: qst:TGQuestion and 
              ans:TGAnswer and 
              cou:QuestionCourse and
              auth:QuestionAuthor and
              d:QuestionDifficulty and 
              tl:TimeLimit and 
              ty:QuesType and 
              ind:LocationIndex and 
              pv:TestPointValue ;
  description: (*
    * Represents a question in the test generator
  *);

end TestGeneratorQuestion;

object TestDatabase
  components: tst:Test*;
  description: (*
    * Represents the database of Tests
  *);
end TestDatabase;

object TestAttribute
  components: img:AttributeImage and aText:AttributeText and li:LocationIndex;
  description: (*
    * Represents a question in the test generator
  *);

end TestAttribute;

object Test
components: TG:TestGenerator;
  description: (*
    * The object for a test as a whole
  *);
end Test;

object TestGenerator 
  components: tTitle:TestTitle and date:CompleteDate and ql:QuestionList and al:AttributeList and bpu:ButtonPopUps;
  description: (*
    * contains all the individual pieces of a complete test
  *);
end TestGenerator;

object AddingTestQuestion
  components: cou:QuestionCourse and 
              qty:TestQuantity and 
              lastP:LastPulled and 
              bpu:ButtonPopUps and 
              crit:Criteria*;
  description: (*
    * Represents the adding a test question dialog
  *);
end AddingTestQuestion;

object AddingTestAttribute
  components: aType:AttributeType and 
	      bpu:ButtonPopUps and 
	      aText:AttributeText and 
              img:AttributeImage;
  description: (*
    * Represents the adding a test attribute dialog
  *);
end AddingTestAttribute;

object Criteria 
  components: qty:TestQuantity and cType:CriteriaType and cSpec:CriteriaSpecific;
  description: (*
    * A criteria for the test generator to use while generation
  *);
end Criteria;

object QuestionList
  components: tq:TestGeneratorQuestion*;
  description: (*
    * The list of questions on a test
  *);
end QuestionList;

object CompleteDate
  components: Mo and D and Yr;
  description: (*
    * Represents a date
  *);
end CompleteDate;

object AttributeList
  components: ta:TestAttribute*;
  description: (*
    * The list of attributes on a test
  *);
end AttributeList;

object ButtonPopUps
  components: bName:ButtonName;
  description: (*
    * A button
  *);
end ButtonPopUps;

object TestPointValue = integer
  description: (*
    * The number of points the question is worth
  *);
end TestPointValue;

object AttributeText = string
  description: (*
    * The actual input text the instructor inputs to be displayed
  *);
end AttributeText;

object QuestionListCount = integer
  description: (*
    * The count of questions for a question list
  *);
end Count;

object LocationIndex = string
  description: (*
    * The location in the test of the question or attribute
  *);
end LocationIndex;

object QuestionCourse = string
  description: (*
    * The course the question is for
  *);
end QuestionCourse;


object QuestionAuthor = string
  description: (*
    * The author of the question
  *);
end QuestionAuthor;


object TGQuestion = string
  description: (*
    * The text of the actual question
  *);
end TGQuestion;

object TGAnswer = string
  description: (*
    * The answer to a question
  *);
end TGanswer;

object ButtonName = string
  description: (*
    * Name on a ButtonPopUps object
  *);
end ButtonName;

object CriteriaType = string
  description: (*
    * The type a criteria is
  *);
end CriteriaType;

object Mo = integer
  description: (*
    * Represents the month
  *);
end Mo;

object D = integer
  description: (*
    * Represents the day
  *);
end D;

object Yr = integer
  description: (*
    * Represents the year
  *);
end Yr;

object CriteriaSpecific = string
  description: (*
    * The specific criteria for the test generator to use while generating a test
    * i.e. if the Criteria is a QuestionType, the CriteriaSpecific is either multiple choice, 
    * short answer, etc.
  *);
end CriteriaSpecific;

object QuestionDifficulty = integer
  description: (*
    * The difficulty of a question (1 - 5)
  *);
end QuestionDifficulty;

object QuesType = string
  description: (*
    * The type of a question. i.e. multiple choice, short answer, etc
  *);
end QuesType;

object AttributeImage = string
  description: (*
    * URL of the image
  *);
end AttributeImage;

object TimeLimit = integer
  description: (*
    * The number of minutes for a time limit
  *);
end TimeLimit;

object TestTitle = string
  description: (*
    * Title of a test
  *);
end TestTitle;

object AttributeType = string
description: (*
    * The type of the attribute. Either image or text
  *);
end AttributeType;

object TestQuantity = integer
  description: (*
    * The number of questions on a test
  *);
end TestQuantity;

object LastPulled = integer
  description: (*
    * Tells the generator to not use questions pulled in the last x months
  *);
end LastPulled;
          

