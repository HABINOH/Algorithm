WITH YearlyMax AS (
    SELECT 
        YEAR(DIFFERENTIATION_DATE) AS YEAR,
        MAX(SIZE_OF_COLONY) AS MAX_SIZE
    FROM 
        ECOLI_DATA
    GROUP BY 
        YEAR(DIFFERENTIATION_DATE)
),
YearlyDev AS (
    SELECT 
        YEAR(e.DIFFERENTIATION_DATE) AS YEAR,
        e.SIZE_OF_COLONY,
        y.MAX_SIZE,
        e.ID
    FROM 
        ECOLI_DATA e
    JOIN 
        YearlyMax y
    ON 
        YEAR(e.DIFFERENTIATION_DATE) = y.YEAR
)
SELECT 
    YEAR,
    (MAX_SIZE - SIZE_OF_COLONY) AS YEAR_DEV,
    ID
FROM 
    YearlyDev
ORDER BY 
    YEAR ASC,
    YEAR_DEV ASC;
