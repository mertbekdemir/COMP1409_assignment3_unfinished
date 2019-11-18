import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.ArrayList;

/**
 * @author Rana
 *
 */
public class PoliceOfficerTest  {
	private static Grader grader = new Grader(17);

	/* (non-Javadoc)
	 * @see GeneralSpecificationsTest#setUpBeforeClass()
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	 System.out.println("Test Police Officer start");
	}

	/* (non-Javadoc)
	 * @see GeneralSpecificationsTest#tearDownAfterClass()
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("PoliceOfficer test class Score: " + grader.getMarks() + " / " + grader.getMax());
	}
	
	@Test
	public void testTicketList() {
		testField(PoliceOfficer.class,"ticketList",ArrayList.class, new String[] {"private",},new String []{"static","final",});
		grader.addMark(1);
		testMethod(PoliceOfficer.class,"getTicketList",ArrayList.class, new String[] {"public"},new String[] {"static", "final"});
		grader.addMark(1);
	}

	@Test
	public void testMethodSumAllFines() {
		
		testMethod(PoliceOfficer.class,"sumAllfines",double.class, new String[] {"public"},new String[] {"static", "final"});
		grader.addMark(1);
	}
	
	@Test
	public void testMethodGetParkingTicketsCountForACar() {
		
		testMethod(PoliceOfficer.class,"getParkingTicketsCountForACar",int.class, new String[] {"public"},new String[] {"static", "final"},String.class);
		grader.addMark(1);
	}
	
	@Test
	public void testMethodGetTicketArrayByLicenseNumb() {
		
		testMethod(PoliceOfficer.class,"getTicketArrayByLicenseNumber",ParkingTicket[].class, new String[] {"public"},new String[] {"static", "final"},String.class);
		grader.addMark(1);
	}
	
	@Test
	public void testMethodGetSumOfFinesByCar() {
		
		testMethod(PoliceOfficer.class,"getSumOfFinesByCar",double.class, new String[] {"public"},new String[] {"static", "final"},String.class);
		grader.addMark(1);
	}

	@Test
	public void testIssueParkingTicket() {
		testMethod(PoliceOfficer.class,"issueParkingTicket",void.class, new String[] {"public"},new String[] {"static", "final","private"},ParkedCar.class,ParkingMeter.class);
		grader.addMark(1);
	}
	
	@Test
	public void testMethodDeleteTicketsByCarLicense() {
		testMethod(PoliceOfficer.class,"deleteTicketsByCarLicense",int.class, new String[] {"public"},new String[] {"static", "final","private"},String.class);
		grader.addMark(1);
	}
	@Test
	public void testMethodDisplayticketsDetails() {
		testMethod(PoliceOfficer.class,"displayticketsDetails",void.class, new String[] {"public"},new String[] {"static", "final","private"});
		grader.addMark(1);
	}
	

	
	@Test
	public void testIssueParkingTicketValid(){
		PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 61);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		p.issueParkingTicket(car, meter);
		assertEquals(1,p.getTicketList().size());
		grader.addMark(1);
		
	}
	
	@Test
	public void testIssueParkingTicketNoTicket(){
		PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 60);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		p.issueParkingTicket(car, meter);
		assertEquals(0,p.getTicketList().size());
		grader.addMark(1);
		
	}
	
	@Test
	public void testSumOfAllfines() {
		PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 65);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		p.issueParkingTicket(car, meter);
		ParkedCar car2 = new ParkedCar("Scott Marks", "Ford", 2010, "MYCAR", 30);
		meter.setNumberOfPurchasedMinutes(1);
		p.issueParkingTicket(car2, meter);
		car.setNumberOfMinutesParked(125);
		meter.setNumberOfPurchasedMinutes(20);
		p.issueParkingTicket(car, meter);
		assertEquals(80.0, p.sumAllfines(),0.05);
		grader.addMark(1);
	}
	
	@Test
	public void testSumOfAllFinesNoFines() {
		PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
		assertEquals(0.0, p.sumAllfines(),0.05);
		grader.addMark(1);
		
	}
	

	
	
	@Test
	public void testGetParkingTicketsCountForACar() {
		
		PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 65);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		p.issueParkingTicket(car, meter);
		ParkedCar car2 = new ParkedCar("Scott Marks", "Ford", 2010, "MYCAR", 30);
		meter.setNumberOfPurchasedMinutes(1);
		p.issueParkingTicket(car2, meter);
		car.setNumberOfMinutesParked(125);
		meter.setNumberOfPurchasedMinutes(20);
		p.issueParkingTicket(car, meter);
		assertEquals(2,p.getParkingTicketsCountForACar("1a2B3c"));
		 grader.addMark(1);
	}
	
	@Test
	public void testGetSumOfFinesByCar() {
		PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 65);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		p.issueParkingTicket(car, meter);
		ParkedCar car2 = new ParkedCar("Scott Marks", "Ford", 2010, "MYCAR", 30);
		meter.setNumberOfPurchasedMinutes(1);
		p.issueParkingTicket(car2, meter);
		car.setNumberOfMinutesParked(125);
		meter.setNumberOfPurchasedMinutes(20);
		p.issueParkingTicket(car, meter);
		assertEquals(60,p.getSumOfFinesByCar("1a2B3c"),0.05);
		 grader.addMark(1);
	}
	
	@Test
	public void testDisplayDetails() {
		ParkingTicket.resetCounter();
		PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 65);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		p.issueParkingTicket(car, meter);
		ParkedCar car2 = new ParkedCar("Scott Marks", "Ford", 2010, "MYCAR", 30);
		meter.setNumberOfPurchasedMinutes(1);
		p.issueParkingTicket(car2, meter);
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		 final PrintStream originalOut = System.out;
		 System.setOut(new PrintStream (outContent));
		
		 p.displayticketsDetails();
		 assertEquals("Ticket Number: VAN1001" + System.getProperty("line.separator")
				     +"Officer Name: Adam White" +  System.getProperty("line.separator")
		 	    	 +"Officer Badge number: RCMP5225" + System.getProperty("line.separator")
		 		     +"Car License Plate Number: 1A2B3C" +  System.getProperty("line.separator")
		 		     +"Fine amount: 20.0" +  System.getProperty("line.separator") 
		 		     + System.getProperty("line.separator")
		 		     + "Ticket Number: VAN1002" + System.getProperty("line.separator")
		 		     + "Officer Name: Adam White" + System.getProperty("line.separator")
		 		     +"Officer Badge number: RCMP5225"+ System.getProperty("line.separator")
		 		     +"Car License Plate Number: MYCAR" +System.getProperty("line.separator")
		 		     +"Fine amount: 20.0"+ System.getProperty("line.separator")
		 		     +System.getProperty("line.separator"),outContent.toString());
				     
		 System.setOut(originalOut);
		 grader.addMark(1);
		
		
	}
	
	@Test
	public void testDeleteTicketsByCarLicense() {
		PoliceOfficer p = new PoliceOfficer("Adam White","RCMP5225");
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 65);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		p.issueParkingTicket(car, meter);
		ParkedCar car2 = new ParkedCar("Scott Marks", "Ford", 2010, "MYCAR", 30);
		meter.setNumberOfPurchasedMinutes(1);
		p.issueParkingTicket(car2, meter);
		car.setNumberOfMinutesParked(125);
		meter.setNumberOfPurchasedMinutes(20);
		p.issueParkingTicket(car, meter);
		assertEquals(2,p.deleteTicketsByCarLicense("1A2b3c"));
		 grader.addMark(1);
	}

	
	public void testField(final Class<?> clazz, 
			final String   fieldName,
			final Class    expectedType,
			final String[] expectedModifiers,
			final String[] forbiddenModifiers)
	{
		if(clazz == null){
			throw new IllegalArgumentException("clazz cannot be null");
		}

		if(fieldName == null){
			throw new IllegalArgumentException("fieldName cannot be null");
		}

		try {
			final Field    field;
			final int      modifiers;
			final Class<?> type;

			field = clazz.getDeclaredField(fieldName);
			type  = field.getType();

			if(!(type.equals(expectedType))) {
				fail(clazz.getName() + "." + fieldName + " must be declared as \"" + expectedType.getName() + "\"");
			}

			modifiers = field.getModifiers();
			checkRequiredModifiers(clazz, fieldName, expectedModifiers, modifiers);
			checkForbiddenModifiers(clazz, fieldName, forbiddenModifiers, modifiers);
		}
		catch(final NoSuchFieldException ex) {
			fail(clazz.getName() + " must have a field named: \"" + fieldName + "\"");
		}
	}

	public void testMethod(final Class<?>    clazz, 
			final String      methodName,
			final Class       expectedReturnType,                           
			final String[]    expectedModifiers,
			final String[]    forbiddenModifiers,
			final Class<?>... expectedParameters)
	{
		if(clazz == null)
		{
			throw new IllegalArgumentException("clazz cannot be null");
		}

		if(methodName == null)
		{
			throw new IllegalArgumentException("methodName cannot be null");
		}

		try
		{
			final Method   method;
			final int      modifiers;
			final Class<?> returnType;

			method     = clazz.getDeclaredMethod(methodName, expectedParameters);
			returnType = method.getReturnType();

			if(!(returnType.equals(expectedReturnType)))
			{
				fail(clazz.getName() + "." + methodName + " must be return \"" + expectedReturnType.getName() + "\"");
			}

			modifiers = method.getModifiers();
			checkRequiredModifiers(clazz, methodName, expectedModifiers, modifiers);
			checkForbiddenModifiers(clazz, methodName, forbiddenModifiers, modifiers);
		}
		catch(final NoSuchMethodException ex)
		{
			fail(clazz.getName() + " must have a method named: \"" + methodName + "\"");
		}
	}
	public void checkRequiredModifiers(final Class<?> clazz,
			final String   name,
			final String[] expectedModifiers, 
			final int      actualModifiers)
	{
		for(final String expected : expectedModifiers)
		{
			switch(expected)
			{
			case "public":
			{
				if(!(Modifier.isPublic(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"public\"");
				}
				break;
			}        
			case "private":
			{
				if(!(Modifier.isPrivate(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"private\"");
				}
				break;
			}        
			case "protected":
			{
				if(!(Modifier.isProtected(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"protected\"");
				}
				break;
			}        
			case "final":
			{
				if(!(Modifier.isFinal(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"final\"");
				}
				break;
			}        
			case "static":
			{
				if(!(Modifier.isStatic(actualModifiers)))
				{
					fail(clazz.getName() + "." + name + " must be declared \"static\"");
				}
				break;
			}        
			}
		}
	}

	public void checkForbiddenModifiers(final Class<?> clazz,
			final String   name,
			final String[] unexpectedModifiers, 
			final int      actualModifiers)
	{
		for(final String unexpected : unexpectedModifiers)
		{
			switch(unexpected)
			{
			case "public":
			{
				if(Modifier.isPublic(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"public\"");
				}
				break;
			}        
			case "private":
			{
				if(Modifier.isPrivate(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"private\"");
				}
				break;
			}        
			case "protected":
			{
				if(Modifier.isProtected(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"protected\"");
				}
				break;
			}        
			case "final":
			{
				if(Modifier.isFinal(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"final\"");
				}
				break;
			}        
			case "static":
			{
				if(Modifier.isStatic(actualModifiers))
				{
					fail(clazz.getName() + "." + name + " must not be declared \"static\"");
				}
				break;
			}        
			}
		}
	}

	
}
