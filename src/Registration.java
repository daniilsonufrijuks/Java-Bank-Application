import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;

static class Registration{      // Registration static class

    static void WriteToAFile(Person personToWriteIn, String accountID, int pin1, int pin2){
        try{
            String pin1Str = String.valueOf(pin1);
            String pin2Str = String.valueOf(pin2);
            FileWriter regWriter = new FileWriter("person.csv");
            regWriter.write(/*id??*/personToWriteIn.GetName(), personToWriteIn.GetLastName(), personToWriteIn.GetPersonCode(), accountID, personToWriteIn.GetEmail(), pin1Str, pin2Str, "0");
            regWriter.close();
        } catch (IOException e) {
            ... // Registration error
        }
        // i made some code
    }

    // try {
    //         File myObj = new File("person.csv");
    //         Scanner myReader = new Scanner(myObj);
    //         int line_id = 1;
    //         while (myReader.hasNextLine()) {
    //             String data = myReader.nextLine();
    //             System.out.println(line_id + " " + data);
    //             line_id++;
    //         }
    //         Scanner myObjremo = new Scanner(System.in);  // Create a Scanner object 3d
    //         System.out.println("Enter line to remove: ");
    //         String userinput_line = String.valueOf(myObjremo.nextLine());
            
    //         String lineToRemove = userinput_line;

    //         File tempFile = new File("person2.csv");
    //         BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

    //         BufferedReader reader = new BufferedReader(new FileReader(fileName));
    //         String currentLine;

    //         while ((currentLine = reader.readLine()) != null) {
    //             if (!currentLine.equals(lineToRemove)) {
    //                 writer.write(currentLine + System.getProperty("line.separator"));
    //             }
    //         }
    //         reader.close();
    //         writer.close();

    //         File oldFile = new File(fileName);
    //         oldFile.delete();
    //         tempFile.renameTo(oldFile);

    //         System.out.println("String " + lineToRemove + " deleted from file " + fileName);

    //     } catch (IOException ex) {
    //         System.out.println("Error " + fileName);
    //         ex.printStackTrace();
    //     }

}
