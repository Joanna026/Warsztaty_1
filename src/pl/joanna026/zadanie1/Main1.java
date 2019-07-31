package pl.joanna026.zadanie1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Random r=new Random();
        int number=r.nextInt(101);

        System.out.println("Podaj liczbę od 0 do 100: ");

        int guess=loading();

        while (guess!=number) {
            if (guess < number) {
                System.out.println("Za mało");
            } else {
                System.out.println("Za dużo");
            }
            guess=loading();
        }

        System.out.println("Gratulacje");

    }

    static int loading(){
        Scanner scanner=new Scanner(System.in);
        int number=0;

        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Podaj liczbę");
        }
        number=scanner.nextInt();
        return number;
    }
}
