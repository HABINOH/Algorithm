-- 코드를 작성해주세요
WITH NO_UPGRADE AS (
SELECT
it1.item_id
FROM ITEM_TREE it1
LEFT JOIN ITEM_TREE it2
ON it1.item_id = it2.parent_item_id
WHERE it2.item_id IS NULL
)
SELECT
nu.item_id
, ii.item_name
, ii.rarity
FROM ITEM_INFO ii
JOIN NO_UPGRADE nu
ON ii.item_id = nu.item_id
ORDER BY 1 DESC










# SELECT 
#     ii.ITEM_ID, 
#     ii.ITEM_NAME, 
#     ii.RARITY
# FROM 
#     ITEM_INFO ii
# LEFT JOIN 
#     ITEM_TREE it
# ON 
#     ii.ITEM_ID = it.PARENT_ITEM_ID
# WHERE 
#     it.ITEM_ID IS NULL
# ORDER BY 
#     ii.ITEM_ID DESC;