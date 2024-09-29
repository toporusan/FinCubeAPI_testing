package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!");
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            System.out.println("i = " + i);
        }

        List myList = new ArrayList();
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        System.out.printf("myList = %s\n", myList);


    }
}