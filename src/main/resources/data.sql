 INSERT INTO member (id, password, name, member_group_no) VALUES ('apple', '1234_itWasEncrypt', '사과_운영자', 1);
INSERT INTO member (id, password, name, member_group_no) VALUES ('banana', '1234_itWasEncrypt', '바나나_운영자_작가', 1);
INSERT INTO member (id, password, name, member_group_no) VALUES ('orange', '1234_itWasEncrypt', '오렌지_작가', 2);
INSERT INTO member (id, password, name, member_group_no, delete_yn) VALUES ('kiwi', '1234_itWasEncrypt', '키위_운영자_탈퇴', 1, 'Y');

INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO role (name) VALUES ('WRITER');
INSERT INTO role (name) VALUES ('CLIENT');

INSERT INTO member_role_mapping (member_no, role_no) VALUES (1, 1);
INSERT INTO member_role_mapping (member_no, role_no) VALUES (2, 1);
INSERT INTO member_role_mapping (member_no, role_no) VALUES (2, 2);
INSERT INTO member_role_mapping (member_no, role_no) VALUES (2, 3);
INSERT INTO member_role_mapping (member_no, role_no) VALUES (3, 2);

INSERT INTO member_group (name, description) VALUES ('운영그룹', '운영자들을 위한 그룹');
INSERT INTO member_group (name, description) VALUES ('작가그룹', '작가들을 위한 그룹');