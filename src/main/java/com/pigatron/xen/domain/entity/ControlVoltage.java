package com.pigatron.xen.domain.entity;

public class ControlVoltage {

    private static final float MAX_FLOAT_VALUE = 10;
    private static final float MIN_FLOAT_VALUE = 0;

    private static final float MAX_BINARY_VALUE = 65535;
    private static final float MIN_BINARY_VALUE = 0;

    private static final float RANGE_FLOAT = MAX_FLOAT_VALUE - MIN_FLOAT_VALUE;
    private static final float RANGE_BINARY = MAX_BINARY_VALUE - MIN_BINARY_VALUE;


    private int intValue;
    private float floatValue;
    private byte[] byteValue = new byte[2];


    public ControlVoltage() {
        this(0);
    }

    public ControlVoltage(float floatValue) {
        this.floatValue = floatValue;
        calcIntValue();
        calcByteValue();
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
        calcFloatValue();
        calcByteValue();
    }

    public int getIntValue() {
        return intValue;
    }

    public void setFloatValue(float floatValue) {
        this.floatValue = floatValue;
        calcIntValue();
        calcByteValue();
    }

    public float getFloatValue() {
        return floatValue;
    }

    public byte[] getByteValue() {
        return byteValue;
    }


    private void calcFloatValue() {
        floatValue = (((intValue - MIN_BINARY_VALUE) * RANGE_FLOAT) / RANGE_BINARY) + MIN_FLOAT_VALUE;
    }

    private void calcIntValue() {
        intValue = (int)((((floatValue - MIN_FLOAT_VALUE) * RANGE_BINARY) / RANGE_FLOAT) + MIN_BINARY_VALUE);
    }

    private void calcByteValue() {
        byteValue[0] = (byte)intValue;
        byteValue[1] = (byte)(intValue >>> 8);
    }
}
