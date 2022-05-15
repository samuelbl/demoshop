INSERT INTO User (email, password, enable) VALUES('bristot@gmail.com','$2a$10$ukLcnpCew.1i3XG5kSwjOOTSfjoIfV2HZzEKiTajSbToQTQc9tzRi', true);
INSERT INTO User (email, password, enable) VALUES('joao@gmail.com','$2a$10$ukLcnpCew.1i3XG5kSwjOOTSfjoIfV2HZzEKiTajSbToQTQc9tzRi', true);
INSERT INTO Role(name) VALUES('Admin');
INSERT INTO Role(name) VALUES('Manager');
INSERT INTO User_Role(role_id, user_id) VALUES(1,1);
INSERT INTO User_Role(role_id, user_id) VALUES(2,1);
INSERT INTO User_Role(role_id, user_id) VALUES(2,2);