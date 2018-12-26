package com.wadedwyane.www.service;

import com.wadedwyane.www.entity.Project;
import com.wadedwyane.www.impl.IProjectService;
import com.wadedwyane.www.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class ProjectService implements IProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void insertProject(Project project) {
        projectRepository.save(project);
    }
}
