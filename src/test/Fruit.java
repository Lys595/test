package test;

import java.math.BigDecimal;

/**
 * 水果类
 */
class Fruit {
    private String name;
    private BigDecimal weight;

    public Fruit(String name, BigDecimal  weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public BigDecimal  getWeight() {
        return weight;
    }
}
