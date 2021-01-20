import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Quote {
    String filepath = "src/main/resources/quotes.txt";
    File file = new File(filepath);
    FileReader fr;
    FileWriter fw;

    public void append(String input) {
        System.out.println("append input is " + input );
        try {
            fw = new FileWriter(file, true);
            fw.append(input + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String randomQuote() {
        return null;
    }
}
