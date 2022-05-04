import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class filesManager {
    public static void readFiles(Path journalPath, Path journalDirPath, String fileName){
        try{
            if(Files.notExists(journalPath)) Files.createDirectories(journalDirPath);
            if(Files.notExists(journalPath)) Files.createFile(journalPath);
            List<String> entries = Files.readAllLines(journalPath);
            for(int i = 0; i < entries.size(); i++){
                System.out.println(entries.get(i));
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Cannot read files - " + fileName);
        }
    }

    public static void writeFiles(Path journalPath, Path journalDirPath, Path filePath, String fileName){
        Scanner write = new Scanner(System.in);
        try{
            if(Files.notExists(journalPath)) Files.createDirectories(journalDirPath);
            if(Files.notExists(journalPath)) Files.createFile(journalPath);
            System.out.println("Enter Date: [MM-DD-YYYY]");
            String date = write.nextLine();
            System.out.println("Entry:");
            String journalEntry = write.nextLine();
            List<String> entries = Arrays.asList(date + "\n" + journalEntry + "\n" + "-------------");
            Files.write(filePath, entries, StandardOpenOption.APPEND);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
