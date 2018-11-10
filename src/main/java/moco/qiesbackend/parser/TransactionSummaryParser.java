package moco.qiesbackend.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;

import lombok.extern.java.Log;
import moco.qiesbackend.record.TransactionRecord;

/**
 * TransactionSummaryParser reads in the merged transaction summary files and
 * makes a queue of the transactions they contain for further processing
 */
@Log
public class TransactionSummaryParser {

    public static TransactionQueue parseFile(Path transactionSummaryPath) {
        TransactionQueue transactionQueue = new TransactionQueue();
        List<String> transactionFileLines = null;
        try {
            transactionFileLines = Files.readAllLines(transactionSummaryPath);
        } catch (IOException e) {
            log.log(Level.SEVERE, "Unable to read merged transaction summary file");
            e.printStackTrace();
        }

        for (String line : transactionFileLines) {
            transactionQueue.push(parseLine(line));
        }

        return transactionQueue;
    }

    public static TransactionRecord parseLine(String transactionString) {
        // TODO: Parse a line into a TransactionRecord
        return null;
    }
}