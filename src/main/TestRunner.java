package main;


import main.exceptions.CsvLineException;

import java.util.Comparator;

public class TestRunner {
    public static void main(String[] args) throws CsvLineException {
        Comparator<Purchase> comparator = Comparator.comparingInt(Purchase::getPurchasedUnits);
        PurchaseList purchaseList = new PurchaseList("D:\\IdeaProjects\\exceptions_task_mjc\\src\\main\\toRead.txt", comparator);
        System.out.println(purchaseList);
        purchaseList.insertPurchase(-1,new Purchase(new Product("big bread", new Euro(6666)), 200));
        System.out.println(purchaseList);
        purchaseList.subList(1, 1);
        System.out.println(purchaseList);
        purchaseList.sort();
        System.out.println(purchaseList);
        purchaseList.subList(1, 1);
        System.out.println(purchaseList);
        System.out.println("Index of purchase with quantity -2 is:" + purchaseList.search(new Purchase(new Product("test", new Euro(1)), -2)));
        System.out.println("Total cost: " + purchaseList.getCost());
    }
}
