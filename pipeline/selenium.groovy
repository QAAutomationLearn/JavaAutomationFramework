import hudson.model.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


def setKeyValue(key, value, file_path) {
    Properties prop = new Properties()
    try {
        prop.load(new FileInputStream(file_path))
    }catch (FileNotFoundException e){
        e.printStackTrace()
    }catch (IOException e) {
        e.printStackTrace()
    }
    
    // write into file 
    try {
        prop.setProperty(key, value)
	    FileOutputStream fos = new FileOutputStream(file_path)
        prop.store(fos, null)
        fos.close()
    }catch (FileNotFoundException e){
        e.printStackTrace()
    }catch (IOException e) {
        e.printStackTrace()
    }
}

return this;