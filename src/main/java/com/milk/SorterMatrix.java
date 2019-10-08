package com.milk;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SorterMatrix {
 List<Milk> milk;
 int compCount;
 int swapCount;
 long time;

  public void SelectionByFatDesc() {
      long startTime = System.nanoTime();
      compCount = 0;
      swapCount = 0 ;
      if (milk.size()>0){
       for (int i=0;i<milk.size();i++){
         int max = i;
          for (int j = i + 1 ; j < milk.size(); j++){
            compCount++;
             if (milk.get(max).getFat()<milk.get(j).getFat()){
                max = j;
             }
            }
        Collections.swap(milk,i,max);
        swapCount++;
       }
      }
     long stopTime = System.nanoTime();
     time = stopTime - startTime;
    }

     public  void MergeByCaloriesAsc(){
         long startTime = System.nanoTime();
         compCount = 0;
         swapCount = 0;
         mergeSort(milk,milk.size());
         long stopTime = System.nanoTime();
         time = stopTime - startTime;
     }

     private  void mergeSort(List<Milk> milk,int n){
         if (n < 2) {
             return;
         }
         int mid = n / 2;
         List<Milk> l = new ArrayList<>();
         List<Milk> r = new ArrayList<>();
         for (int i = 0; i < mid; i++) {
                l.add(milk.get(i));
         }
         for (int i = mid; i < n; i++) {
             r.add(milk.get(i));
            }
         mergeSort(l, mid);
         mergeSort(r, n - mid);
         merge(milk, l, r, mid, n - mid);
     }

     private  void merge(List<Milk> a,List<Milk> l,List<Milk> r,int left,int right){
         int i = 0, j = 0, k = 0;
         while (i < left && j < right) {
             compCount++;
             swapCount++;
             if (l.get(i).getCalories() <= r.get(j).getCalories()) {
                 a.set(k++,l.get(i++));
             }
             else {
                 a.set(k++,r.get(j++));
           }
         }
         while (i < left) {
             a.set(k++, l.get(i++));
         }
         while (j < right) {
             a.set(k++,r.get(j++));
         }
     }

    public SorterMatrix() {
    }

    public void readFile(String fileName){
        milk = new ArrayList<Milk>();
        File file = new File(fileName);
        BufferedReader br;
        String st;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((st = br.readLine()) != null){
            String[] arr=  st.split(",");
            String manufacturer = arr[0];
            float fat = Float.parseFloat(arr[1]);
            int volume = Integer.parseInt(arr[2]);;
            int calories = Integer.parseInt(arr[3]);;
            milk.add(new Milk(manufacturer,fat,volume,calories));
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 public  void print(){
    milk.stream().forEach(System.out::println);
 }

 public  void Run(String file) {
	readFile(file);
	System.out.println("Before sort: ");
	System.out.println("--------------------------------------------");
	print();
	System.out.println("--------------------------------------------");
	System.out.println("Selection sort by fat desc:");
	System.out.println("--------------------------------------------");
	SelectionByFatDesc();
	print();
	System.out.println(String.format("Runtime: %d ns,операцій порівяння: %d,операцій обміну: %d",time,compCount,swapCount));
	System.out.println("--------------------------------------------");
	System.out.println("Merge sort by calories asc:");
	System.out.println("--------------------------------------------");
	MergeByCaloriesAsc();
	print();
	System.out.println(String.format("Runtime: %d ns,операцій порівяння: %d,операцій обміну: %d",time,compCount,swapCount));
 }
}
