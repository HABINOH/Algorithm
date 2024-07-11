-- 코드를 작성해주세요

SELECT 
a.item_id
,a.item_name
FROM ITEM_INFO a
JOIN ITEM_TREE b
ON a.item_id = b.item_id
WHERE b.parent_item_id IS NULL
ORDER BY 1