package com.pigatron.xen.domain.state;

import com.pigatron.xen.domain.entity.Scale;
import org.springframework.stereotype.Component;

@Component
public class SelectedScale
{
    private Scale scale;

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }
}
