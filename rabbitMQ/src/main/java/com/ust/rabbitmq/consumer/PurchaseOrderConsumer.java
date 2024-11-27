package com.ust.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ust.rabbitmq.model.OrderStatus;

@Component
public class PurchaseOrderConsumer {

	@Value("$(ust.rabbitmq.queue)")
	String queuename;
	
	@Value("$(ust.rabbitmq.exchange)")
	String exchange;
	
	@Value("$(ust.rabbitmq.routingKey)")
	private String routingKey;
	
	
	@RabbitListener(queues = "ust_queue")
	public void consumerMessageFromQueue(OrderStatus orderStatus) {
		System.out.print("message recieved from queue : "+orderStatus);
	}
}
