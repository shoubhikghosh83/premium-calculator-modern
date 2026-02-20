package com.insurance.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ApplicationIdGenerator {

    private final AtomicInteger counter = new AtomicInteger(1);

    public int nextId() {
        return counter.getAndIncrement();
    }
}
