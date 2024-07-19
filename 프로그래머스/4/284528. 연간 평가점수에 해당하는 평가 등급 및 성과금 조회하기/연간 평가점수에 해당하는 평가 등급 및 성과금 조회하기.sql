-- 코드를 작성해주세요
WITH avgScore AS (
    SELECT
     hg.EMP_NO
    ,he.EMP_NAME
    ,AVG(hg.SCORE) AS AVG_SCORE
    ,he.SAL
    FROM 
     HR_GRADE hg
    JOIN
     HR_EMPLOYEES he
    ON
     hg.emp_no = he.emp_no
    WHERE
     hg.YEAR = 2022
    GROUP BY
     hg.EMP_NO, he.emp_name, he.SAL
)
SELECT
 EMP_NO
,EMP_NAME
,CASE 
    WHEN AVG_SCORE >= 96 THEN 'S'
    WHEN AVG_SCORE >= 90 THEN 'A'
    WHEN AVG_SCORE >= 80 THEN 'B'
    ELSE 'C'
 END AS GRADE
,CASE 
    WHEN AVG_SCORE >= 96 THEN SAL * 0.2
    WHEN AVG_SCORE >= 90 THEN SAL * 0.15
    WHEN AVG_SCORE >= 80 THEN SAL * 0.1
    ELSE 0
 END AS BONUS
FROM 
 avgScore
ORDER BY
 EMP_NO

