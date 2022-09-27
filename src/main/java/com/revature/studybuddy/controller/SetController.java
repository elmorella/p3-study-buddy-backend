package com.revature.studybuddy.controller;

import com.revature.studybuddy.entity.Set;
import com.revature.studybuddy.service.SetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/set")
public class SetController {
    private final SetService setService;

    public SetController(SetService setService) {this.setService = setService;}

    @GetMapping("/all")
    public ResponseEntity<List<Set>> getAllSet(){
        List<Set> sets = setService.getAllSets();
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Set> getSetById(@PathVariable("id") Long id){
        Set setById = setService.getSetById(id);
        return new ResponseEntity<>(setById, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Set> addSet(@RequestBody Set newSet){
        Set returnSet = setService.addSet(newSet);
        return new ResponseEntity<>(returnSet, HttpStatus.CREATED);
    }
    @GetMapping("/{keyword}")
    public ResponseEntity<List<Set>> searchSets(@PathVariable("keyword") String keyword){
        List<Set> sets = setService.search(keyword);
        return new ResponseEntity<>(sets, HttpStatus.OK);
    }
}
