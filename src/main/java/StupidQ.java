import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StupidQ {

    String filepath = "src/main/resources/counter.txt";
    File file = new File(filepath);
    FileReader fr;
    FileWriter fw;
    int counter;

    public void increment() {
        counter = getAmount();
        counter++;
        System.out.println("Incrementing stupid counter, new amount is " + counter);

        try {
            fw = new FileWriter(file,false);
            fw.write(String.valueOf(counter));
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getAmount() {
        String line;
        int value;
        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();

            if (line != null) {
                value = Integer.parseInt(line);
                return value;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
