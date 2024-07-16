-- 코드를 작성해주세요
WITH max_score AS (
    SELECT
     emp_no
    ,SUM(score) AS SCORE
    FROM
     HR_GRADE
    WHERE
     year = 2022
    GROUP BY
     emp_no
)
SELECT
 ms.score
,he.emp_no
,he.emp_name
,he.position
,he.email
FROM
 HR_EMPLOYEES he
JOIN
 max_score ms
ON
 he.emp_no = ms.emp_no
WHERE
 ms.score = (SELECT MAX(score) FROM max_score)
