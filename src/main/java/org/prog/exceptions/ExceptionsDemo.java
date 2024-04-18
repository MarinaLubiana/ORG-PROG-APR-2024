package org.prog.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

    public static void main(String[] args) {
        System.out.println("this is before exception");
        smth1();
        System.out.println("this is after exception");
    }

    private static void smth1(){
        smth2();
    }
    private static void smth2(){
        try {
            smth3();
        } catch (Exception e){
            System.out.println("Ooops!");
            throw new RuntimeException();//TODO: Home Work tip
        }
    }
    private static void smth3() {
        smth4();
    }
    private static void smth4() {
        String s = null;
        System.out.println(s.equals("a"));
        checkedException();
    }

    private static void checkedException() {
        try {
            FileReader fileReader = new FileReader("C:\\users.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
