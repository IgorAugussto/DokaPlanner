package com.doka.organizer.controller;

import com.doka.organizer.entity.Room;
import com.doka.organizer.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    // Criar uma nova sala
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.createRoom(room);
    }

    // Listar todas as salas
    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // Buscar uma sala pelo ID
    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + id));
    }

    // Atualizar uma sala
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room updatedRoom) {
        return roomService.updateRoom(id, updatedRoom)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + id));
    }

    // Deletar uma sala
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Long id) {
        if (roomService.deleteRoom(id)) {
            return "Room with id " + id + " has been deleted.";
        }
        return "Room not found with id " + id;
    }
}
