package main;


import java.io.FileNotFoundException;
import java.util.Comparator;

public class TestRunner {
    public static void main(String[] args) throws FileNotFoundException {
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
        /*PurchaseArray products = new PurchaseArray(new AbstractPurchase[]{
            new EveryUnitDiscountedPurchase(new Product("apple", new Euro(500)),50, new Euro(40)),
            new GreaterThanConstantDiscountedPurchase(new Product("pineapple", new Euro(997)),50, 8.75),
            new AdditionForTransportExpensesPurchase(new Product("carrot", new Euro(666)),50, new Euro(12)),
            new EveryUnitDiscountedPurchase(new Product("pear", new Euro(1482)),10, new Euro(2)),
            new GreaterThanConstantDiscountedPurchase(new Product("ice cream", new Euro(1111)),12, 9.39),
            new AdditionForTransportExpensesPurchase(new Product("meat", new Euro(111155)),3, new Euro(1))

        });

        // PURCHASE;NAME;UNIT_PRICE;AMOUNT;DISCOUNT||FEE;TOTAL COST
        products.printArr();
        System.out.println();
        products.sort();
        products.printArr();
        System.out.println(products.getMinimalCost());
        int cost = 33300;
        int index = products.search(cost);
        if (index < 0) {
            System.out.println("Purchase not found");
        } else {
            products.printByIndex(index);
        }*/
    }
}
