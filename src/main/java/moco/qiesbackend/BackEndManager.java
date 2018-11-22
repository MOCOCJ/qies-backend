package moco.qiesbackend;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import moco.qiesbackend.parser.CentralServicesParser;
import moco.qiesbackend.parser.TransactionQueue;
import moco.qiesbackend.parser.TransactionSummaryParser;
import moco.qiesbackend.record.TransactionRecord;

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

        // TODO: Do some checks here to ensure that the files exist and can be read from

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