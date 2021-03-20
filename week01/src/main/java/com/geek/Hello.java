package com.geek;

/**
 * <br/>
 * User: eugene <br/>
 * Date&Time: 2021/3/20 21:24
 */
public class Hello {

    public static void main(String[] args) {
        Hello hello = new Hello();
    }

    public static void oprationWithTen(int number) {
        if (number > 10) {
            System.out.println("(number / 10) = " + (number / 10));
            return;
        }
        if (number > 20) {
            System.out.println("(number - 20) = " + (number - 20));
            return;
        }
        if (number == 1) {
            System.out.println("number = " + number);
            return;
        }
        if (number <= 0) {
            System.out.println("number = " + number);
            return;
        }
        for (int i = 0; i < number; i++) {
            System.out.println("i = " + i);
        }
    }
}
