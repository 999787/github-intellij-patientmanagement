package com.pm.billingservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import patient.events.PatientEvent;

@Component
public class kafkaConsumer {
    @KafkaListener(topics = "patient", groupId = "billing-service")
    public void consume(byte[] message)
            //This line is because the error of the parseFrom, so I added it
            throws InvalidProtocolBufferException {
        PatientEvent event = PatientEvent.parseFrom(message);

        System.out.println("Received: " + event);}



//    @KafkaListener(
//            topics = "patient",
//            groupId = "billing-service"
//    )
    public void consume(String message){
        System.out.println("Received: "+ message);
    }
}
