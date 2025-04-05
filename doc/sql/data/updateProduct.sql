-- 1. 根据订单数据更新商品销量(sold)和库存(stock)
UPDATE `mall-product`.`product` p
    JOIN (
    SELECT
    product_id,
    SUM(num) AS total_sold
    FROM `mall-order`.`order-detail` od
    JOIN `mall-order`.`orders` o ON od.order_id = o.id
    WHERE o.status IN (3,4,6) -- 已发货、已完成、已评价的订单
    GROUP BY product_id
    ) AS order_stats ON p.id = order_stats.product_id
    SET
        p.stock = GREATEST(0, p.stock - order_stats.total_sold),
        p.sold = order_stats.total_sold;

-- 2. 为没有销量的商品设置随机销量(1-100)
UPDATE `mall-product`.`product`
SET sold = FLOOR(1 + RAND() * 100)
WHERE sold = 0;

-- 3. 确保售罄商品有合理销量(至少等于初始库存)
UPDATE `mall-product`.`product`
SET sold = GREATEST(sold, FLOOR(10 + RAND() * 100))
WHERE stock = 0 AND sold = 0;

-- 4. 设置热门商品销量(100-600)
UPDATE `mall-product`.`product`
SET sold = FLOOR(100 + RAND() * 500)
WHERE id IN (
             3001, 3002, 3003, 3005, 3008, 3011, 3014, 3015, 3021, 3024,
             3025, 3028, 3030, 3037, 3040, 3042, 3045, 3047, 3053, 3057
    );

-- 5. 设置部分商品为售罄状态(库存为0)
UPDATE `mall-product`.`product`
SET stock = 0
WHERE id IN (
             3001, 3008, 3015, 3025, 3037, 3042, 3047, 3053, 3057, 3060,
             3065, 3070, 3073, 3077, 3082, 3087, 3090, 3095, 3099, 3100
    ) AND sold > 0;

-- 6. 更新分类商品数量统计(根据实际商品数量)
UPDATE `mall-product`.`categories` c
SET c.product_num = (
    SELECT COUNT(*)
    FROM `mall-product`.`product` p
    WHERE p.category = c.category AND p.status = 1
);