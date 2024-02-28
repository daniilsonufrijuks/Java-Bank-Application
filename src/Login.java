import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Login {
    void login() {
        // Product product = new Product();


        // String str = ((Integer.toString(product.setid(myObj.nextInt()))) + "," + product.setname(myObj.nextLine()));
        // String str2 = ((Double.toString(product.setprice(myObj.nextDouble()))) + "," + product.setcategory(myObj.nextLine()));

        Person person = new Person();
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
}