package com.Riwi.workshop.Controller;

import com.Riwi.workshop.Entities.Event;
import com.Riwi.workshop.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent (@RequestBody Event event){
        return new ResponseEntity<>(eventService.createEvent(event), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(){
        return new ResponseEntity<>(eventService.getAllEvents(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById (@PathVariable String id){
        return  eventService.getEventById(id)
                .map(event -> new ResponseEntity<>(event,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> modifyEvent(@PathVariable String id, @RequestBody Event event) {
        try {
            Event updatedEvent = eventService.modifyEvent(id, event);
            return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroyEvent (@PathVariable String id){
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
