import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class journalApp {
    public static void main(String[] args) {
        String myPAth = "/Users/williammejia/Documents/journal-java-app/src/data/journal-entries.txt";
        String fileName = "journal-entries.txt";
        String directory = "data";
        Path filePath = Paths.get(directory, fileName);

        Path journalPath = Paths.get("data", "journal-entries.txt");
        Path journalDirPath = Paths.get("data");

        Scanner scan = new Scanner(System.in);

        while(true){
        System.out.println("Journal Application");
        System.out.println("1- Read journal");
        System.out.println("2- Write an entry");

            int journalOption = scan.nextInt();
            if(journalOption == 1){
                filesManager.readFiles(journalPath, journalDirPath, fileName);
            }else if( journalOption == 2){
                filesManager.writeFiles(journalPath, journalDirPath,filePath, fileName);
            }
        }

    }
}
