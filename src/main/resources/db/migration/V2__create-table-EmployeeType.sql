CREATE TABLE EmployeeType (
	id SERIAL NOT NULL,
	name VARCHAR(50) NOT NULL CHECK (name in ('Manager', 'Accountant','Clerk')),
	salary DECIMAL(12,2),
	CONSTRAINT id_employe_pkey PRIMARY KEY (id)
)