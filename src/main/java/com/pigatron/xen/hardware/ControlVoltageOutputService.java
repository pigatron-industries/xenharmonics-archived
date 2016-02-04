package com.pigatron.xen.hardware;


import com.pigatron.xen.domain.entity.ControlVoltage;
import org.springframework.beans.factory.annotation.Value;

public class ControlVoltageOutputService {

    @Value("${xen.controlvoltage.outputs.num}")
    private int controlVoltageOutputNumber;

    private ControlVoltage[] controlVoltages;


    public ControlVoltageOutputService() {
        controlVoltages = new ControlVoltage[controlVoltageOutputNumber];
    }

    public void setOutputVoltage(int outputId, ControlVoltage controlVoltage) {
        controlVoltages[outputId] = controlVoltage;
    }

    public void shiftOutVoltages() {
        //TODO shift voltages out to DACS
    }

}
