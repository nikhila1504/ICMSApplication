package com.icms.party.config;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.icms.party.constants.IcmsConfig;
import com.icms.party.service.ConfigServiceImpl;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentials;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;

@Configuration
public class AppConfig {

	private static final Logger log = LogManager.getLogger(AppConfig.class);

	@Autowired
	private ConfigServiceImpl configService;

	@PostConstruct
	public void init() {
		InputStream stream = null;
		try {
//			DefaultSecurityManager securityManager = new DefaultSecurityManager();
//			SecurityUtils.setSecurityManager(securityManager);
			configService.loadSystemProperties();

			stream = getClass().getClassLoader().getResourceAsStream("Aspose.Words.lic");
//			if (stream != null) {
//				// Apply License
//				License license = new License();
//				license.setLicense(stream);
//			}
		} catch (Exception e) {
			log.error("Error loading configuration: " + e.getMessage());
			System.exit(1);
		} finally {
			try {
				if (stream != null) {
					stream.close();
				}
			} catch (IOException e) {
				log.error("Error loading configuration " + e.getMessage());
				System.exit(1);
			}
		}
	}

	@Bean
	public S3AsyncClient s3AsyncClient() {
		return S3AsyncClient.crtBuilder().credentialsProvider(this::credentials)
				.region(Region.of(IcmsConfig.AWS_S3_REGION)).build();
	}

	private AwsCredentials credentials() {
		return AwsBasicCredentials.create(IcmsConfig.AWS_S3_ACCESS_KEY, IcmsConfig.AWS_S3_SECRET_KEY);
	}

	public ConnectionFactory docConnectionFactory() {
		CachingConnectionFactory factory = new CachingConnectionFactory(IcmsConfig.RABBIT_MQ_HOST);
		factory.setUsername(IcmsConfig.RABBIT_MQ_DOC_PRODUCER_USER);
		factory.setPassword(IcmsConfig.RABBIT_MQ_DOC_PRODUCER_PASSWORD);

		return factory;
	}

	public ConnectionFactory emailConnectionFactory() {
		CachingConnectionFactory factory = new CachingConnectionFactory(IcmsConfig.RABBIT_MQ_HOST);
		factory.setUsername(IcmsConfig.RABBIT_MQ_EMAIL_PRODUCER_USER);
		factory.setPassword(IcmsConfig.RABBIT_MQ_EMAIL_PRODUCER_PASSWORD);

		return factory;
	}

	public ConnectionFactory workflowConnectionFactory() {
		CachingConnectionFactory factory = new CachingConnectionFactory(IcmsConfig.RABBIT_MQ_HOST);
		factory.setUsername(IcmsConfig.RABBIT_MQ_WORKFLOW_PRODUCER_USER);
		factory.setPassword(IcmsConfig.RABBIT_MQ_WORKFLOW_PRODUCER_PASSWORD);

		return factory;
	}

	@Bean
	public RabbitTemplate docRabbitTemplate() {
		return new RabbitTemplate(docConnectionFactory());
	}

	@Bean
	public RabbitTemplate emailRabbitTemplate() {
		return new RabbitTemplate(emailConnectionFactory());
	}

	@Bean
	public RabbitTemplate workflowRabbitTemplate() {
		return new RabbitTemplate(workflowConnectionFactory());
	}

}
