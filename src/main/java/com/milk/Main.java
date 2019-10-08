package com.milk;

public class Main {
    public static void main(String[] arg){
        if (arg.length>0){
        SorterMatrix sorter = new SorterMatrix();
        sorter.Run(arg[0]);
        }
    }
}
