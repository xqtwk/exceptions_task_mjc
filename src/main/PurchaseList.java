package main;

import java.util.Arrays;


public class PurchaseList {
    private final AbstractPurchase[] purchases;

    public PurchaseList(AbstractPurchase[] purchases) {
        this.purchases = purchases;
    }

    public void printArr(){
        for(int i = 0; i < purchases.length; i++) {
            System.out.println(purchases[i]);
        }
    }
    public void printByIndex(int index) {
        System.out.println(purchases[index]);
    }

    public void sort(){
        Arrays.sort(purchases);
    }

    public String getMinimalCost(){
        // new array, so the original doesn't gets sorted
        AbstractPurchase[] array = purchases.clone();
        Arrays.sort(array);
        return "Minimum cost = " + array[array.length-1].getCost().getCents();
    }

    public int search(int value) {
        int[] costs = new int[purchases.length];
        for(int i = 0; i < purchases.length; i++){
            costs[i] = purchases[i].getCost().getCents();
        }
        return Arrays.binarySearch(costs, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PurchaseList) || (obj == null)) {
            return false;
        }

        PurchaseList another = (PurchaseList) obj;

        return  Arrays.equals(this.purchases, another.purchases);
    }

}
