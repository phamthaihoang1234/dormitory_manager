package com.example.dormitory_manager.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dormitory_manager.Repository.RoomRepository;
import com.example.dormitory_manager.entities.Room;

@Service
public class RoomService {
    @Autowired private RoomRepository repo;
    public List<Room> listAll() {
        return (List<Room>) repo.findAll();
    }

    public void save(Room room) {
        repo.save(room);
    }

    public Room get(Long id) throws RoomNotFoundException {
        Optional<Room> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new RoomNotFoundException("Room not found");        
    }

    public void delete(Long id) throws RoomNotFoundException {
        Long count = repo.countById(id);
        if (count == 0 || count == null) {
            throw new RoomNotFoundException("Room not found");
        }
        repo.deleteById(id);
    }
}
