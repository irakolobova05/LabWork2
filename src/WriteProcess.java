import java.util.Scanner;
import java.io.*;

public class WriteProcess {
    public static void writing(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите название входного файла: ");
        String inputfilename = sc1.nextLine();
        FrequencyCounter counter = new FrequencyCounter();
        try {
            counter.processFile(inputfilename);
        }
        catch (IOException e) {
            System.out.println("Произошла ошибка при обработке входного файла: " + e.getMessage());
            return;
        }
        System.out.println("Введите название файла вывода: ");
        String outputfilename = sc1.nextLine();
        try {
            counter.writeFrequencyToFile(outputfilename);
        }
        catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл: " + e.getMessage());
        }
    }
}
