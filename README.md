Exceptions task MJC school
```
Define the class PurchaseList  that represents a  list  of  objects of two types (see the previous task): 
– the immutable superclass Purchase for a product purchase (without discount or extra charge),
– the immutable subclass PriceDiscountPurchase for a purchase with a price discount.
The file of csv format represents a series of text lines. Every line contains a set of values separated by a semicolon and corresponds to a single object of a superclass or a subclass depending on the number of values in the line. Lines with incorrect content must be skipped. 
Constructor: 
– constructor with the parameter – csv–filename, loading elements into a list from a csv–file. Create an empty list if the FileNotFoundException is caught. Output wrong lines into System.err stream. 
The necessary class field is a list itself. Also other fields may be included into this class and added in the parameterized constructor. 
Implement following operations with the list:
– inserting a purchase into the list at the index position. If the index value is wrong then the object has to be inserted at the nearest end of the list;
– deleting a subsequence of elements from the index from to the index to (>= from and < to). Correct the index(es) judiciously if any of them are wrong;
– calculating the total cost of all purchases;
– string representation of the list in csv-format;
– sorting the list by an internal criterion with the method Collections.sort( ). It is forbidden to change a sorting criterion during the app lifecycle;  
– searching an element in the list by the same criterion with the method Collections.binarySearch( ).
Define the TestRunner class and test the class PurchaseList functionality. 

The example of the file in.csv:


bread;155;1;2
candy;0;2
candy;-100;-2
candy;100;2;0
milk;131;2
bread;154;3
candy
;100;2
beer;;1
candy;100;2;500
candy;100;2;100
water;15;4;0.1;cold
water;70;5;-1
bread;145;5
;;
potato;180;2;10
butter;370;1
water;ok;4
water;70;4;0.5
water;70.5;1
butter;341;1;1
meat;1100;2;80

Remarks and restrictions 
 
– When reading the formulation, the task may seem to be about working with a dynamic array. However, the main goal is to gain skills in processing incorrect input data.

– Information classes of purchases created in the previous task can and should be updated.

– The int range is guaranteed to be sufficient to calculate the cost of both a single purchase and the total cost of all purchases.

– Unit testing is subject to:
– factory method of the PurchaseFactory class;
– constructor and methods of the PurchaseList class.
You can use the result of the toString() method to compare two PurchaseList instances. A similar remark is true for instances of purchase classes, since the criterion of equality of purchases is not specified by the task formulation.

```