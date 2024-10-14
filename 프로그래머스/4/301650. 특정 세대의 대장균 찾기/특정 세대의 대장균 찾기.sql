-- 코드를 작성해주세요

WITH RECURSIVE ECOLI_DEPTH AS (
    SELECT ID, 1 AS DEPTH
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    SELECT eda.id, ede.depth + 1 AS depth
    FROM ECOLI_DATA eda
    JOIN ECOLI_DEPTH ede
    ON eda.parent_id = ede.id
)
SELECT ID
FROM ECOLI_DEPTH
WHERE DEPTH = 3
ORDER BY 1