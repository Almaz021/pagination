package ru.itis.fisd.service;

import ru.itis.fisd.model.Profession;
import ru.itis.fisd.repository.ProfessionRepository;

import java.util.List;

public class ProfessionService {
    private final ProfessionRepository repository;

    public ProfessionService() {
        repository = new ProfessionRepository();
    }

    public List<Profession> findByName(String name, int limit, int offset) {
        return repository.findByName(name, limit, offset);
    }

    public Integer countResults(String name) {
        return repository.countResults(name);
    }
}