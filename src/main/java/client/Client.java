package client;

import webservice.FileUpload;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Client {
    private Service service;

    public Client() {
        URL url = null;
        try {
            url = new URL("http://localhost:8080?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        QName qname = new QName("http://webservice/", "FileUploadImpl");
        service = Service.create(url, qname);
    }

    public String[] getFiles() {
        List<File> files;
        files = service.getPort(FileUpload.class).getFile();
        if ((files == null) || (files.size() <= 0)) {
            System.out.println("File was not sent");
            return null;
        }
        String s[] = new String[100];
        for (int i = 0; i < files.size(); i++) {
            s[i] = files.get(i).toString();
        }
        return s;
    }
}
