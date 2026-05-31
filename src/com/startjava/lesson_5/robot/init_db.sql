\c robots

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
    id         SERIAL PRIMARY KEY,
    model_name TEXT,
    mark       TEXT,
    height     INTEGER,
    weight     INTEGER,
    status     TEXT,
    origin     TEXT,
    LAUNCH     DATE,
    kaiju_kill INTEGER
);

\ir populate.sql
\ir queries.sql