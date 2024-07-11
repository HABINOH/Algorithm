-- 코드를 작성해주세요

SELECT 
    ii.ITEM_ID, 
    ii.ITEM_NAME, 
    ii.RARITY
FROM 
    ITEM_INFO ii
LEFT JOIN 
    ITEM_TREE it
ON 
    ii.ITEM_ID = it.PARENT_ITEM_ID
WHERE 
    it.ITEM_ID IS NULL
ORDER BY 
    ii.ITEM_ID DESC;

