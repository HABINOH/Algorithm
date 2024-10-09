-- 코드를 입력하세요
SELECT
  MONTH(START_DATE) AS MONTH,
  CAR_ID,
  COUNT(CAR_ID) AS RECORDS
FROM (
  SELECT
    CAR_ID,
    START_DATE,
    COUNT(CAR_ID) OVER (PARTITION BY CAR_ID) AS CAR_RENTAL_COUNT
  FROM 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
  WHERE 
    START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
) t
WHERE 
  CAR_RENTAL_COUNT >= 5
GROUP BY 
  MONTH(START_DATE), CAR_ID
ORDER BY 
  1, 2 DESC;




# WITH CAR AS (
# SELECT
#  CAR_ID
# FROM 
#  CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE
#  START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
# GROUP BY
#  CAR_ID
# HAVING
#  COUNT(CAR_ID) >= 5
# )
# SELECT
#   MONTH(START_DATE) AS MONTH,
#   CAR_ID,
#   COUNT(CAR_ID) AS RECORDS
# FROM 
#   CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE 
#   CAR_ID IN (SELECT CAR_ID FROM CAR)
# AND
#   START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
# GROUP BY 
#   MONTH(START_DATE), CAR_ID
# ORDER BY 
#   1, 2 DESC;














# SELECT
# MONTH(START_DATE) AS MONTH
# , CAR_ID
# , COUNT(CAR_ID) AS RECORDS
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE 
# CAR_ID IN (SELECT
#             CAR_ID
#           FROM
#            CAR_RENTAL_COMPANY_RENTAL_HISTORY
#           WHERE
#            START_DATE 
#            BETWEEN '2022-08-01' AND '2022-10-31'
#           GROUP BY CAR_ID
#           HAVING COUNT(CAR_ID) >= 5
#           ) 
# AND
# START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
# GROUP BY 1,2
# ORDER BY 1,2 DESC