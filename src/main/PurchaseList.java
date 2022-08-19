package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class PurchaseList {
    private final ArrayList<Purchase> purchases;
    private final Comparator<Purchase> comparator;

    public PurchaseList(ArrayList<Purchase> purchases, Comparator<Purchase> comparator) {
        this.purchases = purchases;
        this.comparator = comparator;
    }

    public PurchaseList(Comparator<Purchase> comparator) {
        this.purchases = new ArrayList<>(0);
        this.comparator = comparator;
    }

    public void insertPurchase(int index, Purchase purchase){
        try {
            this.purchases.add(index, purchase);
        } catch (IndexOutOfBoundsException e){
            this.purchases.add(purchase);
        }
    }

    public void sort(){
        Collections.sort(purchases);
    }

    public String getCost(){
        Euro cost = new Euro(0);
        for (Purchase purchase: this.purchases){
            cost = cost.add(purchase.getCost());
        }
        return cost.toString();
    }

    public int search(Purchase purchase) {
        return Collections.binarySearch(this.purchases, purchase, this.comparator);
    }
    @Override
    public String toString() {
        String string = "";
        for (Purchase purchase: this.purchases){
            string += purchase.toString() + "\n";
        }
        return string;
    }

}
