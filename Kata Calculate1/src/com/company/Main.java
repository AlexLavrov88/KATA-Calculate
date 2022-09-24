package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[] rimInt = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        System.out.println(calc(in));
        scanner.close();
    }

    public static String calc(String input) throws IOException {
        int result = 0;
        String[] line = input.split(" ");
        for (int i = 0; i < line.length; i++) {
            line[i] = line[i].trim();
        }
        if (line.length != 3) {
            throw new IOException("Неверный ввод. Количество символов больше заданного!");
        }
        if (Arrays.asList(rimInt).contains(line[0]) && Arrays.asList(rimInt).contains(line[2])) {
            int a = 0;
            int b = 0;
            for (int i = 0; i < rimInt.length; i++) {
                if (line[0].equals(rimInt[i])) {
                    a = i + 1;
                }
                if (line[2].equals(rimInt[i])) {
                    b = i + 1;
                }
            }
            switch (line[1]) {
                case "*":
                    result = a * b;
                    break;
                case "+":
                    result = a + b;
                    break;
                case "/":
                    result = a / b;
                    break;
                case "-":
                    result = a - b;
                    break;
            }
            return toRim(result);
        }
        int a = 0;
        try {
            a = Integer.parseInt(line[0]);
        } catch (NumberFormatException e) {
            System.out.println("Упс что-то пошло не так!");
        }
        int b = Integer.parseInt(line[2]);
        if (a <= 10 && b <= 10 && a >= 0) {
            switch (line[1]) {
                case "*":
                    result = a * b;
                    break;
                case "+":
                    result = a + b;
                    break;
                case "/":
                    result = a / b;
                    break;
                case "-":
                    result = a - b;
                    break;
            }
        } else {
            throw new IOException();
        }
        return String.valueOf(result);
    }

    public static String toRim(int arabic) throws IOException {
        String resultToRim = "";
        if (arabic == 100) {
            resultToRim = "C";
        } else if (90 < arabic && arabic < 100) {
            resultToRim = "XC" + rimInt[(arabic % 10) - 1];
        } else if (90 == arabic) {
            resultToRim = "X";
        } else if (80 < arabic && arabic < 90) {
            resultToRim = "LXXX" + rimInt[(arabic % 10) - 1];
        } else if (80 == arabic) {
            resultToRim = "LXXX";
        } else if (70 < arabic && arabic < 80) {
            resultToRim = "LXX" + rimInt[(arabic % 10) - 1];
        } else if (70 == arabic) {
            resultToRim = "LXX";
        } else if (60 < arabic && arabic < 70) {
            resultToRim = "LX" + rimInt[(arabic % 10) - 1];
        } else if (60 == arabic) {
            resultToRim = "LX";
        } else if (50 < arabic && arabic < 60) {
            resultToRim = "L" + rimInt[(arabic % 10) - 1];
        } else if (50 == arabic) {
            resultToRim = "L";
        } else if (40 < arabic && arabic < 50) {
            resultToRim = "XL" + rimInt[(arabic % 10) - 1];
        } else if (40 == arabic) {
            resultToRim = "XXXL";
        } else if (30 < arabic && arabic < 40) {
            resultToRim = "XXX" + rimInt[(arabic % 10) - 1];
        } else if (30 == arabic) {
            resultToRim = "XXX";
        } else if (20 < arabic && arabic < 30) {
            resultToRim = "XX" + rimInt[(arabic % 10) - 1];
        } else if (20 == arabic) {
            resultToRim = "XX";
        } else if (10 < arabic && arabic < 20) {
            resultToRim = "X" + rimInt[(arabic % 10) - 1];
        } else if (10 == arabic) {
            resultToRim = "X";
        } else if (0 <= arabic && arabic < 10) {
            resultToRim = rimInt[(arabic - 1)];
        } else {
            throw new IOException("Результат выходит за  установленное ограничение");
        }
        return resultToRim;
    }
}