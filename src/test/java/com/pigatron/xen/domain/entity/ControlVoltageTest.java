package com.pigatron.xen.domain.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class ControlVoltageTest {

    @Test
    public void testSetFloatValueMin() {
        ControlVoltage controlVoltage = new ControlVoltage();
        controlVoltage.setFloatValue(0);
        assertThat(controlVoltage.getIntValue()).isEqualTo(0);
        assertThat(Byte.toUnsignedInt(controlVoltage.getByteValue()[0])).isEqualTo(0);
        assertThat(Byte.toUnsignedInt(controlVoltage.getByteValue()[1])).isEqualTo(0);
    }

    @Test
    public void testSetFloatValueMax() {
        ControlVoltage controlVoltage = new ControlVoltage();
        controlVoltage.setFloatValue(10);
        assertThat(controlVoltage.getIntValue()).isEqualTo(65535);
        assertThat(Byte.toUnsignedInt(controlVoltage.getByteValue()[0])).isEqualTo(255);
        assertThat(Byte.toUnsignedInt(controlVoltage.getByteValue()[1])).isEqualTo(255);
    }

    @Test
    public void testSetIntValueMin() {
        ControlVoltage controlVoltage = new ControlVoltage();
        controlVoltage.setIntValue(0);
        assertThat(controlVoltage.getFloatValue()).isEqualTo(0);
    }

    @Test
    public void testSetIntValueMax() {
        ControlVoltage controlVoltage = new ControlVoltage();
        controlVoltage.setIntValue(65535);
        assertThat(controlVoltage.getFloatValue()).isEqualTo(10);
    }

}
