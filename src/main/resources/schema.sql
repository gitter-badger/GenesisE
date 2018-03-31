CREATE TABLE IF NOT EXISTS student
(
  id              INTEGER      NOT NULL,
  name            VARCHAR(255) NOT NULL,
  passport_number VARCHAR(255),
  PRIMARY KEY (id)
);