package com.duroop.dodom.domain.visit.controller;

import com.duroop.dodom.domain.visit.entity.Visits;
import com.duroop.dodom.domain.visit.service.VisitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
@RequiredArgsConstructor
public class VisitController {

    private final VisitService visitService;

    @PostMapping
    public ResponseEntity<?> addVisit(){

        Visits response = visitService.addVisitCount();

        return ResponseEntity.ok().body(response);
    }
}
