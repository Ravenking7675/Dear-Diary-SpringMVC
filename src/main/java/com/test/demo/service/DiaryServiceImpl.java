package com.test.demo.service;

import com.test.demo.model.Diary;
import com.test.demo.repository.DiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    DiaryRepository diaryRepository;

    @Override
    public List<Diary> findAll() {
        return diaryRepository.findAll();
    }

    @Override
    public Diary save(Diary diary) {
        diaryRepository.save(diary);
        return diary;
    }

    @Override
    public Diary findById(long id) {
        if(diaryRepository.findById(id).isPresent()){
            return diaryRepository.findById(id).get();
        }
        else
            return null;
    }

    @Override
    public void delete(long id) {
        Diary diary = diaryRepository.findById(id).get();
        diaryRepository.delete(diary);
    }
}
