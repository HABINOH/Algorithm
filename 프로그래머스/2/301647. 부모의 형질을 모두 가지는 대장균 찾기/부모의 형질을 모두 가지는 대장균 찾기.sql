-- 코드를 작성해주세요

SELECT
 child.ID
,child.GENOTYPE
,parent.GENOTYPE AS PARENT_GENOTYPE
FROM
 ECOLI_DATA child
JOIN
 ECOLI_DATA parent
ON
 child.PARENT_ID = parent.ID
WHERE
 (child.GENOTYPE & parent.GENOTYPE) = parent.GENOTYPE
ORDER BY
 1
