package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.service.DayOffTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/day-off-type")
@RestController
public class DayOffTypeController {
    private final DayOffTypeService dayOffTypeService;

    public DayOffTypeController(DayOffTypeService dayOffTypeService) {
        this.dayOffTypeService = dayOffTypeService;
    }

    // TODO: DayOffTypeController
}
