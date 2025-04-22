package com.nikhil.springboot.MediConnect.repository;

import com.nikhil.springboot.MediConnect.entity.BookingInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingInventoryRepository extends JpaRepository<BookingInventory, Long> {
}
