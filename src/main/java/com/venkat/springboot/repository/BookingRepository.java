package com.venkat.springboot.repository;

import com.venkat.springboot.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BookingRepository extends MongoRepository<Booking, Long> {

    public Booking findByDeparture(String departure);
}
