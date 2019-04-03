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

SET session_replication_role = DEFAULT;
		
		
		
		
