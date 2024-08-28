package test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 超市类
 */
class Supermarket {
    //定义map保存水果价格
    private Map<String, BigDecimal> fruitPrices = new HashMap<>();
    //定义map保存水果折扣
    private Map<String, BigDecimal> fruitDiscounts = new HashMap<>();
    //是否开启满100-10标志
    private boolean fullDiscountEnabled = false;

    //设置水果价格
    public void setFruitPrice(String fruitName, BigDecimal pricePerPound) {
        fruitPrices.put(fruitName, pricePerPound);
    }
    //删除水果
    public void removeFruitPrice(String fruitName) {
        fruitPrices.remove(fruitName);
    }
    //设置折扣
    public void setFruitDiscount(String fruitName, BigDecimal discountRate) {
        fruitDiscounts.put(fruitName, discountRate);
    }
    //删除折扣
    public void removeFruitDiscount(String fruitName) {
        fruitDiscounts.remove(fruitName);
    }
    //设置满减开关
    public void enableFullDiscount(boolean enabled) {
        fullDiscountEnabled = enabled;
    }
    //计算价格方法
    public BigDecimal calculateTotalCost(Fruit... fruits) {
        BigDecimal totalCost = BigDecimal.ZERO;
        for (Fruit fruit : fruits) {
            //获取水果单价
            BigDecimal pricePerPound = fruitPrices.get(fruit.getName());
            if (pricePerPound != null) {
                BigDecimal fruitCost = pricePerPound.multiply(fruit.getWeight());
                BigDecimal discountRate = fruitDiscounts.get(fruit.getName());
                if (discountRate != null) {
                    fruitCost = fruitCost.multiply(discountRate);
                }
                totalCost = fruitCost.add(fruitCost);
            }
        }
        //满减100-10
        if (fullDiscountEnabled) {
            BigDecimal discountUnits = totalCost.divideToIntegralValue(BigDecimal.valueOf(100));
            totalCost = totalCost.subtract(discountUnits.multiply(BigDecimal.valueOf(10)));
        }

        return totalCost;
    }
}
