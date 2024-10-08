-- 코드를 입력하세요
WITH MAX_VIEW AS (
SELECT
 *
FROM
 USED_GOODS_BOARD
ORDER BY
 VIEWS DESC LIMIT 1
)
SELECT 
 CONCAT('/home/grep/src/', ugf.board_id, '/', ugf.file_id, ugf.file_name, ugf.file_ext) AS FILE_PATH
FROM
 USED_GOODS_FILE ugf
JOIN
 MAX_VIEW mv
ON
 ugf.board_id = mv.board_id
ORDER BY
 ugf.file_id DESC













# SELECT
# CONCAT("/home/grep/src/", f.BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT) AS FILE_PATH
# FROM USED_GOODS_BOARD b JOIN USED_GOODS_FILE f
# ON b.BOARD_ID = f.BOARD_ID
# WHERE b.VIEWS = (SELECT MAX(VIEWS) FROM USED_GOODS_BOARD)
# ORDER BY FILE_ID DESC