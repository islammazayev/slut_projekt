package se.slut_projekt_Lexicon.slut_projekt.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String seatID;    
    private boolean status; //shows whether a seat is booked or not; true if reserved
  
	
    
    //constructor01
    public Seat() {
    	
    }
     
    //constructor02
    public Seat(String seatID, boolean status) {
        this.seatID = seatID;
        this.status = status;
        
    }

  
    public void setStatus(boolean status) {
        this.status = status;
    }
    
    public String getSeatID() {       
        return seatID;
    }

    public boolean isStatus() {
       return status;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	@Override
	public String toString() {
		return "Seat [id=" + id + ", seatID=" + seatID + ", status=" + status + "]";
	}
    
    
    
    
}
