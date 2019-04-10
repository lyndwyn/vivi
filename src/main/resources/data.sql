SET session_replication_role = replica;

/* pw for admin is heinz*/		
INSERT INTO public.users(id, username, password, name, surname, account_expiration_date, credentials_expiration_date, locked, enabled) VALUES (
				1,
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
INSERT INTO public.users(id, username, password, name, surname, account_expiration_date, credentials_expiration_date, locked, enabled) VALUES (
				2,
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
INSERT INTO public.authority VALUES (
	1,
				'WRITE'
			);
INSERT INTO public.authority VALUES (
	2,
				'READ'
			);
			
			
INSERT INTO public.role	VALUES (
	1,
			'ADMIN'
		);
INSERT INTO public.role	VALUES (
	2,
			'USER'
		);
		
/*
 * Link Authorities to Role-Admin (read & write)
 * public.authority_role(authority_id, role_id)
 * */		
INSERT INTO public.authority_role VALUES (
			1, 
			1
		);
INSERT INTO public.authority_role VALUES (
			2, 
			1
		);
		
INSERT INTO public.authority_role VALUES (
			2, 
			2
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
			1, 
			1
		);	
INSERT INTO public.users_role VALUES (
			2, 
			2
		);	

INSERT INTO public.response_option(id, reply_text, correct) VALUES (
			1,
			'they were able to land',
			1
);

INSERT INTO public.response_option(id, reply_text, correct)  VALUES (
			2,
			'they will able to land',
			0
);
INSERT INTO public.response_option(id, reply_text, correct)  VALUES (
			3,
			'as long as',
			1
);

INSERT INTO public.response_option(id, reply_text, correct)  VALUES (
			4,
			'until',
			0
);


INSERT INTO public.question(id, question_text) VALUES (
			1,
			'It will be fine _ you do it the way I told you.'
);

INSERT INTO public.question(id, question_text) VALUES (
			2,
			'If _ a man on the moon, why cant they sort out paper-jams?'
);

INSERT INTO public.question_response_option VALUES (
			1,
			1
);

INSERT INTO public.question_response_option VALUES (
			1,
			2
);

INSERT INTO public.question_response_option VALUES (
			2,
			3
);

INSERT INTO public.question_response_option VALUES (
			2,
			4
);

INSERT INTO public.exam_questions VALUES (
			1,
			1
);

INSERT INTO public.exam_questions VALUES (
			1,
			2
);

INSERT INTO public.exam(id, name, start_date, end_date, duration, minimum_score) VALUES (
			1,
			'Cambridge Advanced C1',
			'2019-04-10',
			'2019-04-10',
			4,
			70
);

SET session_replication_role = DEFAULT;
		
		
		
		
