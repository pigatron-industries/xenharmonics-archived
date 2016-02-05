package com.pigatron.xen.service;

import com.pigatron.xen.domain.state.OutputControlVoltageState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutputControlVoltageService {

    @Autowired
    private OutputControlVoltageState outputControlVoltageState;

    public void shiftOutControlVoltages() {
        //TODO shift control voltages out to DAC
    }

}
