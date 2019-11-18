/**
 * 
 */

/**
 * @author Rana
 *
 */
public class ParkingTicket {
	private String officerName;
	private String officerBadgeNumber;
	private String ticketNumber;
	private String carLicensePlateNumber;
	private double fineAmountInCAD;
public static  int counter = 1000;
	public static final String TICKET_PREFIX = "VAN";
	
	
	public ParkingTicket(String name, String badgeNumber, String carLicense, double fine) {
		generatTicketNumber();
		setOfficerName(name);
		setOfficerBadgeNumber(badgeNumber);
		setCarLicensePlateNumber(carLicense);
		setFineAmountInCAD(fine);
		
	}
	
	
	private void generatTicketNumber() {
		ticketNumber = TICKET_PREFIX + ++counter;
		 
	}
	/**
	 * @return the officerName
	 */
	public String getOfficerName() {
		return officerName;
	}


	/**
	 * @param officerName the officerName to set
	 */
	public void setOfficerName(String name) {
		if(name != null && name.length() > 0) {
		this.officerName = name;
		} else if (name == null) {
			throw new IllegalArgumentException("officer name must not be null");
		} else {
			throw new IllegalArgumentException ("officer name must not be an empty String");
		}
	}


	/**
	 * @return the officerBadgeNumber
	 */
	public String getOfficerBadgeNumber() {
		return officerBadgeNumber;
	}


	/**
	 * @param officerBadgeNumber the officerBadgeNumber to set
	 */
	public void setOfficerBadgeNumber(String badgeNumber) {
		if(badgeNumber != null && badgeNumber.length() > 0) {
			officerBadgeNumber = badgeNumber;
		} else if (badgeNumber == null) {
			throw new IllegalArgumentException("badge number must not be null");
		} else {
			throw new IllegalArgumentException ("badge number must not be empty String");
		}
	}


	/**
	 * @return the carLicensePlateNumber
	 */
	public String getCarLicensePlateNumber() {
		return carLicensePlateNumber;
	}


	/**
	 * @param carLicensePlateNumber the carLicensePlateNumber to set
	 */
	public void setCarLicensePlateNumber(String licensePNumber) {
		if(licensePNumber != null && licensePNumber.length() > 0) {
			carLicensePlateNumber = licensePNumber;
		} else if (licensePNumber == null) {
			throw new IllegalArgumentException("car license plate number must not be null");
		} else {
			throw new IllegalArgumentException ("car license plate number must not be empty String");
		}
	}


	/**
	 * @return the fineAmountInCAD
	 */
	public double getFineAmountInCAD() {
		return fineAmountInCAD;
	}


	/**
	 * @param fineAmountInCAD the fineAmountInCAD to set
	 */
	public void setFineAmountInCAD(double fine) {
		if(fine > 0) {
			fineAmountInCAD = fine;
		}else if(fine == 0) {
			throw new IllegalArgumentException("fine amount must not be 0");
		}else {
			throw new IllegalArgumentException("fine amount must not be negative");
		}
	}
	
	/**
	 * @return the ticket number
	 */
	public String getTicketNumber() {
		return ticketNumber;
	}
	
	 public void displayDetails() {
		 System.out.println("Ticket Number: "+ ticketNumber);//getTicketNumber() ?
		 System.out.println("Officer Name: "+ officerName);
		 System.out.println("Officer Badge number: " + officerBadgeNumber);
		 System.out.println("Car License Plate Number: "+ carLicensePlateNumber);
		 System.out.println("Fine amount: "+ fineAmountInCAD);
	 }
	
	 public static void main(String[] args) {
		 ParkingTicket ticket = new ParkingTicket("Bob Smith", "RCMP2251", "1A2B3C", 150.0);
		 ticket.displayDetails();
	 }
	 
	 public static void resetCounter() {
		 counter = 1000;
	 
	 }
}
