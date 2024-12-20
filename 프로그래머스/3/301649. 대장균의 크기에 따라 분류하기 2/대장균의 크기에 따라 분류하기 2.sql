-- 코드를 작성해주세요
WITH SIZE_RANK AS (
SELECT
ID,
NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS S_RANK
FROM ECOLI_DATA
)
SELECT
ID,
CASE WHEN S_RANK <= 1 THEN "CRITICAL"
WHEN S_RANK <= 2 THEN "HIGH"
WHEN S_RANK <= 3 THEN "MEDIUM"
ELSE "LOW"
END AS COLONY_NAME
FROM SIZE_RANK
ORDER BY 1