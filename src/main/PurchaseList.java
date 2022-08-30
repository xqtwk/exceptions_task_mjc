package main;

import main.exceptions.CsvLineException;
import main.exceptions.NoArgumentException;
import main.exceptions.OutOfBoundArgumentException;

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

    public PurchaseList(String path, Comparator<Purchase> comparator) throws CsvLineException {
        this(new File(path), comparator);
    }

    public PurchaseList(Comparator<Purchase> comparator) throws CsvLineException {
        this("", comparator);
    }

    public PurchaseList(File fileName, Comparator<Purchase> comparator) throws CsvLineException {
        this.purchases = new ArrayList<>(0);
        this.comparator = comparator;
        try (Scanner scanner = new Scanner(new FileReader(fileName))){
            while(scanner.hasNextLine()){
                Purchase purchase = PurchasesFactory.createPurchase(scanner.nextLine());
                purchases.add(purchase);
            }
            if (purchases.size() == 0) {
                throw new NoArgumentException("File is empty");
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            throw new CsvLineException("file not found", e);
        } catch (CsvLineException e) {
            System.err.println(e);
        }
    }

    public void subList(int from, int to) throws IllegalArgumentException{
        if (from < 0 ) {
            from = 0;
        } else if (from == to) {
            to = from+1;
        }else if (from > to) {
            throw new OutOfBoundArgumentException();
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
