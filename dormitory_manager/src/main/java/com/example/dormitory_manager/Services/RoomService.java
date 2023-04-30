package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.entities.Room;

import java.util.Optional;

public interface RoomService {
    Iterable<Room> getAll();
    Optional<Room> getOne(Long id);
    Room save(Room room);
    Room delete(Long id);

    Iterable<Room> findAllByDomId(long id);

    Boolean deleteById(Long id);


}
