
 

/**
 * @author Rana
 * @version 2019
 *
 */
import java.util.Calendar;
public class ParkedCar {
	public static final int CAR_MODEL_YEAR_LOWER_LIMIT = 1900;
	public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	
	private String ownerName;
	private String carMake;
	private String licensePlateNumber;
	private int modelYear;
	private int numberOfMinutesParked;
	
	
	
	/**
	 * @param inputOwnerName
	 * @param make
	 * @param inputModelYear
	 * @param license
	 * @param minutesParked
	 */
	public ParkedCar(String inputOwnerName, String make, int inputModelYear,
			         String license, int minutesParked) {
		
		if(inputOwnerName != null) {
			ownerName = inputOwnerName;
		} else {
			throw new IllegalArgumentException("owner name cannot be null");
		}
		
		if(make != null) {
			carMake = make;
		} else {
			throw new IllegalArgumentException("car make cannot be null");
		}
		
		if(license != null) {
			licensePlateNumber = license;
		} else {
			throw new IllegalArgumentException("car license number connot be null");
		}
		
		if(inputModelYear >= CAR_MODEL_YEAR_LOWER_LIMIT && inputModelYear <= CURRENT_YEAR) {
			  modelYear = inputModelYear;
		} else if (inputModelYear < CAR_MODEL_YEAR_LOWER_LIMIT) {
			throw new IllegalArgumentException("model year cannot be earlier than " + CAR_MODEL_YEAR_LOWER_LIMIT);
		} else {
			throw new IllegalArgumentException("model year cannot be later than " + CURRENT_YEAR); 
		}
		
		if(minutesParked > 0) {
			numberOfMinutesParked = minutesParked;
		} else {
			throw new IllegalArgumentException("minutes parked should be greater than 0");
		}
	}


	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}


	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String inputOwnerName) {
		if(inputOwnerName != null) {
			ownerName = inputOwnerName;
		} else {
			throw new IllegalArgumentException("owner name cannot be null");
		}
	}


	/**
	 * @return the carMake
	 */
	public String getCarMake() {
		return carMake;
	}


	/**
	 * @param carMake the carMake to set
	 */
	public void setCarMake(String make) {

		if(make != null) {
			carMake = make;
		} else {
			throw new IllegalArgumentException("car make cannot be null");
		}
	}


	/**
	 * @return the licensePlateNumber
	 */
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}


	/**
	 * @param licensePlateNumber the licensePlateNumber to set
	 */
	public void setLicensePlateNumber(String license) {
		if(license != null) {
			licensePlateNumber = license;
		} else {
			throw new IllegalArgumentException("car license number connot be null");
		}
	}


	/**
	 * @return the modelYear
	 */
	public int getModelYear() {
		return modelYear;
	}


	/**
	 * @param modelYear the modelYear to set
	 */
	public void setModelYear(int inputModelYear) {
		if(inputModelYear >= CAR_MODEL_YEAR_LOWER_LIMIT && inputModelYear <= CURRENT_YEAR) {
			  modelYear = inputModelYear;
		} else if (inputModelYear < CAR_MODEL_YEAR_LOWER_LIMIT) {
			throw new IllegalArgumentException("model year cannot be earlier than " + CAR_MODEL_YEAR_LOWER_LIMIT);
		} else {
			throw new IllegalArgumentException("model year cannot be later than " + CURRENT_YEAR); 
		}
	}


	/**
	 * @return the numberOfMinutesParked
	 */
	public int getNumberOfMinutesParked() {
		return numberOfMinutesParked;
	}


	/**
	 * @param numberOfMinutesParked the numberOfMinutesParked to set
	 */
	public void setNumberOfMinutesParked(int minutesParked) {
		if(minutesParked > 0) {
			numberOfMinutesParked = minutesParked;
		} else {
			throw new IllegalArgumentException("minutes parked should be greater than 0");
		}
	}
	
	
	/**
	 *  method displayDetails() 
	 */
	public void displayDetails() {
		System.out.println("Owner name: " + ownerName);
		System.out.println("Car make: " + carMake);
		System.out.println("Car model year: "+ modelYear);
		System.out.println("Car license Plate number: "+ licensePlateNumber);
		System.out.println("Number of minutes parked: " + numberOfMinutesParked);
		
	}
	
	public static void main(String[] args) {
//		ParkedCar c = new ParkedCar("Adam White","Mazda",2010,"1A2B3C",95);
//		c.displayDetails();
		ParkingMeter meter = new ParkingMeter("Burnaby",true,10.5,120);
		meter.displayDetails();
	}
//	
	
	
	
	

}
