-- 코드를 입력하세요

SELECT
  ins.animal_id
, ins.name
FROM
 ANIMAL_INS ins
JOIN
 ANIMAL_OUTS outs
ON 
 ins.animal_id = outs.animal_id
WHERE
 ins.datetime > outs.datetime
ORDER BY
 ins.datetime


















# SELECT
# ins.ANIMAL_ID
# , ins.NAME
# FROM ANIMAL_INS ins
# JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID
# WHERE 
# ins.DATETIME > outs.DATETIME
# ORDER BY ins.DATETIME ASC