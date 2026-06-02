\c robots

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
    id         SERIAL PRIMARY KEY,
    model_name TEXT,
    mark       TEXT,
    height     FLOAT,
    weight     FLOAT,
    status     TEXT,
    origin     TEXT,
    launch     DATE,
    kaiju_kill INTEGER
);

\ir populate.sql
\ir queries.sql