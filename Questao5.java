import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe uma string: ");
        String str = scanner.nextLine();
        scanner.close();

        String invertida = inverter(str);
        System.out.println("String invertida: " + invertida);
    }

    public static String inverter(String str) {
        char[] array = str.toCharArray();
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        return new String(array);
    }
}
