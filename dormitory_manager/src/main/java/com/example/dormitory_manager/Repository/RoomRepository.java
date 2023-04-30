package com.example.dormitory_manager.Repository;

import com.example.dormitory_manager.entities.Room;
import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository<Room,Long> {
}
