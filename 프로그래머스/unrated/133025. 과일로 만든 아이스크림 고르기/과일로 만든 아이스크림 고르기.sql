-- 코드를 입력하세요
SELECT f.FLAVOR 
FROM FIRST_HALF f
inner join ICECREAM_INFO i on f.FLAVOR = i.FLAVOR and f.total_order > 3000 and i.INGREDIENT_TYPE = 'fruit_based'

