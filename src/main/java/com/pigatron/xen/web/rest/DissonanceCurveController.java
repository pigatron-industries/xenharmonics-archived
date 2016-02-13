package com.pigatron.xen.web.rest;

import com.pigatron.xen.domain.entity.DissonanceCurve;
import com.pigatron.xen.domain.repository.DissonanceCurveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/dissonanceCurve", produces = MediaType.APPLICATION_JSON_VALUE)
public class DissonanceCurveController extends AbstractRestController<DissonanceCurve, String> {

    @Autowired
    public DissonanceCurveController(DissonanceCurveRepository dissonanceCurveRepository) {
        super(dissonanceCurveRepository, "name");
    }


}
