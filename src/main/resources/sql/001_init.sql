BEGIN TRANSACTION;

DROP TABLE IF EXISTS "pins" CASCADE;
DROP SEQUENCE IF EXISTS "pins_seq" CASCADE;

CREATE SEQUENCE "pins_seq" START 100000;
CREATE TABLE "pins" (
  "id_pin"       BIGINT PRIMARY KEY DEFAULT "nextval"('"pins_seq"'),
  "api_token"    TEXT   NOT NULL UNIQUE,
  "operation_id" TEXT   NOT NULL,
  "email"        TEXT   NOT NULL,
  "code"         INTEGER NOT NULL,
  timestamp BIGINT NOT NULL DEFAULT (extract(epoch from now()) * 1000)
);

END TRANSACTION;