package com.example.webworkingtimeregistrationsystem.api;

import com.example.webworkingtimeregistrationsystem.datasource.DataSource;
import com.example.webworkingtimeregistrationsystem.model.Assigment;
import com.example.webworkingtimeregistrationsystem.service.AssigmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/assigment")
@RestController
public class AssigmentController {
    private final AssigmentService assigmentService;

    @Autowired
    public AssigmentController(AssigmentService assigmentService) {
        this.assigmentService = assigmentService;
    }

    @GetMapping
    public List<Assigment> getAllAssigments(){
        return assigmentService.selectAssigments();
    }

    @GetMapping("date")
    public List<Assigment> getAllAssigmentsWithDate(@RequestParam Optional<String> startDateInput,
                                                    @RequestParam Optional<String> endDateInput){

        Date startDate;
        Date endDate;
        if (startDateInput.isPresent()) {
            startDate = DataSource.dateFromStrDate(startDateInput.get());
        }
        else {
            startDate = new Date();
            startDate.setTime(0);
        }

        if (endDateInput.isPresent()) {
            endDate = DataSource.dateFromStrDate(endDateInput.get());
        }
        else {
            endDate = new Date();
            endDate.setTime(Long.MAX_VALUE);
        }
        return assigmentService.selectAssigments(
                startDate,
                endDate
        );
    }
}
