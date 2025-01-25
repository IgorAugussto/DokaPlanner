package com.doka.organizer.service;

import com.doka.organizer.entity.Room;
import com.doka.organizer.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    // Criar uma nova sala
    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    // Listar todas as salas
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // Buscar uma sala pelo ID
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }

    // Atualizar uma sala
    public Optional<Room> updateRoom(Long id, Room updatedRoom) {
        return roomRepository.findById(id).map(room -> {
            room.setName(updatedRoom.getName());
            return roomRepository.save(room);
        });
    }

    // Deletar uma sala
    public boolean deleteRoom(Long id) {
        if (roomRepository.existsById(id)) {
            roomRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
