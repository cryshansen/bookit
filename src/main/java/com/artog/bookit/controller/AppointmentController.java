package com.artog.simple.controller;



import com.artog.simple.model.Appointment;
import com.artog.simple.service.BookitService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Optional;


import java.util.Random;
import java.util.Set;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;



@CrossOrigin(origins = "*") // Allow all origins (change * to specific domains if needed)
@RestController
@RequestMapping("/api/appoint")
public class AppointmentController {
	private String today = "2025-03-21"; //new Date();	private String today = "2025-03-07"; //new Date();
    // Simulating a database with a list
    private List<Appointment> items = new ArrayList<>();
	@Autowired
	private final BookitService bookitService;
    // Constructor to add sample data
    public AppointmentController(BookitService bookitService) {
		/* new service instead todo */
		this.bookitService = bookitService;
		//mock data test 
		items.add(new Appointment(1L, "Item 1", "Description of Item 1","2025-03-27 13:00:00","13:00","token"));
        items.add(new Appointment(2L, "Item 2", "Description of Item 2","2025-03-26 16:00:00","16:00:0","token"));
    
    }

    // GET endpoint to fetch all items
    @GetMapping("/list")
    public List<Appointment> getItems() {
        return items;
    }
	@GetMapping("/first-available")
	public ResponseEntity<List<Appointment>> getFirstAvailable() {
		List<Appointment> availableAppointments = bookitService.getFirstAvailable();
		if (availableAppointments.isEmpty()) {
			return ResponseEntity.noContent().build(); // Return 204 if no appointment available
		}
		return ResponseEntity.ok(availableAppointments);
	}

	@GetMapping("/first-avail-day")
    public ResponseEntity<String> getFirstAvailableDay() {
        return ResponseEntity.ok(today);
    }
    // GET endpoint to fetch a specific item by ID
    @GetMapping("/{id}")
    public Appointment getItemById(@PathVariable Long id) {
        return items.stream().filter(item -> item.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

	// Get all appointments for a specific day
    @GetMapping("/day/{date}")
    public List<Appointment> getBookingsByDay(@PathVariable String date) {
        try {
            // Call service to get available appointments for the given date
            return bookitService.getBookingsByDay(date);
        } catch (Exception e) {
            // Log error (optional) and return an empty list
            System.err.println("Error fetching appointments: " + e.getMessage());
            return List.of(); // Returning an empty list instead of null
        }
    }
	// Get all appointments for a specific day
    @GetMapping("/month/{month}")
    public Set<String> getBookingsByMonth(@PathVariable String month) {
        try {
            // Call service to get available appointments for the given date
            return bookitService.getBookingsByMonth(month);
        } catch (Exception e) {
            // Log error (optional) and return an empty list
            System.err.println("Error fetching appointments: " + e.getMessage());
            return Collections.emptySet(); // Returning an empty list instead of null
        }
    }
// Add a new appointment
    @PostMapping("/add")
    public ResponseEntity<Map<String,Object>> setBooking(@RequestBody Appointment appointment) {

		if (appointment == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Invalid appointment data");
            return ResponseEntity.ok(response);
        }
        bookitService.setBooking(appointment);
		//int confirmationNo = makeConfirmationNo();
		// Generate a 15-digit random number
        long confirmationNumber = (long) (Math.random() * 9_000_000_000_000_000L) + 1_000_000_000_000_000L;
		System.out.println("abc");
		// Create a response object
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Appointment added successfully");
        response.put("confirmationNumber", confirmationNumber);
        return ResponseEntity.ok(response);
    }
	
	// GET endpoint to fetch all items
	@GetMapping("/avail")
	public String getSettings(){
		return this.today;
	}
 	@GetMapping("/dashboard")
    public String showDashboard(@AuthenticationPrincipal OAuth2User principal) {
        if (principal != null) {
            // You can now access the user's details
            String username = principal.getAttribute("name");  // For example, accessing the name attribute
            String email = principal.getAttribute("email");  // Email from OAuth2 provider
            System.out.println("User: " + username + ", Email: " + email);
        }

        return "dashboard";  // Your dashboard view
    }



/*
private void sendOutput(String data, HttpServletResponse response, String contentType, int status) {
    response.setContentType(contentType);
    response.setStatus(status);
    try {
        response.getWriter().write(data);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
*/
/**
 * obsolete
 * @return
 */
	protected int makeConfirmationNo() {
		int min = 3;
		int max = 8;
	
		Random random = new Random();
		int randomnumber = random.nextInt(max - min + 1) + min;

		/*var min=3;
        var max = 8;
        var randomnumber = Math.floor(Math.random() * (max - min + 1)) + min;
        var randomnumber = Math.random() * (max - min + 1) + min;
        const myArr = randomnumber.toString().split(".");
        const num = myArr[1]; */
		System.out.println(randomnumber + "<-- make confirmation no");
		return randomnumber;
	}
	



}
