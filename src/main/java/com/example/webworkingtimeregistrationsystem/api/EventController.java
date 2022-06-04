package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.Event;
import com.example.webworkingtimeregistrationsystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @CrossOrigin(origins = "http://localhost:8080")
    public boolean insertEvent(@RequestBody Event event) {
        return eventService.insertEvent(event);
    }

    @GetMapping("all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Event> selectEvents(@RequestParam(required = false) String startDateInput,
                                    @RequestParam(required = false) String endDateInput) {
        if (startDateInput == null && endDateInput == null)
            return this.eventService.selectEvents();

        Date startDate;
        Date endDate;

        if (startDateInput != null)
            startDate = DataSource.dateFromStrDate(startDateInput);
        else {
            startDate = new Date();
            startDate.setTime(0L);
        }

        if (endDateInput != null)
            endDate = DataSource.dateFromStrDate(endDateInput);
        else {
            endDate = new Date();
            endDate.setTime(Long.MAX_VALUE);
        }

        return this.eventService.selectEvents(
                startDate,
                endDate
        );
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public Event selectEvent(@RequestParam int id) {
        return this.eventService.selectEvent(id);
    }
}
