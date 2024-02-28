import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;

public class CSVManager {

    void show() { // metode lai radīt registretos studentus
         try {
            File myObj = new File("person.csv");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    void delete() throws IOException { // metode lai dzest studentus no faila, ta tad registretos studentus )
        String fileName = "person.csv";
        try {
            File myObj = new File("person.csv");
            Scanner myReader = new Scanner(myObj);
            int line_id = 1;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(line_id + " " + data);
                line_id++;
            }
            Scanner myObjremo = new Scanner(System.in);  // Create a Scanner object 3d
            System.out.println("Enter line to remove: ");
            String userinput_line = String.valueOf(myObjremo.nextLine());
            
            String lineToRemove = userinput_line;

            File tempFile = new File("person2.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.equals(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
            reader.close();
            writer.close();

            File oldFile = new File(fileName);
            oldFile.delete();
            tempFile.renameTo(oldFile);

            System.out.println("String " + lineToRemove + " deleted from file " + fileName);

        } catch (IOException ex) {
            System.out.println("Error " + fileName);
            ex.printStackTrace();
        }
    }

    void update() throws IOException { // metode lai atjaunot jau registreto studentu
        File myObj = new File("person.csv");
        Scanner in = new Scanner(myObj);

        while (in.hasNextLine()) {
            String data = in.nextLine();
            System.out.println(data);
        }
        System.out.println("Enter line which you want to update");
        Scanner myObjupdate = new Scanner(System.in);  // Create a Scanner object
        String userinput = String.valueOf(myObjupdate.nextLine());

        System.out.println("Enter updated line");
        Scanner myObjupdate2 = new Scanner(System.in);  // Create a Scanner object
        String userinput2 = String.valueOf(myObjupdate2.nextLine());


        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("person.csv")))) {
            String strLine;
            while ((strLine = br.readLine()) != null) {
                sb.append(strLine.replace(userinput, userinput2)).append("\r\n");
            }
        }

        try (FileWriter fileWriter = new FileWriter("person.csv")) {
            fileWriter.write(sb.toString());
        }
    }

    String splitter(String str) { // lai faila bus viss skaisti
        return str + ", ";
    }
}