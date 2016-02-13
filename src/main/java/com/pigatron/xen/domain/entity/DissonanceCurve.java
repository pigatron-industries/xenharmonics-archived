package com.pigatron.xen.domain.entity;

import org.springframework.data.annotation.Id;

import java.util.Map;

public class DissonanceCurve {

    @Id
    private String id;

    private String name;

    private Map<Float, String> markers;

    private Map<Float, Float> dissonanceCurve;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Float, String> getMarkers() {
        return markers;
    }

    public void setMarkers(Map<Float, String> markers) {
        this.markers = markers;
    }

    public Map<Float, Float> getDissonanceCurve() {
        return dissonanceCurve;
    }

    public void setDissonanceCurve(Map<Float, Float> dissonanceCurve) {
        this.dissonanceCurve = dissonanceCurve;
    }
}
