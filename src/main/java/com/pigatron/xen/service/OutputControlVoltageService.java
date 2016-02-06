package com.pigatron.xen.service;

import com.pi4j.wiringpi.Shift;
import com.pigatron.xen.domain.entity.ControlVoltage;
import com.pigatron.xen.domain.entity.Note;
import com.pigatron.xen.domain.entity.Scale;
import com.pigatron.xen.domain.state.OutputControlVoltageState;
import com.pigatron.xen.domain.state.SelectedScale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OutputControlVoltageService {

    @Value("{xen.controlvoltage.output.datapin}")
    byte dataPin;

    @Value("{xen.controlvoltage.output.clockpin}")
    byte clockPin;

    @Autowired
    private OutputControlVoltageState outputControlVoltageState;

    @Autowired
    private SelectedScale selectedScale;


    public ControlVoltage getControlVoltage(Scale scale, Note note) {
        float voltage = ((note.getOctaveNumber() * scale.getOctaveCents()) / 1200) + scale.getCents().get(note.getNoteNumber());
        return new ControlVoltage(voltage);
    }

    public ControlVoltage getControlVoltageForSelectedScale(Note note) {
        return getControlVoltage(selectedScale.getScale(), note);
    }

    public void setOutputVoltage(int outputId, ControlVoltage controlVoltage) {
        outputControlVoltageState.setOutputVoltage(outputId, controlVoltage);
    }

    public void shiftOutControlVoltages() {
        for(ControlVoltage controlVoltage : outputControlVoltageState.getControlVoltages()) {
            byte[] value = controlVoltage.getByteValue();
            Shift.shiftOut(dataPin, clockPin, (byte)Shift.MSBFIRST, value[0]);
            Shift.shiftOut(dataPin, clockPin, (byte)Shift.MSBFIRST, value[1]);
        }
    }

}
