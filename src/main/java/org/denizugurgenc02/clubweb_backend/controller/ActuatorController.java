package org.denizugurgenc02.clubweb_backend.controller;

import org.denizugurgenc02.clubweb_backend.model.HealthModel;
import org.denizugurgenc02.clubweb_backend.model.InfoModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/actuator")
public class ActuatorController {
    @GetMapping(path = "/health")
    public HealthModel healthModel() {
        return new HealthModel("OK.");
    }

    @GetMapping(path = "/info")
    public InfoModel infoModel() {
        return new InfoModel("0.0.1");
    }
}
