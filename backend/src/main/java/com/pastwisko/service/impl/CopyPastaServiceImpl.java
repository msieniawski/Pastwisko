package com.pastwisko.service.impl;

import com.pastwisko.model.CopyPasta;
import com.pastwisko.model.Tag;
import com.pastwisko.repository.CopyPastaRepository;
import com.pastwisko.service.CopyPastaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyPastaServiceImpl implements CopyPastaService {

    private final CopyPastaRepository copyPastaRepository;

    @Autowired
    public CopyPastaServiceImpl(CopyPastaRepository copyPastaRepository) {
        this.copyPastaRepository = copyPastaRepository;
    }

    @Override
    public List<CopyPasta> listAll() {
        return copyPastaRepository.findAll();
    }

    @Override
    public CopyPasta getById(int id) {
        return copyPastaRepository.findOne(id);
    }

    @Override
    public CopyPasta saveOrUpdate(CopyPasta copyPasta) {
        return copyPastaRepository.save(copyPasta);
    }

    @Override
    public void delete(int id) {
        copyPastaRepository.delete(id);
    }

    @Override
    public List<CopyPasta> findByTag(int id) {
        return listAll().stream()
                .filter(cp -> cp.getTags().stream().filter(t -> (t.getId() == id)).count() > 0)
                .collect(Collectors.toList());
    }
}
