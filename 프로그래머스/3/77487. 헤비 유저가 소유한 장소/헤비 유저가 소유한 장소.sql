-- 코드를 입력하세요
SELECT T1.ID, T1.NAME, T1.HOST_ID
FROM PLACES T1
JOIN (
SELECT HOST_ID FROM PLACES A
GROUP BY A.HOST_ID
HAVING COUNT(*) > 1
) T2
ON T1.HOST_ID = T2.HOST_ID
ORDER BY T1.ID
















# WITH HOST AS (
# SELECT *
# FROM
#  PLACES
# GROUP BY HOST_ID
# HAVING COUNT(HOST_ID) >= 2
# ORDER BY ID
# )
# SELECT
#   p.id
# , p.name
# , p.host_id
# FROM PLACES p
# JOIN HOST h
# ON p.host_id = h.host_id















# SELECT
# ID
# , NAME
# , HOST_ID
# FROM PLACES
# WHERE HOST_ID IN 
# (   SELECT
#     HOST_ID
#     FROM PLACES
#     GROUP BY HOST_ID
#     HAVING COUNT(HOST_ID) >= 2
# )ORDER BY 1