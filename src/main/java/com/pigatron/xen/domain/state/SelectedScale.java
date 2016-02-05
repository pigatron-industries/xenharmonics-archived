package com.pigatron.xen.domain.state;

import com.pigatron.xen.domain.entity.Scale;
import org.springframework.stereotype.Component;

@Component
public class SelectedScale
{
    private Scale selectedScale;

    public Scale getSelectedScale() {
        return selectedScale;
    }

    public void setSelectedScale(Scale selectedScale) {
        this.selectedScale = selectedScale;
    }
}
