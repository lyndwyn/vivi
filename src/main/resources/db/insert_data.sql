/*
	Create answers
*/
INSERT INTO public.answer(
	reply_text, response)
	VALUES ('Antwort A', 0);
INSERT INTO public.answer(
	reply_text, response)
	VALUES ('Antwort B', 1);
INSERT INTO public.answer(
	reply_text, response)
	VALUES ('Antwort C', 0);
INSERT INTO public.answer(
	reply_text, response)
	VALUES ('Antwort D', 1);
INSERT INTO public.answer(
	reply_text, response)
	VALUES ('Antwort 1A', 1);
INSERT INTO public.answer(
	reply_text, response)
	VALUES ('Antwort 2B', 0);
INSERT INTO public.answer(
	reply_text, response)
	VALUES ('Antwort 3C', 1);
INSERT INTO public.answer(
	reply_text, response)
	VALUES ('Antwort 4D', 0);
	
/*
	Create questions
*/	
INSERT INTO public.question(question_text, scores, notice) 
	VALUES ('Question one?', 1, 'read carefully!');
INSERT INTO public.question(question_text, scores, notice) 
	VALUES ('Question two?', 1, 'congrats! you did it =)');
	
/*
	Create exams
*/
INSERT INTO public.exam(name, date, description) 
	VALUES ('ABC Exam', '2019-04-15', 'Room: Xyz, Start: 10.00');
INSERT INTO public.exam(name, date, description) 
	VALUES ('One Question Exam', '2019-07-06', 'Room: Zzz, Start: 08.00');
	
/*
	question_answer
*/
INSERT INTO public.question_answer 
	VALUES (1, 5);	
INSERT INTO public.question_answer 
	VALUES (1, 6);	
INSERT INTO public.question_answer 
	VALUES (1, 7);	
INSERT INTO public.question_answer 
	VALUES (1, 8);	
INSERT INTO public.question_answer 
	VALUES (1, 1);	
	
INSERT INTO public.question_answer 
	VALUES (2, 1);	
INSERT INTO public.question_answer 
	VALUES (2, 2);
INSERT INTO public.question_answer 
	VALUES (2, 3);
INSERT INTO public.question_answer 
	VALUES (2, 4);		
	
/*
	exam_question
*/	
INSERT INTO public.exam_question 
	VALUES (1, 1);
INSERT INTO public.exam_question 
	VALUES (1, 2);
INSERT INTO public.exam_question 
	VALUES (2, 2);