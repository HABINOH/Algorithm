SELECT 
      A.NAME, 
      A.DATETIME 
FROM 
      ANIMAL_INS A
LEFT JOIN 
      ANIMAL_OUTS B
ON 
      A.ANIMAL_ID = B.ANIMAL_ID
WHERE 
      B.ANIMAL_ID IS NULL
ORDER BY 
      A.DATETIME LIMIT 3



















-- 코드를 입력하세요
# SELECT 
#   NAME
# , DATETIME
# FROM
#  ANIMAL_INS ins 
# WHERE ins.animal_id NOT IN (
#      SELECT 
#       ANIMAL_ID
#      FROM 
#       ANIMAL_OUTS outs
#      WHERE 
#       ins.animal_id = outs.animal_id
# )
# ORDER BY
#  2 LIMIT 3

















# SELECT
# ins.NAME
# , ins.DATETIME
# FROM ANIMAL_INS ins
# # JOIN ANIMAL_OUTS outs ON ins.ANIMAL_ID = outs.ANIMAL_ID
# WHERE NOT EXISTS (
#     SELECT *
#     FROM ANIMAL_OUTS outs
#     WHERE ins.ANIMAL_ID = outs.ANIMAL_ID
# )ORDER BY 2 LIMIT 3