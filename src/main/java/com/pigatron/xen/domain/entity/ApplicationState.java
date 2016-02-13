package com.pigatron.xen.domain.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

public class ApplicationState {

    @DBRef
    private Scale selectedScale;

    public Scale getSelectedScale() {
        return selectedScale;
    }

    public void setSelectedScale(Scale selectedScale) {
        this.selectedScale = selectedScale;
    }

}
