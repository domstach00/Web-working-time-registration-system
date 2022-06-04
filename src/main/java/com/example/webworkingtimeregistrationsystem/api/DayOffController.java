package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.DayOff;
import com.example.webworkingtimeregistrationsystem.service.DayOffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/v1/day-off")
@RestController
public class DayOffController {
    private final DayOffService dayOffService;

    @Autowired
    public DayOffController(DayOffService dayOffService) {
        this.dayOffService = dayOffService;
    }

    @PostMapping
    public boolean insertDayOff(@RequestBody DayOff dayOff) {
        return this.dayOffService.insertDayOff(dayOff);
    }

    @GetMapping("all")
    public List<DayOff> selectDayOff(@RequestParam(required = false) String startDateInput,
                                     @RequestParam(required = false) String endDateInput) {

        if (startDateInput == null && endDateInput == null)
            return this.dayOffService.selectDayOff();

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

        return this.dayOffService.selectDayOff(
                startDate,
                endDate
        );
    }

    @GetMapping
    public DayOff selectDayOff(@RequestParam int id){
        return this.dayOffService.selectDayOff(id);
    }
}
