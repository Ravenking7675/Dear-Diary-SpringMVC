package com.test.demo.controller;

import com.test.demo.model.Diary;
import com.test.demo.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    @GetMapping("/diary")
    public ResponseEntity<List<Diary>> get() {
        List<Diary> list = diaryService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/diary")
    public ResponseEntity<Diary> save(@RequestBody Diary diary) {
        Diary d = diaryService.save(diary);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @GetMapping("/diary/{id}")
    public ResponseEntity<Diary> save(@PathVariable Long id) {
        Diary d = diaryService.findById(id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping("/diary/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        diaryService.delete(id);
        return new ResponseEntity<String>("Diary is deleted successfully", HttpStatus.OK);
    }

}
