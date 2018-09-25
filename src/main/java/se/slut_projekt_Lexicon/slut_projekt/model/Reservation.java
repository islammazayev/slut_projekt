package se.slut_projekt_Lexicon.slut_projekt.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;

	
	    private int reservationNumber;
	    private int numberOfPassenger;
//	    private Passenger[] passengers; // = new Passenger[numberOfPassengers];
	    private String departureDate;
	    @OneToOne
	    private Seat seat;
	    
	    private SeatClass seatClass;
	    private double totalPrice;
	    
	    @ManyToOne
	    private Passenger passenger;
	    @ManyToOne
	    private Flight flight;
	    @OneToMany
	    private List<Food> foods;


		
	    
	    public Reservation()
	    {};
	    
	    public Reservation(int reservationNumber, int numberOfPassenger, String departureDate, Seat seat) {
	        this.reservationNumber = reservationNumber;
	        this.numberOfPassenger = numberOfPassenger;
//	        this.passengers = passengers;
	        this.departureDate = departureDate;
	        this.seat = seat;
	    }
	    
	    public double TotalPriceCalculate(){
	     double sum = 0;
	    	for(Food food : foods){
				sum += food.getFoodPrice();
				
			}
	    	sum += flight.getEconomyClasPrice();
	    	sum += flight.getFirstClasPrice();
	    	this.setTotalPrice(sum);
			return totalPrice;
	    	
	    }

	    public void setReservationNumber(int reservationNumber) {
	        this.reservationNumber = reservationNumber;
	    }

	    public void setNumberOfPassenger(int numberOfPassenger) {
	        this.numberOfPassenger = numberOfPassenger;
	    }

//	    public void setPassengers(Passenger[] passengers) {
//	        this.passengers = passengers;
//	    }

	    

	    public void setDepartureDate(int year, int month, int day) {
	        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");     //Defines the date format needed
	        Calendar calendar1 = new GregorianCalendar(year, month-1, day);   //creates a date from Calendar class   
	        this.departureDate = sdf.format(calendar1.getTime());
	    }   


	    public int getReservationNumber() {
	        return reservationNumber;
	    }

	    public int getNumberOfPassenger() {
	        return numberOfPassenger;
	    }

//	    public void getPassengers() {
//	        
//	        for(int i=0; i<passengers.length; i++){
//	            System.out.println(passengers[i]);
//	        }
//	        
//	    }

//	     public Passenger[] getPassengersArray() {
//	        
//	        return passengers;
//	    }
	

	    public String getDepartureDate() {
	        return departureDate;
	    }
	    
	 

	    public SeatClass getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(SeatClass seatClass) {
		this.seatClass = seatClass;
	}

		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

		public double getTotalPrice(){
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		
		this.totalPrice = totalPrice;
	}

		public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

		@Override
		public String toString() {
			return "Reservation [id=" + id + ", reservationNumber=" + reservationNumber + ", numberOfPassengers="
					+ numberOfPassenger + ", departureDate=" + departureDate + ", reservedSeats=" + seat
					+ ", seatClass=" + seatClass + ", totalPrice=" + totalPrice + ", passenger=" + passenger
					+ ", flight=" + flight + ", foods=" + foods + "]";
		}

		public List<Food> getFoods() {
			return foods;
		}

		public void setFoods(List<Food> foods) {
			this.foods = foods;
		}

		public Seat getSeat() {
			return seat;
		}

		public void setSeat(Seat seat) {
			this.seat = seat;
		}

	
	    
	    
	}
