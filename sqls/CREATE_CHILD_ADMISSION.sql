create table CHILD_SCHOOL_ADMISSION
(
	ID BIGINT  NOT NULL PRIMARY KEY ,
	AADHAR_NO VARCHAR(100) NOT NULL,
	SCHOOL_ID VARCHAR(100) NOT NULL,
	ADMISSION_NO VARCHAR(20) NOT NULL,
	STANDARD VARCHAR(20) NOT NULL,
	CURRENT_STATUS VARCHAR(20) NOT NULL,
	SCHOOLING_YEAR VARCHAR(20) NOT NULL,
	CREATED_ON DATETIME NOT NULL,
	LAST_UPDATED_ON DATETIME NOT NULL,
	CREATED_BY VARCHAR(100) NOT NULL,
	LAST_UPDATED_BY VARCHAR(100) NOT NULL,
	COMMENTS VARCHAR(200) ,
	AUDIT_COMMENTS VARCHAR(1000) NOT NULL,
	ENROLLED_BY VARCHAR(20) NOT NULL
)

