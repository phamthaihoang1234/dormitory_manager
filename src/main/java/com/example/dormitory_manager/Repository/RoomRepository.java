package com.example.dormitory_manager.Repository;


import org.springframework.data.repository.CrudRepository;


import com.example.dormitory_manager.entities.Room;

public interface RoomRepository extends CrudRepository<Room, Long>{
    public Long countById(Long id);
}
