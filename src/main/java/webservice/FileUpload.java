package webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.File;
import java.util.List;

@WebService
public interface FileUpload {

    @WebMethod(operationName = "hello")
    String hello(@WebParam(name = "name") String txt);

    @WebMethod(operationName = "getFile")
    List<File> getFile();
}
