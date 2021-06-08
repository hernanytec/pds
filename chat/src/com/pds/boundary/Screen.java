package com.pds.boundary;

import java.util.Scanner;

public class Screen {
    public static  String read() {
        return new Scanner(System.in).nextLine();
    }

    public static void log(String s){
        System.out.println(s);
    }
}
