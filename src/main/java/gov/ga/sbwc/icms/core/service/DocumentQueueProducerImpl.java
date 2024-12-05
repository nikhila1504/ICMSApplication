package gov.ga.sbwc.icms.core.service;

import org.apache.commons.lang.SerializationUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.dto.form.FormDTO;
import gov.ga.sbwc.icms.common.util.RabbitMQConfig;
import gov.ga.sbwc.icms.core.repository.ConfigTypeRepository;

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
