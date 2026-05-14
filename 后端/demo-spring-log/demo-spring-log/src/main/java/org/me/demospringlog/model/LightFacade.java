package org.me.demospringlog.model;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LightFacade {
    private LivingRoomLight livingRoomLight = new LivingRoomLight();
    private HallWayLight hallWayLight = new HallWayLight();
    private DiningRoomLight diningRoomLight = new DiningRoomLight();

    @PostConstruct
    public void turnOnAllLights() {
        livingRoomLight.on();
        hallWayLight.on();
        diningRoomLight.on();
    }

    @PostConstruct
    public void turnOffAllLights() {
        livingRoomLight.off();
        hallWayLight.off();
        diningRoomLight.off();
    }

}
