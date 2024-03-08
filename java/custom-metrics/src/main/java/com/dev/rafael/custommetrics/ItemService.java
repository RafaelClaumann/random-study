package com.dev.rafael.custommetrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ItemService {

    private static int bookOrderId = 0;
    private static int movieOrderId = 0;

    private final Counter bookCounter;
    private final Counter movieCounter;
    private AtomicInteger activeUsers;

    public ItemService(CompositeMeterRegistry meterRegistry) {
        bookCounter = meterRegistry.counter("order.books");
        movieCounter = meterRegistry.counter("order.movies");
        activeUsers = meterRegistry.gauge("number.of.active.users", new AtomicInteger(0));

        activeUsers.set(new Random().nextInt());
    }

    public Number fetchActiveUsers() {
        return 5;
    }

    public String orderBook() {
        bookOrderId += 1;
        bookCounter.increment();
        return "Ordered Book with id = " + bookOrderId;
    }

    public String orderMovie() {
        movieOrderId += 1;
        movieCounter.increment();
        return "Ordered Movie with id = " + movieOrderId;
    }

}
