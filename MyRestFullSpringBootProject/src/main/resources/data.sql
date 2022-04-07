-- User init
INSERT INTO user (id, login, password)
VALUES ('40288fd58003fba3018003fbd1e70666', 'admin','admin');
INSERT INTO user_role (id, role, user_id)
VALUES ('40288fd58003fba3018003fbd1e70999', 'ADMIN','40288fd58003fba3018003fbd1e70666');

INSERT INTO user (id, login, email, password)
VALUES ('40288fd58003fba3018003fbd1e70000', 'Pasha', 'pasha@gmail','password0');
INSERT INTO user (id, login, email, password)
VALUES ('40288fd58003fba3018003fbd1e70001', 'Sasha', 'sasha@gmail','password1');
INSERT INTO user (id, login, email, password)
VALUES ('40288fd58003fba3018003fbd1e70002', 'Petey', 'petey@gmail','password2');
INSERT INTO user (id, login, email, password)
VALUES ('40288fd58003fba3018003fbd1e70003', 'Masha', 'masha@gmail','password3');
INSERT INTO user (id, login, email, password)
VALUES ('40288fd58003fba3018003fbd1e70004', 'Danila', 'danila@gmail','password4');

-- Role init

