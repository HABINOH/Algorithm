-- 코드를 작성해주세요

SELECT 
 he.dept_id
,hd.dept_name_en
,ROUND(AVG(he.sal)) AS AVG_SAL
FROM HR_EMPLOYEES he
JOIN HR_DEPARTMENT hd
ON he.dept_id = hd.dept_id
GROUP BY he.dept_id
ORDER BY 3 DESC