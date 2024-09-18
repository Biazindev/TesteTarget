package br.com.tbiazin;

import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe uma string: ");
        String input = sc.nextLine();
        sc.close();

        String invertida = inverterString(input);
        System.out.println("String invertida: " + invertida);
    }

    public static String inverterString(String input) {
        String resultado = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            resultado += input.charAt(i);
        }
        return resultado;
    }
}
