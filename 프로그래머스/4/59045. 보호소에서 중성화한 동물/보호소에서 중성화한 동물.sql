-- 코드를 입력하세요
WITH NEUTERED_OK AS (
SELECT *
FROM ANIMAL_INS
WHERE SEX_UPON_INTAKE LIKE '%Spayed%' OR SEX_UPON_INTAKE LIKE '%Neutered%'
),
NEUTERED_NO AS (
SELECT *
FROM ANIMAL_INS
WHERE ANIMAL_ID NOT IN (SELECT ANIMAL_ID FROM NEUTERED_OK)
)
SELECT 
ao.ANIMAL_ID
,ao.ANIMAL_TYPE
,ao.NAME
FROM ANIMAL_OUTS ao
JOIN NEUTERED_NO nn
ON ao.animal_id = nn.animal_id
WHERE ao.sex_upon_outcome LIKE "%Spayed%" OR ao.sex_upon_outcome LIKE "%Neutered%"















# SELECT
# ins.ANIMAL_ID
# , ins.ANIMAL_TYPE
# , ins.NAME
# FROM ANIMAL_INS ins
# JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID
# WHERE ins.SEX_UPON_INTAKE != 'Spayed Female'
# AND
# (outs.SEX_UPON_OUTCOME != ins.SEX_UPON_INTAKE)
# ORDER BY 1