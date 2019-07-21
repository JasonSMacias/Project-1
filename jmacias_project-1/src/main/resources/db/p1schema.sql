DROP TABLE img;
DROP TABLE ReimbReq;
DROP TABLE Employee;

CREATE TABLE Employee (
  usr_id INTEGER NOT NULL PRIMARY KEY,
  u_name varchar2(100),
  pword VARCHAR2(60) NOT NULL,
  security_q VARCHAR2(200),
  security_a VARCHAR2(150),
  isManager CHAR(1) NOT NULL
);

CREATE TABLE ReimbReq (
  req_id INTEGER NOT NULL PRIMARY KEY,
  emp_id INTEGER NOT NULL,
  resolvedBy INTEGER,
  value NUMBER NOT NULL,
  description VARCHAR2(200),
  date_requested DATE NOT NULL,
  status VARCHAR(15) NOT NULL,
  CONSTRAINT ReimbReq_fk FOREIGN KEY (emp_id) REFERENCES Employee(usr_id)
);

CREATE TABLE img (
  img_id INTEGER NOT NULL PRIMARY KEY,
  req_id INTEGER NOT NULL,
  imgFile BLOB NOT NULL,
  CONSTRAINT img_fk FOREIGN KEY (img_id) REFERENCES ReimbReq(req_id)
);
/


-- sequences here
 DROP SEQUENCE emp_id_seq;
CREATE SEQUENCE emp_id_seq
  START WITH 1
  INCREMENT BY 1
;
 DROP SEQUENCE req_id_seq;
CREATE SEQUENCE req_id_seq
  START WITH 1
  INCREMENT BY 1
;
 DROP SEQUENCE img_id_seq;
CREATE SEQUENCE img_id_seq
    START WITH 1
    INCREMENT BY 1
;
/
-- triggers here
CREATE OR REPLACE TRIGGER emp_seq_trigger
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
    IF :new.usr_id IS NULL
    THEN
        SELECT emp_id_seq.nextval INTO :new.usr_id FROM dual;
    END IF;
END;
/
CREATE OR REPLACE TRIGGER req_seq_trigger
BEFORE INSERT ON ReimbReq
FOR EACH ROW
BEGIN
    IF :new.req_id IS NULL
    THEN
        SELECT req_id_seq.nextval INTO :new.req_id FROM dual;
    END IF;
END;
/
CREATE OR REPLACE TRIGGER img_seq_trigger
BEFORE INSERT ON img
FOR EACH ROW
BEGIN
    IF :new.img_id IS NULL
    THEN
        SELECT img_id_seq.nextval INTO :new.img_id FROM dual;
    END IF;
END;