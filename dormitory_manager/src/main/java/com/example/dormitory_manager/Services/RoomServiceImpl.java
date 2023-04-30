package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.Repository.RoomRepository;
import com.example.dormitory_manager.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Iterable<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    public Optional<Room> getOne(Long id) {
        return roomRepository.findById(id);
    }

    @Override
    public Room save(Room roomImage) {
        return roomRepository.save(roomImage);
    }

    @Override
    public Room delete(Long id) {
        return null;
    }
}
