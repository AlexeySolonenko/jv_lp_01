package com.jv_lp_01;

import java.util.Collections;
//import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    private final String name;
    private final Map<StockItem, Integer> list;
    private StockList stockList;

    public Basket(String name) {
        this.name = name;
        list = new TreeMap<>();
    }

    public Basket(String name, StockList stockList) {
        this(name);
        this.stockList = stockList;

    }

    public int addToBasket(StockItem item, int quantity) {
        if(stockList == null) return -1;
        /* prepare quantity to add */
        if ((item == null) || (quantity <= 0)) {
            return -1;
        }

        int inBasket = list.getOrDefault(item, 0);
        if (stockList.reserveStock(item.getName(), quantity) < 0) {
            return -1;
        }
        /* if reserved successfully */
        list.put(item, inBasket + quantity);
        return inBasket;
    }

    public void checkout(){
        System.out.println(name+" basket before checkout");
        System.out.println(this.toString());
        /* step 1 verify all quantities are still OK */
        for(Map.Entry<StockItem, Integer> e: list.entrySet()){
            StockItem item = e.getKey();
            int quantity = e.getValue();
            if(stockList.isListed(item.getName()) == null){
                System.out.println("Error in the basket: " + item.getName() + " not found in stock");
                return;
            }
            if(stockList.get(item.getName()).quantityInStock() < quantity){
                System.out.println("Error in the basket:  " + quantity +" reserved in basket" + item.quantityInStock() + ", available in stock only: "+ stockList.get(item.getName()).quantityInStock());
                return;
            }

            if(stockList.get(item.getName()).reserved() < quantity){
                System.out.println("Error in the basket:  " + item.getName() +" reserved in basket" + quantity + ", reserved in stock only: "+ stockList.get(item.getName()).reserved());
                return;
            }
        }
        /* step 2 if all items and quanitites are OK, start actual checkout */
        System.out.println("Basket verification OK, proceeding to checkout");
        for(Map.Entry<StockItem, Integer> e: list.entrySet()) {
            StockItem item = e.getKey();
            int quantity = e.getValue();
            stockList.unreserveStock(item.getName(),quantity);
            stockList.sellStock(item.getName(),quantity);
            list.remove(item);
        }
        list.clear();
        System.out.println(name+" basket after checkout");
        System.out.println(this.toString());


    }

    public int removeFromBasket(StockItem item, int quantity) {
        if(stockList == null) return -1;
        /* prepare quantity to remove */
        if ((item == null) && (quantity <= 0)) {
            return -1;
        }
        quantity = Math.abs(quantity);
        int inBasket = list.getOrDefault(item, 0);
        if (quantity > inBasket) {
            System.out.println("Cannot unreserve more than was reserved");
            return -1;
        }
        if (stockList.unreserveStock(item.getName(), quantity) < 0) {
            return -1;
        }
        /* if unreserve successfull */
        list.put(item, list.get(item) - quantity);

        return quantity;

    }


    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + ((list.size() == 1) ? "item" : " itemms:") + "\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s += item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s + "Total cost: " + totalCost;
    }

    public StockList getStockList() {
        return stockList;
    }

    public void setStockList(StockList stockList) {
        this.stockList = stockList;
    }
}
