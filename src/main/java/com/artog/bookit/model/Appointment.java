package com.artog.bookit.model;


//import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity // ✅ This marks it as a JPA entity
@Table(name = "appoint") // ✅ Matches the database table name
public class Appointment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Auto-increment ID
    private Long id;

   /* private String clientName;
    private String appointmentDate;
    private String name;
    private String description;
 */
   
	private String date;
    private String timeslot;
    private String token;
    // Constructor
    public Appointment(Long id,String date, String timeslot,String token) {
        this.id = id;
		this.date = date;
		this.timeslot = timeslot;
		this.token = token;
    }

    // Default constructor (needed for frameworks like Jackson)
	//// Default constructor (required for JSON deserialization)
    public Appointment() {
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for date
    public String getDate() {
        return date;
    }

    // Setter for date
    public void setDate(String date) {
        this.date = date;
    }

    // Getter for timeslot
    public String getTimeslot() {
        return timeslot;
    }

    // Setter for timeslot
    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }
	// Getter for token
    public String getToken() {
        return token;
    }

    // Setter for token
    public void setToken(String token) {
        this.token = token;
    }


}
