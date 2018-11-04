CREATE TABLE member
(
  member_no       BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  id              VARCHAR2(20)                      NOT NULL,
  password        VARCHAR2(60)                      NOT NULL,
  name            VARCHAR2(30)                      NULL,
  member_group_no BIGINT                            NULL,
  delete_yn       VARCHAR2(1)                       NOT NULL DEFAULT 'N',
  register_ymdt   TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_ymdt     TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE role
(
  role_no       BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name          VARCHAR2(20)                      NULL,
  delete_yn     VARCHAR2(1)                       NOT NULL DEFAULT 'N',
  register_ymdt TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_ymdt   TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE member_role_mapping
(
  member_role_mapping_no BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  member_no              BIGINT                            NOT NULL,
  role_no                BIGINT                            NOT NULL,
  delete_yn              VARCHAR2(1)                       NOT NULL DEFAULT 'N',
  register_ymdt          TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_ymdt            TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE member_group
(
  member_group_no BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
  name            VARCHAR2(20)                      NOT NULL,
  description     TEXT,
  delete_yn       VARCHAR2(1)                       NOT NULL DEFAULT 'N',
  register_ymdt   TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_ymdt     TIMESTAMP                         NOT NULL DEFAULT CURRENT_TIMESTAMP
)