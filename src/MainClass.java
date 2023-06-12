import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

public class MainClass {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            ArrayList<String> lines = new ArrayList<String>();

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches("\\d+")) { // перевіряємо, чи є рядок цілим числом
                    int number = Integer.parseInt(line);
                    numbers.add(number);
                } else {
                    lines.add(line);
                }
            }
            reader.close();

            // Виведення суми і усіх доданків на консоль
            System.out.println("Сума чисел: " + calculateSum(numbers));
            System.out.println("Доданки: " + numbers);

            // Зміна порядку слів на протилежний у решті рядків
            ArrayList<String> reversedLines = reverseWordsOrder(lines);

            // Запис результуючих рядків у файл
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for (String reversedLine : reversedLines) {
                writer.write(reversedLine);
                writer.newLine();
            }
            writer.close();

            System.out.println("Готово");
        } catch (Exception ex) {
            System.out.println("Помилка: " + ex.getMessage());
        }
    }

    public static int calculateSum(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static ArrayList<String> reverseWordsOrder(ArrayList<String> lines) {
        ArrayList<String> reversedLines = new ArrayList<String>();
        for (String line : lines) {
            String[] words = line.split(" ");
            Collections.reverse(Arrays.asList(words));
            String reversedLine = String.join(" ", words);
            reversedLines.add(reversedLine);
        }
        return reversedLines;
    }
}
