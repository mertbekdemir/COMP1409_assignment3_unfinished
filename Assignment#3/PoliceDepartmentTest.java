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
 * 
 */

/**
 * @author Rana
 *
 */
public class PoliceDepartmentTest {
	private static Grader grader = new Grader(13);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	 System.out.println("Test Police Department start");
	}

	/* (non-Javadoc)
	 * @see GeneralSpecificationsTest#tearDownAfterClass()
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("PoliceDepartment test class Score: " + grader.getMarks() + " / " + grader.getMax());
	}
	
	@Test
	 public void testAddress() {
			testField(PoliceDepartment.class,"address",String.class, new String[] {"private",},new String []{"static","final",});
			testMethod(PoliceDepartment.class,"getAddress",String.class, new String[] {"public"},new String[] {"static", "final"});
			testMethod(PoliceDepartment.class,"setAddress",void.class, new String[] {"public"},new String[] {"static", "final"},String.class);
			grader.addMark(1);
		}

	@Test
	 public void testOfficerList() {
			testField(PoliceDepartment.class,"officerList",ArrayList.class, new String[] {"private",},new String []{"static","final",});
			grader.addMark(1);
			testMethod(PoliceDepartment.class,"getOfficerList",ArrayList.class, new String[] {"public"},new String[] {"static", "final"});
			grader.addMark(1);
		}
	
	@Test
	public void testMethodAddPoliceOfficer() {
		testMethod(PoliceDepartment.class,"addPoliceOfficer",void.class, new String[] {"public"},new String[] {"static", "final"},PoliceOfficer.class);
		grader.addMark(1);
	}
	
	@Test
	public void testMethodCalculateSumOfAllTicketsOfAllOfficers() {
		testMethod(PoliceDepartment.class,"calculateSumOfAllTicketsOfAllOfficers",double.class, new String[] {"public"},new String[] {"static", "final"});
		grader.addMark(1);
	}
	
	@Test
	public void testMethodTotalParkingTicketCountOfACar() {
		testMethod(PoliceDepartment.class,"totalParkingTicketCountOfACar",int.class, new String[] {"public"},new String[] {"static", "final"},String.class);
		grader.addMark(1);
	}
	
	@Test
	public void testConstructorAddressNull() {
		try {
		PoliceDepartment department = new PoliceDepartment(null);
		 fail ("null address must throw an Illegal Argument Excepiton");
		} catch(IllegalArgumentException ex){
			assertEquals("address cannot be null", ex.getMessage());
			grader.addMark(1);
		}	
	}
	
	@Test
	public void testConstructorAddressEmptyString() {
		try {
		PoliceDepartment department = new PoliceDepartment("");
		 fail ("Empty String address must throw an Illegal Argument Excepiton");
		} catch(IllegalArgumentException ex){
			assertEquals("address cannot be an empty String", ex.getMessage());
			grader.addMark(1);
		}	
	}
	
	@Test
	public void testConstructorAddressValidInput() {
		
		PoliceDepartment department = new PoliceDepartment("Vancouver");
			assertEquals("Vancouver", department.getAddress());
			grader.addMark(1);
		}	
	
	
	
	@Test
	public void testAddPoliceOfficer() {
		PoliceDepartment department = new PoliceDepartment("Vancouver");
		PoliceOfficer officer = new PoliceOfficer("Adam White","RCMP5225");
		department.addPoliceOfficer(officer);
		assertSame(officer,department.getOfficerList().get(0));
		
	}
	
	@Test
	public void testAddPoliceOfficerNull() {
		PoliceDepartment department = new PoliceDepartment("Vancouver");
		PoliceOfficer officer = null;
		department.addPoliceOfficer(officer);
		assertEquals(0,department.getOfficerList().size());
		grader.addMark(1);
	}
	
	@Test
	public void testDisplayTicketsByOfficer() {
		PoliceDepartment department = new PoliceDepartment("Vancouver");
		PoliceOfficer officer = new PoliceOfficer("Adam White","RCMP5225");
		department.addPoliceOfficer(officer);
		ParkingTicket.resetCounter();
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 65);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		officer.issueParkingTicket(car, meter);
		ParkedCar car2 = new ParkedCar("Scott Marks", "Ford", 2010, "MYCAR", 30);
		meter.setNumberOfPurchasedMinutes(1);
		officer.issueParkingTicket(car2, meter);
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		 final PrintStream originalOut = System.out;
		 System.setOut(new PrintStream (outContent));
		
		 department.displayTicketsByOfficer("aDaM wHiTe");
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
	public void testCalculateSumOfAllTicketsOfAllOfficers() {
		PoliceDepartment department = new PoliceDepartment("Vancouver");
		PoliceOfficer officer = new PoliceOfficer("Adam White","RCMP5225");
		department.addPoliceOfficer(officer);
		ParkingTicket.resetCounter();
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 65);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		officer.issueParkingTicket(car, meter);
		ParkedCar car2 = new ParkedCar("Scott Marks", "Ford", 2010, "MYCAR", 30);
		meter.setNumberOfPurchasedMinutes(1);
		officer.issueParkingTicket(car2, meter);
		PoliceOfficer officer2 = new PoliceOfficer("Lucy Booker","RCMP1234");
		department.addPoliceOfficer(officer2);
		car.setNumberOfMinutesParked(60);
		meter.setNumberOfPurchasedMinutes(10);
		officer2.issueParkingTicket(car, meter);
		car2.setNumberOfMinutesParked(125);
		meter.setNumberOfPurchasedMinutes(10);
		officer2.issueParkingTicket(car2, meter);
		assertEquals(100,department.calculateSumOfAllTicketsOfAllOfficers(),0.05);
		 grader.addMark(1);
	}
	
	@Test
	public void testTotalParkingTicketCountOfACar() {
		PoliceDepartment department = new PoliceDepartment("Vancouver");
		PoliceOfficer officer = new PoliceOfficer("Adam White","RCMP5225");
		department.addPoliceOfficer(officer);
		ParkingTicket.resetCounter();
		ParkedCar car = new ParkedCar("Bob Smith", "Porsche", 2015, "1A2B3C", 65);
		ParkingMeter meter = new ParkingMeter("Burnaby",false,10.5,60);
		officer.issueParkingTicket(car, meter);
		ParkedCar car2 = new ParkedCar("Scott Marks", "Ford", 2010, "MYCAR", 30);
		meter.setNumberOfPurchasedMinutes(1);
		officer.issueParkingTicket(car2, meter);
		PoliceOfficer officer2 = new PoliceOfficer("Lucy Booker","RCMP1234");
		department.addPoliceOfficer(officer2);
		car.setNumberOfMinutesParked(60);
		meter.setNumberOfPurchasedMinutes(10);
		officer2.issueParkingTicket(car, meter);
		car2.setNumberOfMinutesParked(125);
		meter.setNumberOfPurchasedMinutes(10);
		officer2.issueParkingTicket(car2, meter);
		car.setNumberOfMinutesParked(80);
		meter.setNumberOfPurchasedMinutes(20);
		officer2.issueParkingTicket(car, meter);
		assertEquals(3,department.totalParkingTicketCountOfACar("1A2B3C"));
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
