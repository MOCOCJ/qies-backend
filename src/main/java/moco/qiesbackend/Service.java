package moco.qiesbackend;

import lombok.Getter;
import lombok.Setter;
import moco.qiesbackend.record.NumberTickets;
import moco.qiesbackend.record.ServiceName;
import moco.qiesbackend.record.ServiceNumber;

/**
 * Service
 */
@Getter
@Setter
public class Service {

    private ServiceNumber serviceNumber;
    private ServiceName serviceName;
    private NumberTickets ticketsSold;
    private int serviceCapacity; // TODO: wrap into its own type later

    public Service() {
        serviceCapacity = 30;
        serviceNumber = new ServiceNumber();
        serviceName = new ServiceName();
        ticketsSold = new NumberTickets();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(serviceNumber);
        sb.append(" ");
        sb.append(serviceCapacity);
        sb.append(" ");
        sb.append(ticketsSold);
        sb.append(" ");
        sb.append(serviceName);

        return sb.toString();
    }
}