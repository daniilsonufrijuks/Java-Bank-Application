package managers;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public void WriteToAFileTXT(String fileName, int text) {
        try {
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(text + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
