-- 코드를 작성해주세요
WITH NEW_FISH_INFO AS (
    SELECT 
        ID, 
        FISH_TYPE,
        CASE 
            WHEN LENGTH IS NULL THEN 10
            ELSE LENGTH
        END AS LENGTH,
        TIME
    FROM 
        FISH_INFO
),
MAX_FISH AS (
    SELECT 
        FISH_TYPE
    FROM 
        NEW_FISH_INFO
    GROUP BY 
        FISH_TYPE
    HAVING 
        AVG(LENGTH) >= 33
)
SELECT
    COUNT(nfi.fish_type) AS FISH_COUNT,
    MAX(nfi.length) AS MAX_LENGTH,
    nfi.fish_type AS FISH_TYPE
FROM
    NEW_FISH_INFO nfi
JOIN
    MAX_FISH mf
ON
    nfi.fish_type = mf.fish_type
GROUP BY 
    nfi.fish_type
ORDER BY 
    nfi.fish_type;

















# SELECT
# COUNT(*) AS FISH_COUNT
# ,MAX(LENGTH) AS MAX_LENGTH
# ,FISH_TYPE
# FROM FISH_INFO
# GROUP BY FISH_TYPE
# HAVING AVG(CASE WHEN LENGTH IS NULL THEN 10 ELSE LENGTH END) >= 33
# ORDER BY 3