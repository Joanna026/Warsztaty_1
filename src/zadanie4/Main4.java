package zadanie4;

import java.util.Random;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj kod kostki: ");
        String type = scanner.nextLine();
        System.out.println(dice(type));
    }

    static int dice(String type) {
        int i = 0;
        int[] tempTab = number(type, i);
        i = tempTab[1];
        int repeat = tempTab[0];

        i++;
        tempTab = number(type, i);
        i = tempTab[1];
        int limit = tempTab[0];

        char modifySign = '+';
        int modifyValue = 0;
        if (i != type.length() - 1) {
            modifySign = type.charAt(i++);
            tempTab = number(type, i);
            modifyValue = tempTab[0];
        }

        return roll(repeat, limit, modifySign, modifyValue);
    }

    static int[] number(String type, int index) {
        StringBuilder strB = new StringBuilder();
        int[] result = new int[2];

        if (!Character.isDigit(type.charAt(index))) {

            result[0] = 1;
        } else {
            while (Character.isDigit(type.charAt(index))) {
                char c = type.charAt(index);
                strB.append(Character.toString(c));
                if (index == type.length() - 1) {
                    break;
                } else {
                    index++;
                }
            }
            result[0] = Integer.parseInt(strB.toString());
        }
        result[1] = index;

        return result;
    }

    static int roll(int repeat, int limit, char modifySign, int modifyValue) {
        Random r = new Random();
        int score = 0;

        if (modifySign == '-') {
            modifyValue *= -1;
        }

        for (int j = 0; j < repeat; j++) {
            score += (r.nextInt(limit) + 1 + modifyValue);
        }

        return score;
    }
}
