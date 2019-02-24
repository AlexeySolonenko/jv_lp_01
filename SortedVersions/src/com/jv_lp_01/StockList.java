package com.jv_lp_01;

import com.sun.jdi.Value;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public StockItem isListed(String item) {
        if (item == null) {
            return null;
        }
        StockItem inStock = list.getOrDefault(item, null);
        if (inStock == null) {
            System.out.println("Sorry, " + item + " is not found in stock");
            return null;
        }
        return list.get(item);
    }

    public int addStock(StockItem item) {
        if (item != null) {
            /* check if already ahve quantities of this item */
            StockItem inStock = list.getOrDefault(item.getName(), item);
            /* if there are already stock on this item, adjust the quantity */
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }
            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = isListed(item);
        if (inStock == null) return -1;

        return inStock.reserve(quantity);
    }

    public int unreserveStock(String item, int quantity) {
        StockItem inStock = isListed(item);
        if (inStock == null) return -1;

        return inStock.unreserve(quantity);
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if (inStock != null && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }

        return Collections.unmodifiableMap(prices);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }


    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s += stockItem + "\t\t\t" + stockItem.quantityInStock() + "/" + stockItem.reserved() + "\t\tValue:";
            s += String.format("%.2f", itemValue) + "\n";

            totalCost += itemValue;
        }

        return s + "Total stock value: \t" + String.format("%.2f", totalCost);
    }
}

