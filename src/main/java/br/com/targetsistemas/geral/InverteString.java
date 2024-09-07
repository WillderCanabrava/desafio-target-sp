package br.com.targetsistemas.geral;

public class InverteString {

    public static void main(String[] args) {

        String frase = "Eu sou o próximo estagiário da Target Sistemas!";
        String fraseInvertida = "";

        for(int i = frase.length()-1; i>=0; i--) {
            fraseInvertida += frase.charAt(i);
        }

        System.out.print("A string invertida de " + frase + " é: " + fraseInvertida );
    }
}
