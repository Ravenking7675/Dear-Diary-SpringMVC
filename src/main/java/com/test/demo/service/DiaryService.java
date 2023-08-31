package com.test.demo.service;

import com.test.demo.model.Diary;

import java.util.List;

public interface DiaryService {

    List<Diary> findAll();

    Diary save(Diary diary);

    Diary findById(long id);

    void delete(long id);

}
