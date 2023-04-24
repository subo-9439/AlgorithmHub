-- 코드를 입력하세요
SELECT ANIMAL_ID , NAME 
FROM ANIMAL_INS
WHERE Lower(name) like '%el%' and ANIMAL_TYPE Like ('Dog') order by name 