package Arrays;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        int[] numeros = new int[10];
        System.out.println("Introduce 10 números:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("\nArray original:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(i + " - " + numeros[i]);
        }

        int[] reorganizado = reorganizarPrimos(numeros);

        System.out.println("\nArray con números primos al principio:");
        for (int i = 0; i < reorganizado.length; i++) {
            System.out.println(i + " - " + reorganizado[i]);
        }

        scanner.close();
    }

    public static int[] reorganizarPrimos(int[] numeros) {
        ArrayList<Integer> primos = new ArrayList<>();
        ArrayList<Integer> noPrimos = new ArrayList<>();

        for (int numero : numeros) {
            if (esPrimo(numero)) {
                primos.add(numero);
            } else {
                noPrimos.add(numero);
            }
        }

        int[] resultado = new int[numeros.length];
        int index = 0;

        for (int primo : primos) {
            resultado[index++] = primo;
        }

        for (int noPrimo : noPrimos) {
            resultado[index++] = noPrimo;
        }

        return resultado;
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
