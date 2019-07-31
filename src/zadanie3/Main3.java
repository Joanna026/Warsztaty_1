package zadanie3;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        System.out.println("Pomyśł liczbę od 0 do 1000, a ja ją zgadnę w max. 10 próbach");

        int min=0;
        int max=1000;

        int guess=calculate(min, max);
        System.out.println("Zgaduję: "+guess);


        Scanner scanner=new Scanner(System.in);
        int count=0;

        while(true) {
            System.out.println("Podaj 'd' - za dużo/'m' - za mało/'z' - zgadłeś");
            String answer=scanner.next();
            if (answer.equals("z")) {
                System.out.println("Wygrałem!");
                break;
            } else if (answer.equals("d")) {
                max=guess;
                guess=calculate(min, max);
                System.out.println("Zgaduję: " + guess);
            } else if (answer.equals("m")){
                min=guess;
                guess=calculate(min, max);
                System.out.println("Zgaduję: " + guess);
            } else {
                System.out.println("wybierz odpowiedź z zestawu");
            }
            count++;
            if (count==10)
            {
                break;
            }
        }

    }

    static int calculate(int min, int max){
        return (max-min)/2+min;
    }
}
