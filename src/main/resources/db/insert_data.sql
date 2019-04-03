/* pw for admin is heinz*/		
INSERT INTO public.users(username, password, name, surname, account_expiration_date, credentials_expiration_date, locked, enabled) VALUES (
				'admin', 
				'$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy', /* heinz */
				'Ivy', 
				'Musterfrau',
				'2020-01-01',
				'2020-01-01',
				0,
				1
			);
			
/* pw for user is heinz*/			
INSERT INTO public.users(username, password, name, surname, account_expiration_date, credentials_expiration_date, locked, enabled) VALUES (
				'user', 
				'$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy', 
				'Vivienne', 
				'Oberholzer',
				'2020-01-01',
				'2020-01-01',
				0,
				1
			);
			
/*
 * Insert Roles, Authorities and link them to each other
 * */			
INSERT INTO public.authority(name) VALUES (
				'WRITE'
			);
INSERT INTO public.authority(name) VALUES (
				'READ'
			);
			
			
INSERT INTO public.role(name)	VALUES (
			'ADMIN'
		);
INSERT INTO public.role(name)	VALUES (
			'USER'
		);
		
/*
 * Link Authorities to Role-Admin (read & write)
 * public.authority_role(authority_id, role_id)
 * */		
INSERT INTO public.authority_role VALUES (
			7, 
			7
		);
INSERT INTO public.authority_role VALUES (
			8, 
			7
		);
		
/*
 * Link Authorities to Role-User (read) -> user has no authorities
 * 
 * 
INSERT INTO public.authority_role VALUES (
			2, 
			2
		);
*/		
		
/*
 * Link Roles to Users: Admin
 * users_role(users_id, role_id)
 * */
INSERT INTO public.users_role VALUES (
			5, 
			7
		);	
INSERT INTO public.users_role VALUES (
			6, 
			8
		);	

		
		
		
		
		
		
/******************************** ignore this *******************************************/		
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
	
