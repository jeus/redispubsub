package com.samplemark.receiver;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    /**
     * this method called by listenerAdapter in Application.
     * @param message
     */
    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">"+latch.getCount());
        latch.countDown();
    }


    public void receiveMessage1(String message) {
        LOGGER.info("Received <" + message + ">"+latch.getCount());
        latch.countDown();
    }
}
