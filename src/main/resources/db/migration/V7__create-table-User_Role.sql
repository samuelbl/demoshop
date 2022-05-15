CREATE TABLE User_Role(
	role_id INT4 NOT NULL,
	user_id INT4 NOT NULL,
	CONSTRAINT id_userrole_pkey PRIMARY KEY (user_id,role_id),
	CONSTRAINT fk_role_type_id FOREIGN KEY (role_id) REFERENCES Role(id),
    CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES User(id)
)