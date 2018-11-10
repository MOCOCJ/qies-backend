package moco.qiesbackend;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CreateValidServicesFile {

    List<String> validServices = new ArrayList<String>();

    public CreateValidServicesFile(String centralServicesFile, String newValidServicesFile) {
        readServices(new File(centralServicesFile));
        writeNewValidServicesFile(new File(newValidServicesFile));
    }

    public void readServices(File centralServicesFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(centralServicesFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String serviceNumber = line.substring(0, 5);
                if (!validServices.contains(serviceNumber))
                    validServices.add(serviceNumber);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeNewValidServicesFile(File newValidServicesFile) {
        Path validServicePath = newValidServicesFile.toPath();
        byte[] recordBytes;
        try {
            for (int i = 0; i < validServices.size(); i++) {
                recordBytes = validServices.get(i).getBytes();

                Files.write(newValidServicesFile, recordBytes, CREATE, WRITE, APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}