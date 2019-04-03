package com.venkat.springboot.controller;

import com.venkat.springboot.model.Booking;
import com.venkat.springboot.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/booking")
public class BookingController {


    public BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @GetMapping(value = "/create" )
    public Map<String, Object> createBookingRequest(Booking booking){
        try {
            System.out.println(booking.getTravelDate());
            booking = bookingRepository.save(booking);
            Map<String, Object> bookingInfo = new HashMap<>();
            bookingInfo.put("Status", "Success");
            bookingInfo.put("data", booking);
            return bookingInfo;
        }catch (Exception ex){
            Map<String, Object> bookingInfo = new HashMap<>();
            bookingInfo.put("Status", "fail");
            bookingInfo.put("aata", "Something went wrong please contact Admin");
            return bookingInfo;
        }
    }

    @GetMapping("/all")
    public Map<String, Object> createBookingRequest(){
        try {
            List<Booking> bookingList = bookingRepository.findAll();
            Map<String, Object> bookingInfo = new HashMap<>();
            bookingInfo.put("Status", "Success");
            bookingInfo.put("data", bookingList);
            return bookingInfo;
        }catch (Exception ex){
            Map<String, Object> bookingInfo = new HashMap<>();
            bookingInfo.put("Status", "fail");
            bookingInfo.put("aata", "Something went wrong please contact Admin");
            return bookingInfo;
        }
    }
}
