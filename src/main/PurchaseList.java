package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class PurchaseList {
    private final ArrayList<Purchase> purchases;
    private final Comparator<Purchase> comparator;

    public PurchaseList(String path, Comparator<Purchase> comparator) throws FileNotFoundException {
        this(new File(path), comparator);
    }

    public PurchaseList(Comparator<Purchase> comparator) throws FileNotFoundException {
        this("", comparator);
    }

    public PurchaseList(File fileName, Comparator<Purchase> comparator) throws FileNotFoundException {
        this.purchases = new ArrayList<>(0);
        this.comparator = comparator;
        try (Scanner scanner = new Scanner(new FileReader(fileName))){
            while(scanner.hasNextLine()){
                Purchase purchase = PurchasesFactory.createPurchase(scanner.nextLine());
                purchases.add(purchase);
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Error, file not found");
        }
    }

    public void subList(int from, int to) throws IllegalArgumentException{
        if (from < 0 ) {
            from = 0;
        } else if (from == to) {
            to = from+1;
        }else if (from > to) {
            throw new IllegalArgumentException();
        } else if (to >= this.purchases.size()) {
            to = this.purchases.size();
        }
        purchases.subList(from, to).clear();
    }

    public void insertPurchase(int index, Purchase purchase){
        try {
            if (index < 0 ) {
                index = 0;
            } else if (index >= purchases.size()) {
                index = purchases.size() - 1;
            }
            purchases.add(index, purchase);
        } catch (IndexOutOfBoundsException e){
            purchases.add(purchase);
        }
    }

    public void sort(){
        purchases.sort(comparator);
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
