package org.example;

import java.util.Scanner;

public class Selection {
    private Scanner scanner;

    public Selection() {
        this.scanner = new Scanner(System.in);
    }

    int num1 = 0;

    public int getNum1() {
        int num1 = 0;
        while (true) {
            System.out.println("Выбери 1 или 2");
            String input = scanner.nextLine().trim();
            if (input.equals("1")) {
                num1 = 1;
                break;
            } else if (input.equals("2")) {
                num1 = 2;
                break;
            } else {
                System.out.println("Введите 1 или 2 без проелов.");
            }
        }
        if (num1 == 2) {
            System.exit(0);
        }
        return num1;
    }
}