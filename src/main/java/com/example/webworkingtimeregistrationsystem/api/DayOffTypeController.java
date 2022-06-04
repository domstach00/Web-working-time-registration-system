package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.model.DayOffType;
import com.example.webworkingtimeregistrationsystem.service.DayOffTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/day-off-type")
@RestController
public class DayOffTypeController {
    private final DayOffTypeService dayOffTypeService;

    public DayOffTypeController(DayOffTypeService dayOffTypeService) {
        this.dayOffTypeService = dayOffTypeService;
    }

    @PostMapping
    public boolean insertDayOffType(@RequestBody DayOffType dayOffType) {
        return this.dayOffTypeService.insertDayOffType(dayOffType);
    }

    @GetMapping("all")
    public List<DayOffType> selectDayOffType() {
        return this.dayOffTypeService.selectDayOffType();
    }

    @GetMapping
    public DayOffType selectDayOffType(@RequestParam int id) {
        return this.dayOffTypeService.selectDayOffType(id);
    }
}
