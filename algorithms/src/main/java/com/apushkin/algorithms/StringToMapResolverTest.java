package com.apushkin.algorithms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToMapResolverTest {

    private final StringToMapResolver resolver = new StringToMapResolver();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compute() {
        String output = resolver.composeResult("сапог сарай арбуз болт бокс биржа");
        assertEquals("[б=[биржа, бокс, болт], с=[сапог, сарай]]", output);
    }
}