package com.pigatron.xen.domain.entity;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Scale {

    @Id
    private String id;

    @NotNull
    private String name;

    private String notes;

    @NotNull
    private List<Float> cents;


    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Float> getCents()
    {
        return cents;
    }

    public void setCents(List<Float> cents)
    {
        this.cents = cents;
    }

    public float getOctaveCents() {
        return cents.get(cents.size()-1);
    }
}
