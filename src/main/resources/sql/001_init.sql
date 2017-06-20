BEGIN TRANSACTION;

DROP TABLE IF EXISTS "pins" CASCADE;
DROP SEQUENCE IF EXISTS "pins_seq" CASCADE;

CREATE SEQUENCE "pins_seq" START 100000;
CREATE TABLE "pins" (
  "id_pin"       BIGINT PRIMARY KEY DEFAULT "nextval"('"pins_seq"'),
  "api_token"    TEXT   NOT NULL,
  "operation_id" TEXT   NOT NULL,
  "email"        TEXT   NOT NULL,
  "code"         BIGINT NOT NULL
);

END TRANSACTION;