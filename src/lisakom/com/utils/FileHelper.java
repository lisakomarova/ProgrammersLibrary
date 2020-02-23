package lisakom.com.utils;

import lombok.extern.java.Log;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {
        public static <T> ArrayList<T> readFile(File file) throws InvalidObjectException{
            ArrayList<T> objectsList = new ArrayList<>();
            try{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream istream = new ObjectInputStream(fis);

                objectsList = (ArrayList<T>) istream.readObject();
                return objectsList;
            }
            catch ( IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            throw new InvalidObjectException
                ("Object is not deserialized");
        }

        public static <T> boolean writeToFile (ArrayList<T> objects, File file){
            try (FileOutputStream fos = new FileOutputStream(file)) {
                if (fos != null) {
                    ObjectOutputStream ostream =  new ObjectOutputStream(fos);
                    ostream.writeObject(objects);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        return true;
    }
}
