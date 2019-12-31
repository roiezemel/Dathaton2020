package tools;

import java.util.Scanner;

public class ConsoleUI extends Converter{

    // Members:
    private static Scanner input = new Scanner(System.in);

    public static void print(String value){
        System.out.print(value);
    }

    public static void print(int value) {
        System.out.print(value);
    }

    public static void print(double value){
        System.out.print(value);
    }

    public static void print(float value){
        System.out.print(value);
    }

    public static void print(boolean value){
        System.out.print(value);
    }

    public static void print(char value){
        System.out.print(value);
    }

    public static void print(String[] value){
        System.out.print(value);
    }

    public static void print(int[] value) {
        System.out.print(value);
    }

    public static void print(double[] value){
        System.out.print(value);
    }

    public static void print(float[] value){
        System.out.print(value);
    }

    public static void print(boolean[] value){
        System.out.print(value);
    }

    public static void print(char[] value){
        System.out.print(value);
    }

    public static void print(Object value){
        System.out.print(value);
    }

    public static void print(Object[] value){
        System.out.print(value);
    }

    public static void println(String value){
        System.out.println(value);
    }

    public static void println(int value) {
        System.out.println(value);
    }

    public static void println(double value){
        System.out.println(value);
    }

    public static void println(float value){
        System.out.print(value);
    }

    public static void println(boolean value){
        System.out.println(value);
    }

    public static void println(char value){
        System.out.println(value);
    }

    public static void println(String[] value){
        System.out.println(value);
    }

    public static void println(int[] value) {
        System.out.println(value);
    }

    public static void println(double[] value){
        System.out.println(value);
    }

    public static void println(float[] value){
        System.out.println(value);
    }

    public static void println(boolean[] value){
        System.out.println(value);
    }

    public static void println(char[] value){
        System.out.println(value);
    }

    public static void println(Object value){
        System.out.println(value);
    }

    public static void println(Object[] value){
        System.out.println(value);
    }

    public static String input(){
        return input.nextLine();
    }

    public static String input(String text){
        println(text);
        return input.nextLine();
    }
}
