package moco.qiesbackend;

import java.io.File;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;

public class CreateValidServicesFile {

    public String addService(String validServicesFilePath, String service) {
        File validServicesFile = new File(validServicesFilePath);
        return validServicesFilePath;
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

                Files.write(validServicePath, recordBytes, CREATE, WRITE, APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}