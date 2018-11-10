package moco.qiesbackend.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import lombok.extern.java.Log;
import moco.qiesbackend.Service;
import moco.qiesbackend.record.NumberTickets;
import moco.qiesbackend.record.ServiceName;
import moco.qiesbackend.record.ServiceNumber;

/**
 * CentralServicesParser
 */
@Log
public class CentralServicesParser {

    public static ArrayList<Service> parseFile(Path centralServicesPath) {
        ArrayList<Service> servicesList = new ArrayList<>();
        List<String> servicesFileLines = null;

        try {
            servicesFileLines = Files.readAllLines(centralServicesPath);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Unable to read merged transaction summary file");
            e.printStackTrace();
        }

        for (String line : servicesFileLines) {
            servicesList.add(parseLine(line));
        }

        return servicesList;
    }

    public static Service parseLine(String serviceString) {
        Service service = new Service();
        String serviceTokens[] = serviceString.split(" ", 4);

        service.setServiceNumber(new ServiceNumber(serviceTokens[0]));
        service.setServiceCapacity(Integer.parseInt(serviceTokens[1]));
        service.setTicketsSold(new NumberTickets(serviceTokens[2]));
        service.setServiceName(new ServiceName(serviceTokens[3]));

        return service;
    }
}