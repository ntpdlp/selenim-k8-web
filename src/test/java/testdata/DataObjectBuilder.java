package testdata;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static<T> T buildDataObjectFrom(String fileLocation, Class<T> dataModelClass){
        //trong du an thuong dua : relativePathFile
        T data = null;
        String absoluteFileLocation = System.getProperty("user.dir").concat(fileLocation);
        try(
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFileLocation));
                ){
            Gson gson = new Gson();
            data = gson.fromJson(reader, dataModelClass);
        }catch (Exception e){
            throw  new RuntimeException("[ERR] reading file ".concat(absoluteFileLocation));
        }

        return data;
    }
}
