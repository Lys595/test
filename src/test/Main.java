package test;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        supermarket.setFruitPrice("apple", BigDecimal.valueOf(8.0));
        supermarket.setFruitPrice("strawberry", BigDecimal.valueOf(13.0));
        supermarket.setFruitPrice("mango", BigDecimal.valueOf(20.0));
        supermarket.setFruitPrice("banana", BigDecimal.valueOf(15.0));

        // 为草莓设置 20% 的折扣
        supermarket.setFruitDiscount("strawberry", BigDecimal.valueOf(0.8));

        // 为苹果设置 10% 的折扣
        supermarket.setFruitDiscount("apple", BigDecimal.valueOf(0.9));

        // 顾客 A 购买了 3 斤苹果和 2 斤草莓
        Fruit[] customerA = {
                new Fruit("apple", BigDecimal.valueOf(3)),
                new Fruit("strawberry", BigDecimal.valueOf(2))
        };
        BigDecimal totalCostA = supermarket.calculateTotalCost(customerA);
        System.out.println("顾客 A 购买 3 斤苹果和 2 斤草莓的总价: " + totalCostA);

        // 启用每满 100 减 10 策略
        supermarket.enableFullDiscount(true);

        // 顾客 B 购买了 3 斤苹果、2 斤草莓和 2 斤芒果
        Fruit[] customerB = {
                new Fruit("apple", BigDecimal.valueOf(3)),
                new Fruit("strawberry", BigDecimal.valueOf(2)),
                new Fruit("mango", BigDecimal.valueOf(2))
        };
        BigDecimal totalCostB = supermarket.calculateTotalCost(customerB);
        System.out.println("顾客 B 购买 3 斤苹果、2 斤草莓和 2 斤芒果的总价: " + totalCostB);

        // 取消草莓打折策略
        supermarket.removeFruitDiscount("strawberry");

        // 顾客 C 购买了 3 斤苹果、5 斤草莓和 2 斤芒果
        Fruit[] customerC = {
                new Fruit("apple", BigDecimal.valueOf(3)),
                new Fruit("strawberry", BigDecimal.valueOf(5)),
                new Fruit("mango", BigDecimal.valueOf(2))
        };
        BigDecimal totalCostC = supermarket.calculateTotalCost(customerC);
        System.out.println("顾客 C 购买 3 斤苹果、5 斤草莓和 2 斤芒果的总价: " + totalCostC);

        // 新增一种水果：香蕉，并且为香蕉设置 15% 的折扣
        supermarket.setFruitDiscount("banana", BigDecimal.valueOf(0.85));

        // 顾客 D 购买了 3 斤苹果、2 斤草莓、1 斤芒果和 2 斤香蕉
        Fruit[] customerD = {
                new Fruit("apple", BigDecimal.valueOf(3)),
                new Fruit("strawberry", BigDecimal.valueOf(2)),
                new Fruit("mango", BigDecimal.valueOf(1)),
                new Fruit("banana", BigDecimal.valueOf(2))
        };
        BigDecimal totalCostD = supermarket.calculateTotalCost(customerD);
        System.out.println("顾客 D 购买 3 斤苹果、2 斤草莓、1 斤芒果和 2 斤香蕉的总价: " + totalCostD);
    }
}


