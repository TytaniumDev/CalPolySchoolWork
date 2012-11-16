operation gradeTest
inputs: Test;
outputs: TestReport;
description: (*
   This operation takes in a completed test and generates a test report.
*);
precondition:
    (*
     * The test must fully completed by the student.
     *)
    (Question* is gradingStatus = taken or gradingStatus = gradedComputer or gradingStatus = gradedUser);       
postcondition:
end gradeTest;

operation courseScores
inputs: Test*;
outputs: TestReport;
description: (*
   This operation takes in a group of completed tests from a specific course and generates a test report based of all the tests administered for the course.
*);
precondition:
    (*
     * The test must fully completed by the student.
     *)
    (Question* is gradingStatus = taken or gradingStatus = gradedComputer or gradingStatus = gradedUser);       
postcondition:
end courseScores;

operation studentScores
inputs: Test*;
outputs: TestReport;
description: (*
   This operation takes in a group of completed tests from a specific student and generates a test report based of all the tests completed for the student.
*);
precondition:
    (*
     * The test must fully completed by the student.
     *)
    (Question* is gradingStatus = taken or gradingStatus = gradedComputer or gradingStatus = gradedUser);       
postcondition:
end studentScores;

operation analyzeScores
inputs: Test*, Option;
outputs: TestReport;
description: (*
   This operation takes in a group of the same completed tests and generates a test report based on the option(Question, Type, Point Value) the user has specified.
*);
precondition:
    (*
     * The test must fully completed by the student.
     *)
    (Question* is gradingStatus = taken or gradingStatus = gradedComputer or gradingStatus = gradedUser and option != NULL);       
postcondition:
end analyzeScores;
object Option = string;
