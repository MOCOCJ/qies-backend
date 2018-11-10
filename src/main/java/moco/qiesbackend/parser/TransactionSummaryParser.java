package moco.qiesbackend.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;

import lombok.extern.java.Log;
import moco.qiesbackend.record.NumberTickets;
import moco.qiesbackend.record.ServiceDate;
import moco.qiesbackend.record.ServiceName;
import moco.qiesbackend.record.ServiceNumber;
import moco.qiesbackend.record.TransactionCode;
import moco.qiesbackend.record.TransactionRecord;

/**
 * TransactionSummaryParser
 */
public class TransactionSummaryParser {

    private TransactionQueue transactionQueue;

    public TransactionSummaryParser() {
        
    }

    public static TransactionRecord parseLine(String transactionString) {
        String tempCode = transactionString.substring(0, 3);
        int parceLocation = 4, prevLocation = parceLocation, dateLength = 0;
        TransactionCode CODE;
        TransactionRecord newRecord;
        String temp = "";
        NumberTickets tempTickets;
        ServiceDate tempDate;
        ServiceName tempName;
        ServiceNumber tempNumber;

        switch (tempCode) {
        case "CRE":
            CODE = TransactionCode.CRE;
            newRecord = new TransactionRecord(CODE);

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation++;
            }
            temp = transactionString.substring(prevLocation, parceLocation);
            tempTickets = new NumberTickets(temp);
            newRecord.setNumberTickets(tempTickets);
            parceLocation++;
            prevLocation = parceLocation;

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            parceLocation = transactionString.length() - 1;
            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation--;
                dateLength++;
            }
            temp = transactionString.substring(prevLocation, transactionString.length() - dateLength);
            tempName = new ServiceName(temp);
            newRecord.setServiceName(tempName);
            prevLocation = transactionString.length() - dateLength - 1;

            temp = transactionString.substring(prevLocation);
            tempDate = new ServiceDate(temp);
            newRecord.setServiceDate(tempDate);

            return newRecord;
        case "DEL":
            CODE = TransactionCode.DEL;
            newRecord = new TransactionRecord(CODE);

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation++;
            }
            temp = transactionString.substring(prevLocation, parceLocation);
            tempTickets = new NumberTickets(temp);
            newRecord.setNumberTickets(tempTickets);
            parceLocation++;
            prevLocation = parceLocation;

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            parceLocation = transactionString.length() - 1;
            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation--;
                dateLength++;
            }
            temp = transactionString.substring(prevLocation, transactionString.length() - dateLength);
            tempName = new ServiceName(temp);
            newRecord.setServiceName(tempName);
            prevLocation = transactionString.length() - dateLength - 1;

            temp = transactionString.substring(prevLocation);
            tempDate = new ServiceDate(temp);
            newRecord.setServiceDate(tempDate);

            return newRecord;
        case "SEL":
            CODE = TransactionCode.SEL;
            newRecord = new TransactionRecord(CODE);

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation++;
            }
            temp = transactionString.substring(prevLocation, parceLocation);
            tempTickets = new NumberTickets(temp);
            newRecord.setNumberTickets(tempTickets);
            parceLocation++;
            prevLocation = parceLocation;

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            parceLocation = transactionString.length() - 1;
            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation--;
                dateLength++;
            }
            temp = transactionString.substring(prevLocation, transactionString.length() - dateLength);
            tempName = new ServiceName(temp);
            newRecord.setServiceName(tempName);
            prevLocation = transactionString.length() - dateLength - 1;

            temp = transactionString.substring(prevLocation);
            tempDate = new ServiceDate(temp);
            newRecord.setServiceDate(tempDate);

            return newRecord;
        case "CAN":
            CODE = TransactionCode.CAN;
            newRecord = new TransactionRecord(CODE);

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation++;
            }
            temp = transactionString.substring(prevLocation, parceLocation);
            tempTickets = new NumberTickets(temp);
            newRecord.setNumberTickets(tempTickets);
            parceLocation++;
            prevLocation = parceLocation;

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            parceLocation = transactionString.length() - 1;
            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation--;
                dateLength++;
            }
            temp = transactionString.substring(prevLocation, transactionString.length() - dateLength);
            tempName = new ServiceName(temp);
            newRecord.setServiceName(tempName);
            prevLocation = transactionString.length() - dateLength - 1;

            temp = transactionString.substring(prevLocation);
            tempDate = new ServiceDate(temp);
            newRecord.setServiceDate(tempDate);

            return newRecord;
        case "CHG":
            CODE = TransactionCode.CHG;
            newRecord = new TransactionRecord(CODE);

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation++;
            }
            temp = transactionString.substring(prevLocation, parceLocation);
            tempTickets = new NumberTickets(temp);
            newRecord.setNumberTickets(tempTickets);
            parceLocation++;
            prevLocation = parceLocation;

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            parceLocation = transactionString.length() - 1;
            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation--;
                dateLength++;
            }
            temp = transactionString.substring(prevLocation, transactionString.length() - dateLength);
            tempName = new ServiceName(temp);
            newRecord.setServiceName(tempName);
            prevLocation = transactionString.length() - dateLength - 1;

            temp = transactionString.substring(prevLocation);
            tempDate = new ServiceDate(temp);
            newRecord.setServiceDate(tempDate);

            return newRecord;
        case "EOS":
            CODE = TransactionCode.EOS;
            newRecord = new TransactionRecord(CODE);

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation++;
            }
            temp = transactionString.substring(prevLocation, parceLocation);
            tempTickets = new NumberTickets(temp);
            newRecord.setNumberTickets(tempTickets);
            parceLocation++;
            prevLocation = parceLocation;

            temp = transactionString.substring(parceLocation, parceLocation + 5);
            tempNumber = new ServiceNumber(temp);
            newRecord.setSourceNumber(tempNumber);
            parceLocation += 6;
            prevLocation = parceLocation;

            parceLocation = transactionString.length() - 1;
            while (transactionString.charAt(parceLocation) != ' ') {
                parceLocation--;
                dateLength++;
            }
            temp = transactionString.substring(prevLocation, transactionString.length() - dateLength);
            tempName = new ServiceName(temp);
            newRecord.setServiceName(tempName);
            prevLocation = transactionString.length() - dateLength - 1;

            temp = transactionString.substring(prevLocation);
            tempDate = new ServiceDate(temp);
            newRecord.setServiceDate(tempDate);

            return newRecord;
        default:
            break;
        }

        return null;
    }
}