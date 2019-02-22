package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebService(serviceName = "FileUploadImpl", endpointInterface = "webservice.FileUpload")
public class FileUploadImpl implements FileUpload {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "getFile")
    public List<File> getFile() {
        List<File> files = null;
        try {
            File f = new File("D:\\Java\\lab4web\\src\\main\\resources");
            files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(f.listFiles())));
        } catch (Exception ex) {
        }
        return files;
    }
}
