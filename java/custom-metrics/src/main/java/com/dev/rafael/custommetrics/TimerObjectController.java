package com.dev.rafael.custommetrics;


import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TimerObjectController {

    private final Timer timer;

    public TimerObjectController(@Qualifier("TimerObjectControllerBean") SimpleMeterRegistry simpleMeterRegistry) {
        timer = simpleMeterRegistry.timer("greetings.timer");
    }

    @GetMapping("/hello")
    public String hello() {
        Timer.Sample sample = Timer.start();

        int threadSleepTime = new Random().nextInt(2500);
        try {
            System.out.println("Doing some work");
            Thread.sleep(threadSleepTime);
        } catch (Exception e) {
            System.err.println("error");
        }

        double responseTimeInMilliSeconds = timer.record(() -> sample.stop(timer) / 1000000);

        System.out.println("Greetings API thread sleep time: " + threadSleepTime + " ms");
        System.out.println("Greetings API response time: " + responseTimeInMilliSeconds + " ms");

        return "Request Duration: " + responseTimeInMilliSeconds;
    }

}
