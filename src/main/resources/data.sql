Insert into
 store.product( "name_product","price","unit")
Values ( 'strela',1.26,'piece');
Insert into
 store.product( "name_product","price","unit")
Values ( 'strela Lux',1.32,'piece');
Insert into
 store.product( "name_product","price","unit")
Values ( 'postsil',1.14,'piece');
INSERT INTO store.users(
	 address, created_at, email, password, password_hash, role, telephon, user_first_name, user_name)
	VALUES (default ,'zp',current_date   , 'ddd@ukr.net',default , default  ,'ADMIN', 0672512541, 'maskov', 'artur');
INSERT INTO store.users(
	 address, created_at, email, password, password_hash, role, telephon, user_first_name, user_name)
	VALUES ( 'kiev',current_date , 'aaa@ukr.net',default , default  ,'CLIENT', 0672512542, 'vasyutin', 'vasya');
INSERT INTO store.users(
	 address, created_at, email, password, password_hash, role, telephon, user_first_name, user_name)
	VALUES ( 'vodyane',current_date  , 'ooo@ukr.net',default , default  ,'DIRECTOR', 0672512543, 'Timlid', 'vova');
