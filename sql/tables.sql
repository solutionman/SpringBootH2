-- drop table person;
CREATE TABLE person
(
    id      INT         NOT NULL DEFAULT nextval('person_id_seq') PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    role_id VARCHAR(20) NOT NULL
);
CREATE SEQUENCE person_id_seq;

-- drop table role;
CREATE TABLE role
(
    id   INT         NOT NULL DEFAULT nextval('role_id_seq') PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
CREATE SEQUENCE role_id_seq;

INSERT INTO person (name, role_id) values ('name1', 1);
INSERT INTO person (name, role_id) values ('name2', 1);
INSERT INTO person (name, role_id) values ('name3', 2);
INSERT INTO person (name, role_id) values ('name4', 1);
INSERT INTO person (name, role_id) values ('name5', 3);
INSERT INTO person (name, role_id) values ('name6', 1);
INSERT INTO person (name, role_id) values ('name7', 2);
INSERT INTO person (name, role_id) values ('name8', 1);
INSERT INTO person (name, role_id) values ('name9', 3);
INSERT INTO person (name, role_id) values ('name10', 1);

INSERT INTO role (name) values ('role1');
INSERT INTO role (name) values ('role2');
INSERT INTO role (name) values ('role3');

