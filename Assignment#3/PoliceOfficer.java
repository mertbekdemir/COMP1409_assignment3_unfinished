
/**
 * class PoliceOfficer
 *
 * @author Mert
 * @version 1409
 */
import java.util.ArrayList;
import java.util.Iterator;
public class PoliceOfficer
{
    private String officerName;
    private String officerBadgeNumber;
    private ArrayList<ParkingTicket> ticketList;

    public static final double ONE_HOUR_FINE_AMOUNT = 20;
    public static final int MINUTES_IN_HOUR = 60;
    /**
     * Constructor for PoliceOfficer objects
     */
    public PoliceOfficer(String newOfficerName, String newOfficerBadgeNumber){

        setOfficerName(newOfficerName);
        setOfficerBadgeNumber(newOfficerBadgeNumber);
        ticketList = new ArrayList<ParkingTicket>();//Why i cant put ArrayList in the beginning?
    }

    //Accessor methods

    /**
     * method getTicketList
     * @return ticketList
     */
    public ArrayList<ParkingTicket> getTicketList(){
        return ticketList;   
    }

    /**
     * method getOfficerName
     * return officerName
     */
    public String getOfficerName(){
        return officerName;
    }

    /**
     * method getOfficerBadgeNumber
     * return officerBadgeNumber
     */
    public String getOfficerBadgeNumber(){
        return officerBadgeNumber;
    }

    //Mutator methods

    /**
     * method setOfficerName
     * @param newOfficerName
     */
    public void setOfficerName(String newOfficerName){
        if(newOfficerName == null){
            throw new IllegalArgumentException("officer name must not be null");
        }
        else if(newOfficerName.equals("")){
            throw new IllegalArgumentException("officer name must not be an empty String");
        }else{
            officerName = newOfficerName;
        }
    }

    /**
     * method setOfficerBadgeNumber
     * @param newOfficerBadgeNumber
     */
    public void setOfficerBadgeNumber(String newOfficerBadgeNumber){
        if(newOfficerBadgeNumber == null){
            throw new IllegalArgumentException("badge number must not be null");   
        }
        else if(newOfficerBadgeNumber.equals("")){
            throw new IllegalArgumentException("badge number must not be empty String");
        }else{
            officerBadgeNumber = newOfficerBadgeNumber;
        }
    }

    private boolean isParkingTimeExpired(ParkedCar car, ParkingMeter meter){

        if(car.getNumberOfMinutesParked() > meter.getNumberOfPurchasedMinutes()){
            return true;
        }else{
            return false;
        }

    }

    private double calculateFine(ParkedCar car, ParkingMeter meter){
        int minutesOverParked = Math.abs(car.getNumberOfMinutesParked() - meter.getNumberOfPurchasedMinutes());
        double fineAmount = 0;
        if(isParkingTimeExpired(car, meter) == true) { 
            if(minutesOverParked <= MINUTES_IN_HOUR){
                fineAmount = ONE_HOUR_FINE_AMOUNT;
            }else{

                fineAmount = ONE_HOUR_FINE_AMOUNT*((minutesOverParked / MINUTES_IN_HOUR));
                if(minutesOverParked % MINUTES_IN_HOUR > 0){
                    fineAmount = ONE_HOUR_FINE_AMOUNT + ONE_HOUR_FINE_AMOUNT;
                }
            }
            return fineAmount;
        }
        return 0;
    }

    /**
     * method issueParkingTicket
     * @param car
     * @param meter
     */
    public void issueParkingTicket(ParkedCar car, ParkingMeter meter){
        if(isParkingTimeExpired(car, meter) == true) { 

            ParkingTicket ticket = new ParkingTicket(getOfficerName(),getOfficerBadgeNumber(),car.getLicensePlateNumber(),calculateFine(car,meter));//parameter car,meter? why?
            if(ticket != null){
                ticketList.add(ticket);                                                                                              //WHY I CANT USE ANY OTHER NAME FOR PARAMETER?

            }
        }

    }
    
    /**
     * method calculateSumOfAllFines
     */
    public void sumAllFines(){
        
        for(ParkingTicket tix : ticketList){
            double sum = 0;
            sum = sum + tix.getFineAmountInCAD();
            
        }
    }
    
    /**
     * method getSumOfFinesByCar
     * @return number of tickets for the license plate
     */
    public int getParkingTicketsCountForACar(String licensePlateNumber){
        int counter = 0;
        double sum = 0;
        if(licensePlateNumber != null && !licensePlateNumber.isEmpty()){
            for(ParkingTicket tix : ticketList){
                if(tix.getCarLicensePlateNumber().equalsIgnoreCase(licensePlateNumber)){
                    counter ++;
                    
                }
            }
        }
        return counter;
    }
    
    /**
     * method getTicketArrayByLicenseNumber
     */
    public ParkingTicket[] getTicketArrayByLicenseNumber(String licensePlateNumber){
     
        for(index = 0; index < ticketList.size();i++)
        ParkingTicket[] tix = new ParkingTicket[ticketList.size()];
        if(tix[index].getLicensePlateNumber().equalsIgnoreCase(licensePlateNumber)){
            tix[index] = ticketList.get(index);
        }
        return tix;
    }
    
    /**
     * method getSumOfFinesByCar
     * @return total amount of fines for the license plate
     */
    public double getSumOfFinesByCar(String licensePlateNumber){
          double sum = 0;
        if(licensePlateNumber != null && !licensePlateNumber.isEmpty()){
            for(ParkingTicket tix : ticketList){
                if(tix.getCarLicensePlateNumber().equalsIgnoreCase(licensePlateNumber)){
                    sum = sum + tix.getFineAmountInCAD();
                    
                }
            }
        }
        return sum;
    }
    
    /**
     * method displayTicketDetails
     */
    public void displayTicketDetails(){
        for(ParkingTicket tix : ticketList){
            tix.displayDetails();
        }
    }
    
    /**
     * method deleteTicketsByCarLicense
     * @return number of deleted parking ticket objects
     */
    public int deleteTicketsByCarLicense(String licensePlateNumber){
        int index = 0;
        int counter = 0;
        if(licensePlateNumber != null && !licensePlateNumber.isEmpty()){
            Iterator<ParkingTicket> ticketIterator = ticketList.Iterator();
        while(ticketIterator.hasNext()){
            ArrayList<ParkingTicket> ticket = ticketIterator.next();
            if(ticket.getCarLicensePlateNumber().equalsIgnoreCase(licensePlateNumber)){
                counter ++;
                ticket.remove();
            }
           
        }
     }
        return counter;
    }
}
