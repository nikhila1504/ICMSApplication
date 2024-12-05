package gov.ga.sbwc.icms.common.util;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	public static final String DOCUMENT_EXCHANGE_NAME = "document.direct";
	public static final String QUEUE_NAME = "example-queue";
	public static final String DOCUMENT_ROUTING_KEY = "form";

	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(DOCUMENT_EXCHANGE_NAME);
	}

	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME, true);
	}

	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(DOCUMENT_ROUTING_KEY);
	}
}
