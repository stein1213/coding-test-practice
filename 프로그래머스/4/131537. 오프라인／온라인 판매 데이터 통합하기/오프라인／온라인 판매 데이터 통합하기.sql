-- 코드를 입력하세요
SELECT DATE_FORMAT(RESULT.SALES_DATE, '%Y-%m-%d') AS SALES_DATE, RESULT.PRODUCT_ID, RESULT.USER_ID, RESULT.SALES_AMOUNT
FROM 
    (SELECT SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT FROM ONLINE_SALE
    UNION
    SELECT SALES_DATE, PRODUCT_ID, NULL AS USER_ID, SALES_AMOUNT FROM OFFLINE_SALE) RESULT
WHERE RESULT.SALES_DATE LIKE '2022-03%'
ORDER BY RESULT.SALES_DATE ASC, RESULT.PRODUCT_ID ASC, RESULT.USER_ID ASC