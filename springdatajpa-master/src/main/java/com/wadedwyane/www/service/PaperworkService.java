package com.wadedwyane.www.service;

import com.wadedwyane.www.entity.PaperworkEntity;
import com.wadedwyane.www.impl.IPaperworkService;
import com.wadedwyane.www.repository.PaperworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class PaperworkService implements IPaperworkService {

    @Autowired
    PaperworkRepository paperworkRepository;

    @Override
    public void save(PaperworkEntity entity) {
        paperworkRepository.save(entity);
    }
}
