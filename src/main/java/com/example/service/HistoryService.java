package com.example.service;

import com.example.model.History;
import com.example.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {
    @Autowired
    HistoryRepository historyRepository;

    public List<History> listAllPatientHistory(Long patientId) {
        return historyRepository.findByPatientId(patientId);
    }
}
