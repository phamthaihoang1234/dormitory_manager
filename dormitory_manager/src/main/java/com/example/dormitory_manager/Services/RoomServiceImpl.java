package com.example.dormitory_manager.Services;

import com.example.dormitory_manager.Repository.RoomRepository;
import com.example.dormitory_manager.entities.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoomServiceImpl implements com.example.dormitory_manager.Services.RoomService {
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

    @Override
    public Iterable<Room> findAllByDomId(long id) {
        return roomRepository.findAllRoomByDomId(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        Optional<Room> home = roomRepository.findById(id);
        roomRepository.deleteById(id);
        return true;
    }



}
