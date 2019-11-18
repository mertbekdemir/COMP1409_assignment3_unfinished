/**
 * 
 */

/**
 * @author Rana
 *
 */
public class ParkingMeter {
	
	public static final int MAX_NUMBER_OF_PURCHASED_MINUTES = 180;
	private String meterLocation;
	private boolean hasACamera;
	private double priceOfOneMinuteInCAD;
	private int numberOfPurchasedMinutes;
	
	/**
	 * @param location
	 * @param camera
	 * @param priceOfMinute
	 * @param purchasedMiutes
	 */
	public ParkingMeter(String location, boolean camera, double priceOfMinute,int purchasedMinutes) {
		if(location == null) {
			throw new IllegalArgumentException("meter location cannot be null");
		} else {
			meterLocation = location;
		}
		
		if(priceOfMinute > 0) {
			priceOfOneMinuteInCAD = priceOfMinute;
		} else {
			throw new IllegalArgumentException("price of one minute cannot be 0 or less");
		}
		
		if(purchasedMinutes >0 && purchasedMinutes <=  MAX_NUMBER_OF_PURCHASED_MINUTES) {
			numberOfPurchasedMinutes = purchasedMinutes;
		} else if (purchasedMinutes <= 0) {
			throw new IllegalArgumentException("number of purchased minutes cannot be 0 or negative");
		} else {
			System.out.println("number of purchased minutes cannot be greater than 180, the value will set to 180");
			numberOfPurchasedMinutes = MAX_NUMBER_OF_PURCHASED_MINUTES;
		}
		
		hasACamera = camera;
	}

	/**
	 * @return the meterLocation
	 */
	public String getMeterLocation() {
		return meterLocation;
	}

	/**
	 * @param meterLocation the meterLocation to set
	 */
	public void setMeterLocation(String location) {
		if(location == null) {
			throw new IllegalArgumentException("meter location cannot be null");
		} else {
			meterLocation = location;
		}
	}

	/**
	 * @return the hasACamera
	 */
	public boolean getHasACamera() {
		return hasACamera;
	}

	/**
	 * @param hasACamera the hasACamera to set
	 */
	public void setHasACamera(boolean isCameraAvailable) {
		hasACamera = isCameraAvailable;
	}

	/**
	 * @return the priceOfOneMinuteInCAD
	 */
	public double getPriceOfOneMinuteInCAD() {
		return priceOfOneMinuteInCAD;
	}

	/**
	 * @param priceOfOneMinuteInCAD the priceOfOneMinuteInCAD to set
	 */
	public void setPriceOfOneMinuteInCAD(double priceOfMinute) {
		if(priceOfMinute > 0) {
			priceOfOneMinuteInCAD = priceOfMinute;
		} else {
			throw new IllegalArgumentException("price of one minute cannot be 0 or less");
		}
	}

	/**
	 * @return the numberOfPurchasedMinutes
	 */
	public int getNumberOfPurchasedMinutes() {
		return numberOfPurchasedMinutes;
	}

	/**
	 * @param numberOfPurchasedMinutes the numberOfPurchasedMinutes to set
	 */
	public void setNumberOfPurchasedMinutes(int purchasedMinutes) {
		if(purchasedMinutes >0 && purchasedMinutes <=  MAX_NUMBER_OF_PURCHASED_MINUTES) {
			numberOfPurchasedMinutes = purchasedMinutes;
		} else if (purchasedMinutes <= 0) {
			throw new IllegalArgumentException("number of purchased minutes cannot be 0 or negative");
		} else {
			System.out.println("number of purchased minutes cannot be greater than 180, the value will set to 180");
			numberOfPurchasedMinutes = MAX_NUMBER_OF_PURCHASED_MINUTES;
		}
	}

		
	public void displayDetails() {
		System.out.println("metre location: " + meterLocation);
		System.out.println("meter have a camera: " + hasACamera);
		System.out.println("price of one minute in CAD: " + priceOfOneMinuteInCAD);
		System.out.println("number of purchased minutes: "+ numberOfPurchasedMinutes);
		
	}
	
	

}
