package ru.job4j.pojo;

public class ShopDrop {

    public static Product[] delete(Product[] products, int index) {
        Product[] result = new Product[products.length];
        for (int i = 0; i < result.length; i++) {
            if (index <= i) {
                if (i == result.length - 1) {
                    result[i] = null;
                } else {
                    result[i] = products[i + 1];
                }
            } else {
                result[i] = products[i];
            }
        }
        return result;
    }
}