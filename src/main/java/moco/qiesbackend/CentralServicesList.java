package moco.qiesbackend;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import moco.qiesbackend.record.ServiceNumber;

/**
 * CentralServicesList
 */
@Getter
public class CentralServicesList {

    Map<ServiceNumber, Service> services;

    public CentralServicesList() {
        services = new HashMap<>();
    }

    public void add(Service service) {
        services.put(service.getServiceNumber(), service);
    }

    public void delete(ServiceNumber number) {
        services.remove(number);
    }

    private ArrayList<String> centralServicesFileContents() {
        ArrayList<String> lines = new ArrayList<>();

        

        return lines;
    }

    public void writeCentralServicesFile(Path centralServicesOutputPath) {

    }

    private ArrayList<String> validServicesFileContents() {
        ArrayList<String> lines = new ArrayList<>();

        services.forEach((serviceNumber, service) -> lines.add(serviceNumber.toString()));
        lines.add("00000");

        return lines;
    }

    public void writeValidServicesFile(Path validServicesOutputPath) {
        try {
            Files.write(validServicesOutputPath, validServicesFileContents(), CREATE, WRITE, APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}