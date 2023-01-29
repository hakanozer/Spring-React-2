package useFile;

import java.util.List;

public class MainFile {
    public static void main(String[] args) {

        DataStore dataStore = new DataStore("note");
        //boolean createStatus = dataStore.createFile();
        //System.out.println("createStatus : " + createStatus);

        //boolean deleteStatus = dataStore.deleteFile();
        //System.out.println("deleteStatus : " + deleteStatus);
        /*
        try {
            int i = 1 / 0;
        }catch (Exception ex) {
            dataStore.addData(ex.getStackTrace()[0].toString());
        }
         */
        /*
        dataStore.addData("new file data");
        List<String> ls = dataStore.readData();
        for ( String item : ls ) {
            System.out.println( item );
        }
         */
        List<String> lsx = dataStore.allReadData();
        System.out.println(lsx);
    }
}
