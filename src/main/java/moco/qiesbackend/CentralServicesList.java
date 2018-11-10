package moco.qiesbackend;

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
        byte[] recordBytes;
        try {
            for (int i = 0; i < validServices.size(); i++) {
                recordBytes = validServices.get(i).getBytes();

                Files.write(validServicePath, recordBytes, CREATE, WRITE, APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}