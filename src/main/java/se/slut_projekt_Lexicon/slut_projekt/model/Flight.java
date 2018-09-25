package se.slut_projekt_Lexicon.slut_projekt.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String departureDate;
	private String arrivalDate;
	private String departureAirport;
	private String destinationAirport;
	private String departureTime;
	private String arrivalTime;
	private double firstClasPrice;
	private double economyClasPrice;
	private int firstClasSeat;
	private int economyClasSeat;
	

	// costructor 01
	public Flight() {
	}

	// constructor 02
	public Flight(int day, int month, int year, String departureAirport, String destinationAirport,
			String departureTime, String arrivalTime, String arrivalDate) {
//		String airlineID = flightNumber.substring(0, 2);
//		String number = flightNumber.substring(2);
//		this.setFlightNumber(airlineID, number);
		setDepartureDate(day, month, year);
		this.departureAirport = departureAirport.toUpperCase();
		this.destinationAirport = destinationAirport.toUpperCase();
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.arrivalDate = arrivalDate;
		// this.sections = sections;
	}

//	public void setFlightNumber(String airlineID, String number) {
//		if (airlineID.matches("[a-zA-Z]+$") && airlineID.length() == 2 && number.matches("[0-9 ]+$")) {
//			this.flightNumber = airlineID + number;
//
//		} else {
//			System.out.println("Invalid Flight Number");
//		}
//
//	}

	public void setDepartureDate(int day, int month, int year) {
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy"); // Defines the date format needed
		Calendar calendar1 = new GregorianCalendar(year, month - 1, day); // creates a date from Calendar class
		this.departureDate = sdf.format(calendar1.getTime());
	}
	public void setArrivalDate(int day, int month, int year) {
		SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy"); // Defines the date format needed
		Calendar calendar1 = new GregorianCalendar(year, month - 1, day); // creates a date from Calendar class
		this.departureDate = sdf.format(calendar1.getTime());
	}

	public void setDepartureAirport(String departureAirport) {

		if (departureAirport.matches("[a-zA-Z]+$") && departureAirport.length() == 3) {
			this.departureAirport = departureAirport.toUpperCase();
		} else {
			System.out.println("Invalid  ID");
		}

	}

	public void setDestinationAirport(String destinationAirport) {

		if (destinationAirport.matches("[a-zA-Z]+$") && destinationAirport.length() == 3) {
			this.destinationAirport = destinationAirport.toUpperCase();
		} else {
			System.out.println("Invalid ID");
		}

	}

	public void setDepartureTime(int hour, int minute) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm "); // Defines the date format needed
		Calendar calendar1 = new GregorianCalendar(2018, 8, 9, hour, minute); // creates a date from Calendar class
		this.departureTime = sdf.format(calendar1.getTime());

	}

	public void setArrivalTime(int hour, int minute) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm "); // Defines the date format needed
		Calendar calendar1 = new GregorianCalendar(2018, 8, 9, hour, minute); // creates a date from Calendar class
		this.arrivalTime = sdf.format(calendar1.getTime());
	}

	


	public String getDepartureDate() {
		return departureDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public String getDepartureAirport() {
		return departureAirport;
	}

	public String getDestinationAirport() {
		return destinationAirport;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFirstClasPrice() {
		return firstClasPrice;
	}

	public void setFirstClasPrice(double firstClasPrice) {
		this.firstClasPrice = firstClasPrice;
	}

	public double getEconomyClasPrice() {
		return economyClasPrice;
	}

	public void setEconomyClasPrice(double economyClasPrice) {
		this.economyClasPrice = economyClasPrice;
	}

	public int getFirstClasSeat() {
		return firstClasSeat;
	}

	public void setFirstClasSeat(int firstClasSeat) {
		this.firstClasSeat = firstClasSeat;
	}

	public int getEconomyClasSeat() {
		return economyClasSeat;
	}

	public void setEconomyClasSeat(int economyClasSeat) {
		this.economyClasSeat = economyClasSeat;
	}

	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate
				+ ", departureAirport=" + departureAirport + ", destinationAirport=" + destinationAirport
				+ ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", firstClasPrice="
				+ firstClasPrice + ", economyClasPrice=" + economyClasPrice + ", firstClasSeat=" + firstClasSeat
				+ ", economyClasSeat=" + economyClasSeat + "]";
	}
	
}

	