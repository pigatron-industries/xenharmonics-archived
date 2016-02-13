package com.pigatron.xen.service;

import com.pigatron.xen.domain.entity.ApplicationState;
import com.pigatron.xen.domain.entity.Scale;
import com.pigatron.xen.domain.repository.ApplicationStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationStateService {

    private ApplicationStateRepository applicationStateRepository;

    private ApplicationState applicationState;

    @Autowired
    ApplicationStateService(ApplicationStateRepository applicationStateRepository) {
        this.applicationStateRepository = applicationStateRepository;
        load();
    }

    public ApplicationState load() {
        List<ApplicationState> applicationStates = applicationStateRepository.findAll();
        if(applicationStates.size() == 0) {
            applicationState = new ApplicationState();
        } else if(applicationStates.size() == 1) {
            applicationState = applicationStates.get(0);
        } else {
            applicationState = applicationStates.get(0);
            applicationStateRepository.deleteAll();
        }
        return applicationState;
    }

    public void save() {
        applicationStateRepository.save(applicationState);
    }

    public void setSelectedScale(Scale scale) {
        applicationState.setSelectedScale(scale);
        save();
    }

    public Scale getSelectedScale() {
        return applicationState.getSelectedScale();
    }

}
