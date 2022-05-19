package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.model.Event;
import com.example.webworkingtimeregistrationsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/event")
@RestController
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public void insertEvent(@RequestBody Event event) {
        eventService.insertEvent(event);
    }

    @GetMapping("all")
    public List<Event> getAllEvents() {
        return eventService.selectEvents();
    }
}
