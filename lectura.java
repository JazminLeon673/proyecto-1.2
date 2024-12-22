import java.util.ArrayList;
import java.util.Scanner;

public class lectura {
    public ArrayList<Integer> setNumber() {
        System.out.println("Escribe tres números (del 0 al 9):");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        ArrayList<Integer> lista2 = new ArrayList<>();
        if (number.length() >= 3) {
            int number1 = Character.getNumericValue(number.charAt(0));
            int number2 = Character.getNumericValue(number.charAt(1));
            int number3 = Character.getNumericValue(number.charAt(2));

            lista2.add(number1);
            lista2.add(number2);
            lista2.add(number3);
        }
        return lista2;
    }
}
