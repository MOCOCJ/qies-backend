package moco.qiesbackend;

import moco.qiesbackend.record.NumberTickets;
import moco.qiesbackend.record.ServiceName;
import moco.qiesbackend.record.ServiceNumber;

/**
 * Service
 */
public class Service {

    private ServiceNumber serviceNumber;
    private ServiceName serviceName;
    private NumberTickets ticketsSold;
    private int serviceCapacity; // wrap into its own type later

    public Service() {
        
    }


}