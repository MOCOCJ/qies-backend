package moco.qiesbackend;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;

import lombok.extern.java.Log;
import moco.qiesbackend.parser.CentralServicesParser;
import moco.qiesbackend.parser.TransactionQueue;
import moco.qiesbackend.parser.TransactionSummaryParser;
import moco.qiesbackend.record.TransactionRecord;

@Log
public class BackEndManager {
    TransactionQueue transactionSummary;
    CentralServicesList centralServicesList;
    Path centralServicesOutputPath;
    Path validServicesOutputPath;

    public BackEndManager(String mergedTransactionFile, String oldCentralFile, String newCentralFile, String newValidFile) {
        Path transactionSummaryPath = Paths.get(mergedTransactionFile);
        Path centralServicesPath = Paths.get(oldCentralFile);
        centralServicesOutputPath = Paths.get(newCentralFile);
        validServicesOutputPath = Paths.get(newValidFile);

        transactionSummary = TransactionSummaryParser.parseFile(transactionSummaryPath);
        centralServicesList = CentralServicesParser.parseFile(centralServicesPath);
    }

    public void operate() {
        TransactionRecord record;
        while(!transactionSummary.isEmpty()) {
            record = transactionSummary.pop();

            switch (record.getCode()) {
                case CRE:
                    processCRE(record);
                    break;
                case DEL:
                    processDEL(record);
                    break;
                case SEL:
                    processSEL(record);
                    break;
                case CAN:
                    processCAN(record);
                    break;
                case CHG:
                    processCHG(record);
                    break;
                case EOS:
                    break;
            }
        }
        centralServicesList.writeValidServicesFile(validServicesOutputPath);
        centralServicesList.writeCentralServicesFile(centralServicesOutputPath);
    }

    // Create service
    private void processCRE(TransactionRecord record) {
        String logMessage = "Failed to create new service. A service with that number already exists.";
        Level logLevel = Level.WARNING;
        if (!centralServicesList.contains(record.getSourceNumber())) {
            Service newService = new Service();
            newService.setServiceNumber(record.getSourceNumber());
            newService.setServiceName(record.getServiceName());
            centralServicesList.add(newService);
            logMessage = "New service created";
            logLevel = Level.INFO;
        }
        log.log(logLevel, logMessage);
    }

    // Delete service
    private void processDEL(TransactionRecord record) {

    }

    // Sell tickets
    private void processSEL(TransactionRecord record) {

    }

    // Cancel tickets
    private void processCAN(TransactionRecord record) {

    }

    // Change tickets
    private void processCHG(TransactionRecord record) {

    }
}