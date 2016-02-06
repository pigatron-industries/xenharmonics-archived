package com.pigatron.xen.domain.state;

import com.pigatron.xen.domain.entity.ControlVoltage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OutputControlVoltageState
{
    @Value("${xen.controlvoltage.output.size}")
    private int controlVoltageOutputNumber;


    private ControlVoltage[] controlVoltages;


    public OutputControlVoltageState() {
        controlVoltages = new ControlVoltage[controlVoltageOutputNumber];
    }

    public void setOutputVoltage(int outputId, ControlVoltage controlVoltage) {
        controlVoltages[outputId] = controlVoltage;
    }

    public ControlVoltage[] getControlVoltages()
    {
        return controlVoltages;
    }

    public void setControlVoltages(ControlVoltage[] controlVoltages)
    {
        this.controlVoltages = controlVoltages;
    }
}
