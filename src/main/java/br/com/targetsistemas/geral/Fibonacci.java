package br.com.targetsistemas.geral;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();

        int a = 1, b = 0, ref;
        for (int i = 0; i < numero; i++) {
            System.out.println(a);
            ref = a;
            a = a + b;
            b = ref;
        }

        if (pertenceFibonacci(numero)) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }
    }


    public static boolean pertenceFibonacci (int num){
        if (num < 0) {
            return false;
        }

        int a = 0, b = 1;
        if (num == a || num == b) {
            return true;
        }

        while (b <= num) {
            int ref = a + b;
            a = b;
            b = ref;

            if (b == num) {
                return true;
            }
        }

        return false;
    }
}
