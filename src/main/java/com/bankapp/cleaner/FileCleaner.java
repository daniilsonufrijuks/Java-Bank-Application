package cleaner;

import java.io.FileWriter;
import java.io.IOException;

public class FileCleaner {
    public static void CleanFile(String path) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
