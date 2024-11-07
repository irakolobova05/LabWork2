import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class FrequencyCounter {
    private Map<Character, Integer> symb = new HashMap<>();
    public void processFile(String inputfilename) throws IOException{
        File inputfile = new File(inputfilename);
        if (!inputfile.exists()) {
            throw new FileNotFoundException("Файл " + inputfilename + " не найден.");
        }
        try (BufferedReader br1 = new BufferedReader(new FileReader(inputfile))) {
            String line;
            while ((line = br1.readLine()) != null) {
                String l = line.toLowerCase();
                for (int i = 0; i < l.length(); i++) {
                    char s = l.charAt(i);
                    if (Character.isLetter(s)) {
                        symb.put(s, symb.getOrDefault(s, 0) + 1);
                    }
                }
            }
        }
        catch (FileNotFoundException ex1) {
            throw new IOException("Ошибка при чтении файла " + inputfilename, ex1);

        }
    }
    public void writeFrequencyToFile(String outputfilename) throws IOException{
        File outputfile = new File(outputfilename);
        if (!outputfile.exists()) {
            System.out.println("Файл " + outputfilename + " не найден.");
            return;
        }
        try (BufferedWriter br2 = new BufferedWriter(new FileWriter(outputfile))) {
            for (Map.Entry<Character, Integer> entry : symb.entrySet()) {
                br2.write(entry.getKey() + " - " + entry.getValue());
                br2.newLine();
            }
        }
        catch (FileNotFoundException ex2) {
            throw new IOException("Ошибка при записи в файл " + outputfilename, ex2);
        }
    }
}
