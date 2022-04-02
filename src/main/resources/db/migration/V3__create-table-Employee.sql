CREATE TABLE Employee(
	id SERIAL NOT NULL,
	name VARCHAR(50),
	type_id INT4 NOT NULL,
	shop_id INT4 NOT NULL,
	telephone VARCHAR(20),
	address VARCHAR(200),
	employment_date DATE,
	CONSTRAINT id_employeeType_pkey PRIMARY KEY (id),
	CONSTRAINT fk_employeeType_type_id FOREIGN KEY (type_id) REFERENCES EmployeeType(id),
    CONSTRAINT fk_employeeType_shop_id FOREIGN KEY (shop_id) REFERENCES Shop(id)
)