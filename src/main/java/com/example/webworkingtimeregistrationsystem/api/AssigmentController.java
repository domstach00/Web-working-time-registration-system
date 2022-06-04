package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.Assigment;
import com.example.webworkingtimeregistrationsystem.service.AssigmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/v1/assigment")
@RestController
public class AssigmentController {
    private final AssigmentService assigmentService;

    @Autowired
    public AssigmentController(AssigmentService assigmentService) {
        this.assigmentService = assigmentService;
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public boolean insertAssigment(@RequestBody Assigment assigment) {
        return this.assigmentService.insertAssigment(assigment);
    }

    @GetMapping("all")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<Assigment> selectAssigments(@RequestParam(required = false) String startDateInput,
                                            @RequestParam(required = false) String endDateInput){

        if (startDateInput == null && endDateInput == null)
            return this.assigmentService.selectAssigments();

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
        return this.assigmentService.selectAssigments(
                startDate,
                endDate
        );
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8080")
    public Assigment selectAssigment(@RequestParam int id) {
        return this.assigmentService.selectAssigments(id);
    }

    @PostMapping("update-state")
    @CrossOrigin(origins = "http://localhost:8080")
    public boolean updateState(@RequestParam int id) {
        return this.assigmentService.updateState(id);
    }
}
