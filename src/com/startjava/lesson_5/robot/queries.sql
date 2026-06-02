\echo 'Display the entire table'
SELECT *
  FROM jaegers
ORDER BY model_name;

\echo 'Display non-destroyed jaegers'
SELECT *
  FROM jaegers
 WHERE status != 'Destroyed'
ORDER BY model_name;

\echo 'Display Mark-1 and Mark-4 series jaegers'
SELECT *
  FROM jaegers
 WHERE mark IN ('Mark-1', 'Mark-4')
ORDER BY model_name;

\echo 'Display all jaegers except Mark-1 and Mark-4, sorted by mark descending'
SELECT *
  FROM jaegers
 WHERE mark NOT IN ('Mark-1', 'Mark-4')
ORDER BY mark DESC;

\echo 'Display the oldest jaeger'
SELECT *
  FROM jaegers
 WHERE launch =
       (SELECT MIN(launch)
          FROM jaegers)
ORDER BY model_name;

\echo 'Display model_name, mark, launch, and kaiju_kill for jaegers with most kaiju_kill'
SELECT model_name,
       mark,
       launch,
       kaiju_kill
  FROM jaegers
 WHERE kaiju_kill =
       (SELECT MAX(kaiju_kill)
          FROM jaegers)
ORDER BY model_name;

\echo 'Display the average weight of jaegers rounded to 3 decimal'
SELECT ROUND(CAST(AVG(weight) AS NUMERIC), 3) AS avg_weight
  FROM jaegers;

\echo 'Increment kaiju_kill by 1 for non-destroyed jaegers and display the table'
UPDATE jaegers
   SET kaiju_kill = kaiju_kill + 1
 WHERE status != 'Destroyed';

SELECT *
  FROM jaegers
ORDER BY model_name;

\echo 'Delete destroyed jaegers and display the remaining ones'
DELETE FROM jaegers
      WHERE status = 'Destroyed';

SELECT *
  FROM jaegers
ORDER BY model_name;