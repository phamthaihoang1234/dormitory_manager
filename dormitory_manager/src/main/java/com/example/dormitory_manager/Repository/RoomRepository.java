package com.example.dormitory_manager.Repository;

import com.example.dormitory_manager.entities.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room,Long> {
    @Query(value = "SELECT * FROM rooms where dom_id = ?1 AND cancelled = 1", nativeQuery = true)
    Iterable<Room> findAllRoomByDomId(long id);

    Optional<Room> findById(Long id);
}
