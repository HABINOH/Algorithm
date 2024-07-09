-- 코드를 입력하세요

SELECT 
  ugb.TITLE
, ugb.BOARD_ID
, ugr.REPLY_ID
, ugr.WRITER_ID
, ugr.CONTENTS
, date_format(ugr.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD ugb
RIGHT JOIN USED_GOODS_REPLY ugr
ON ugb.BOARD_ID = ugr.BOARD_ID
WHERE year(ugb.CREATED_DATE) = 2022
AND month(ugb.CREATED_DATE) = 10
ORDER BY 6 ASC, 1 ASC















# SELECT 
# board.TITLE
# , board.BOARD_ID
# , reply.REPLY_ID
# , reply.WRITER_ID
# , reply.CONTENTS
# , date_format(reply.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
# FROM USED_GOODS_BOARD board
# JOIN USED_GOODS_REPLY reply
# ON reply.BOARD_ID = board.BOARD_ID
# WHERE board.CREATED_DATE LIKE '2022-10%'
# ORDER BY reply.CREATED_DATE, board.TITLE