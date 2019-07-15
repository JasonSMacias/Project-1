-- DROP TABLE Employee;
-- DROP TABLE Manager;
-- DROP TABLE ReimbReq;

CREATE TABLE Employee (
  usr_id NUMBER NOT NULL PRIMARY KEY,
  password VARCHAR(60),
  security_q VARCHAR(200),
  isManager Boolean(),
);

CREATE TABLE ReimbReq (
  req_id NUMBER PRIMARY KEY;
  emp_id NUMBER FOREIGN KEY REFERENCES Employee(usr_id);
  -- value
  -- description
  -- date
  //
  status VARCHAR(15),
);

CREATE TABLE img (
  img_id NUMBER,
  req_id NUMBER FOREIGN KEY REFERENCES ReimbReq(req_id);
  imgFilePath VARCHAR(100),
);
/

-- sequence here

-- trigger here