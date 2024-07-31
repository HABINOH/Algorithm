-- 코드를 작성해주세요

WITH FISH AS (
    SELECT
     FISH_TYPE
    FROM
     FISH_NAME_INFO
    WHERE
     FISH_NAME = 'BASS' OR FISH_NAME = 'SNAPPER'
)
SELECT
 COUNT(*) AS FISH_COUNT
FROM 
 FISH f
JOIN
 FISH_INFO fi
ON
 f.fish_type = fi.fish_type

