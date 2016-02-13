package com.pigatron.xen.domain.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public class OutputControlVoltages
{

    private ControlVoltage[] controlVoltages;


    public OutputControlVoltages(int size) {
        controlVoltages = new ControlVoltage[size];
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
