package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.service.DayOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/day-off")
@RestController
public class DayOffController {
    private final DayOffService dayOffService;

    @Autowired
    public DayOffController(DayOffService dayOffService) {
        this.dayOffService = dayOffService;
    }

    // TODO: DayOffController
}
