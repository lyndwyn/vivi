/*
	Create answers
*/
INSERT INTO answer
	VALUES (1, 'Antwort A', 0);
INSERT INTO answer
	VALUES (2, 'Antwort B', 1);
INSERT INTO answer
	VALUES (3, 'Antwort C', 0);
INSERT INTO answer
	VALUES (4, 'Antwort D', 1);
INSERT INTO answer
	VALUES (5, 'Antwort 1A', 1);
INSERT INTO answer
	VALUES (6, 'Antwort 2B', 0);
INSERT INTO answer
	VALUES (7, 'Antwort 3C', 1);
INSERT INTO answer
	VALUES (8, 'Antwort 4D', 0);
	
/*
	Create questions
*/	
INSERT INTO question
	VALUES (1, 'Question one?', 1, 'read carefully!');
INSERT INTO question
	VALUES (2, 'Question two?', 1, 'congrats! you did it =)');
	
/*
	Create exams
*/
INSERT INTO exam
	VALUES (1, 'ABC Exam', '2019-04-15', 'Room: Xyz, Start: 10.00');
INSERT INTO exam
	VALUES (2, 'One Question Exam', '2019-07-06', 'Room: Zzz, Start: 08.00');
	
/*
	question_answer
*/
INSERT INTO question_answer 
	VALUES (1, 5);	
INSERT INTO question_answer 
	VALUES (1, 6);	
INSERT INTO question_answer 
	VALUES (1, 7);	
INSERT INTO question_answer 
	VALUES (1, 8);	
INSERT INTO question_answer 
	VALUES (1, 1);	
	
INSERT INTO question_answer 
	VALUES (2, 1);	
INSERT INTO question_answer 
	VALUES (2, 2);
INSERT INTO question_answer 
	VALUES (2, 3);
INSERT INTO question_answer 
	VALUES (2, 4);		
	
/*
	exam_question
*/	
INSERT INTO exam_question 
	VALUES (1, 1);
INSERT INTO exam_question 
	VALUES (1, 2);
INSERT INTO exam_question 
	VALUES (2, 2);