package com.artog.bookit.controller;

import com.artog.bookit.model.Appointment;
import com.artog.bookit.service.BookitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/booking")
public class BookitController {

    @Autowired
    private BookitService bookitService;

    @GetMapping("/day/{date}")
    public List<Appointment> getBookingsByDay(@PathVariable String date) {
        return bookitService.getBookingsByDay(date);
    }

    @GetMapping("/month/{month}")
    public Set<String> getBookingsByMonth(@PathVariable String month) {
        return bookitService.getBookingsByMonth(month);
    }

    @PostMapping("/add")
    public Appointment addBooking(@RequestBody Appointment appointment) {
        return bookitService.setBooking(appointment);
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointments() {
        return bookitService.getAllAppointments();
    }
}

