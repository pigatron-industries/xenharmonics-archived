package com.pigatron.xen.service;

import com.pi4j.wiringpi.Shift;
import com.pigatron.xen.domain.entity.ControlVoltage;
import com.pigatron.xen.domain.entity.Note;
import com.pigatron.xen.domain.entity.Scale;
import com.pigatron.xen.domain.entity.ApplicationState;
import com.pigatron.xen.domain.entity.OutputControlVoltages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OutputControlVoltageService {

    @Value("${xen.controlvoltage.output.size}")
    private int outputSize;

    @Value("${xen.controlvoltage.output.datapin}")
    private byte dataPin;

    @Value("${xen.controlvoltage.output.clockpin}")
    private byte clockPin;

    private OutputControlVoltages outputControlVoltages;

    @Autowired
    private ApplicationStateService applicationStateService;


    public ControlVoltage getControlVoltage(Scale scale, Note note) {
        float voltage = ((note.getOctaveNumber() * scale.getOctaveCents()) / 1200) + scale.getCents().get(note.getNoteNumber());
        return new ControlVoltage(voltage);
    }

    public ControlVoltage getControlVoltageForSelectedScale(Note note) {
        return getControlVoltage(applicationStateService.getSelectedScale(), note);
    }

    public void setOutputVoltage(int outputId, ControlVoltage controlVoltage) {
        outputControlVoltages.setOutputVoltage(outputId, controlVoltage);
    }

    public void shiftOutControlVoltages() {
        for(ControlVoltage controlVoltage : outputControlVoltages.getControlVoltages()) {
            byte[] value = controlVoltage.getByteValue();
            Shift.shiftOut(dataPin, clockPin, (byte)Shift.MSBFIRST, value[0]);
            Shift.shiftOut(dataPin, clockPin, (byte)Shift.MSBFIRST, value[1]);
        }
    }

}
