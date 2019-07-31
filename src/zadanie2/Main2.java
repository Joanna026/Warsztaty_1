package zadanie2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        int size = 6;
        System.out.println("Podaj 6 liczb:");
        int[] guess = new int[size];
        int x = 0;
        boolean exists = false;
        guess[0] = loading();
        for (int i = 1; i < size; i++) {
            do {
                exists = false;
                x = loading();
                for (int j = 0; j < i; j++) {
                    if (x == guess[j]) {
                        exists = true;
                        System.out.println("Liczba zostałą już podana wcześniej");
                    }
                }
            } while (exists);
            guess[i] = x;
        }

        Arrays.sort(guess);
        System.out.println(Arrays.toString(guess));

        int[] rand=rand();

        int result=equals(guess,rand);
        if (result>=3){
            System.out.println("Trafiłeś "+result);
        } else {
            System.out.println("Nie trafiłeś");
        }

    }

    static int loading() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Podaj liczbę");
        }
        number = scanner.nextInt();

        return number;
    }

    static int[] rand(){

        int[] readyRand=new int[6];
        Integer[] rand = new Integer[49];
        for (int i = 0; i < rand.length; i++) {
            rand[i] = i + 1;
        }
        Collections.shuffle(Arrays.asList(rand));

        for(int i=0; i<6;i++){
            readyRand[i]=rand[i];
        }
        System.out.println(Arrays.toString(readyRand));
        return readyRand;
    }


    static int equals(int[] guess, int[] rand){
        int result=0;

        for(int i =0;i<6; i++){
            for(int j=0;j<6;j++){
                if (guess[i]==rand[j]){
                    result++;
                }
            }
        }
        return result;

    }

}

