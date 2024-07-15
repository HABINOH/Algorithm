-- 코드를 작성해주세요
SELECT
 d.id
,d.email
,d.first_name
,d.last_name
FROM 
 SKILLCODES s
JOIN
 DEVELOPERS d
ON
 s.code & d.skill_code = s.code
WHERE
 s.category = 'Front End'
GROUP BY
 d.id, d.email, d.first_name, d.last_name
ORDER BY
 1

