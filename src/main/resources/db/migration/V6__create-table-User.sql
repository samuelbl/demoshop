CREATE TABLE User(
	id SERIAL NOT NULL,
	email VARCHAR(70),
    password VARCHAR(200),
    enable BOOLEAN,
	CONSTRAINT id_user_pkey PRIMARY KEY (id)
)