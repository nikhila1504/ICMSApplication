package com.icms.party.service;

import org.apache.commons.lang.SerializationUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icms.party.dto.FormDTO;
import com.icms.party.repository.ConfigTypeRepository;
import com.icms.party.util.RabbitMQConfig;

@Service
public class DocumentQueueProducerImpl {
	@Autowired
	private RabbitTemplate docRabbitTemplate;

	@Autowired
	private ConfigTypeRepository configTypeRepository;

	public void pushForm(FormDTO formDto) {
		if (formDto != null) {
			byte[] bytes = SerializationUtils.serialize(formDto);

//			ConfigType configType = configTypeRepository.findByKey(null) ICMS-DEV-RMQ-01.atl.sbwc.state.ga.us
			docRabbitTemplate.convertAndSend(RabbitMQConfig.DOCUMENT_EXCHANGE_NAME, RabbitMQConfig.DOCUMENT_ROUTING_KEY,
					bytes);
		}

	}
}
