package useFile;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DataStore {

    private final String fileName;
    private final File file;
    private final String folderName = fncDate();
    public DataStore( String fileName ) {
        folderControl(folderName);
        this.fileName = folderName +"/"+ fileName + ".txt";
        file = new File(this.fileName);
    }

    public String fncDate() {
        LocalDateTime time = LocalDateTime.now();
        int year = time.getYear();
        String  month = time.getMonthValue() > 9 ? ""+time.getMonthValue() : "0"+time.getMonthValue();
        int day = time.getDayOfMonth();
        String nowDay = day+"_"+month+"_"+year;
        return nowDay;
    }

    public void folderControl( String folderName ) {
        File file = new File(folderName);
        if ( !file.exists() ) {
            file.mkdir();
        }
    }

    public boolean createFile() {
        try {
             deleteFile();
             return file.createNewFile();
        }catch (Exception ex) {
            System.err.println("createFile Error : " + ex);
        }
        return false;
    }


    public boolean deleteFile()  {
        try {
            if ( file.exists() ) {
                return file.delete();
            }
        }catch (Exception ex) {
            System.err.println("deleteFile Error : " + ex);
        }
        return false;
    }

    public void addData( String data ) {
        try {
            //if ( file.canWrite() ) {
                FileWriter writer = new FileWriter(file, true);
                writer.append(data + System.lineSeparator());
                writer.close();
            //}
        }catch (Exception ex) {
            System.err.println("addData :" + ex);
        }
    }

    public List<String> readData() {
        List<String> ls = new ArrayList<>();
        try {
            if (file.canRead()) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    ls.add( line );
                }
            }
        }catch (Exception ex) {
            System.err.println("readData :" + ex);
        }
        return ls;
    }


    public List<String> allReadData() {
        List<String> ls = new ArrayList<>();
        try {
            File file = new File(folderName);
            File[] files = file.listFiles();
            for( File item : files ) {
                String type = item.getName().substring( item.getName().length() - 4 );
                System.out.println( item );
                if ( type.equals(".txt") ) {
                    Scanner scanner = new Scanner(item);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        ls.add(line);
                    }
                }
            }
        }catch (Exception ex) {
            System.err.println("allReadData Error : " + ex);
        }
        return ls;
    }

}
