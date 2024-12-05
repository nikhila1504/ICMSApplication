package gov.ga.sbwc.icms.core.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.ga.sbwc.icms.common.constants.IcmsConfig;
import gov.ga.sbwc.icms.common.entity.core.ConfigType;
import gov.ga.sbwc.icms.core.repository.ConfigTypeRepository;

@Service
public class ConfigServiceImpl {

	@Autowired
	private ConfigTypeRepository configTypeRepository;

	public ConfigType getConfigTypeById(Long id) {
		return configTypeRepository.findById(id).orElse(null);
	}

	public ConfigType getConfigTypeByKey(String key) {
		return configTypeRepository.findByKey(key);
	}

	public List<ConfigType> listAllConfigTypes() {
		return configTypeRepository.listAllConfigTypes();
	}

	public String getString(String value, String defaultValue){
			if (StringUtils.isNotBlank(value)) {
				return value;
			} else {
				return defaultValue;
			}
	}

	public boolean getBoolean(String value, boolean defaultValue){
			if (StringUtils.isNotBlank(value)) {
				return Boolean.parseBoolean(value);
			} else {
				return defaultValue;
			}
	}

	public int getInteger(String value, int defaultValue){
			if (StringUtils.isNotBlank(value)) {
				return Integer.parseInt(value);
			} else {
				return defaultValue;
			}
	}

	public long getLong(String value, long defaultValue){
			if (StringUtils.isNotBlank(value)) {
				return Long.parseLong(value);
			} else {
				return defaultValue;
			}
	}

	public void loadSystemProperties() {
		List<ConfigType> configTypes = listAllConfigTypes();
		if (configTypes != null && !configTypes.isEmpty()) {
			for (ConfigType config : configTypes) {
				switch (config.getKey()) {
				case IcmsConfig.PROPERTY_ENCRYPTION_KEY_LENGTH:
					IcmsConfig.ENCRYPTION_KEY_LENGTH = getInteger(config.getValue(), IcmsConfig.ENCRYPTION_KEY_LENGTH);
					break;
				case IcmsConfig.PROPERTY_HASH_ITERATIONS:
					IcmsConfig.HASH_ITERATIONS = getInteger(config.getValue(), IcmsConfig.HASH_ITERATIONS);
					break;
				case IcmsConfig.PROPERTY_MASTER_KEY:
					IcmsConfig.MASTER_KEY = getString(config.getValue(), IcmsConfig.MASTER_KEY);
					break;
				case IcmsConfig.PROPERTY_ENCRYPTION_ALGORITHM:
					IcmsConfig.ENCRYPTION_ALGORITHM = getString(config.getValue(), IcmsConfig.ENCRYPTION_ALGORITHM);
					break;
				case IcmsConfig.PROPERTY_HASH_ALGORITHM:
					IcmsConfig.HASH_ALGORITHM = getString(config.getValue(), IcmsConfig.HASH_ALGORITHM);
					break;
				case IcmsConfig.PROPERTY_RANDOM_ALGORITHM:
					IcmsConfig.RANDOM_ALGORITHM = getString(config.getValue(), IcmsConfig.RANDOM_ALGORITHM);
					break;
				case IcmsConfig.PROPERTY_LOG_SERVER_IP:
					IcmsConfig.LOG_SERVER_IP = getBoolean(config.getValue(), IcmsConfig.LOG_SERVER_IP);
					break;
				case IcmsConfig.PROPERTY_CHARACTER_ENCODING:
					IcmsConfig.CHARACTER_ENCODING = getString(config.getValue(), IcmsConfig.CHARACTER_ENCODING);
					break;
				case IcmsConfig.PROPERTY_ENVIRONMENT:
					IcmsConfig.ENVIRONMENT = getString(config.getValue(), IcmsConfig.ENVIRONMENT);
					break;
				case IcmsConfig.PROPERTY_AWS_S3_REGION:
					IcmsConfig.AWS_S3_REGION = getString(config.getValue(), IcmsConfig.AWS_S3_REGION);
					break;
				case IcmsConfig.PROPERTY_AWS_S3_BUCKET:
					IcmsConfig.AWS_S3_BUCKET = getString(config.getValue(), IcmsConfig.AWS_S3_BUCKET);
					break;
				case IcmsConfig.PROPERTY_AWS_S3_ACCESS_KEY:
					IcmsConfig.AWS_S3_ACCESS_KEY = getString(config.getValue(), IcmsConfig.AWS_S3_ACCESS_KEY);
					break;
				case IcmsConfig.PROPERTY_AWS_S3_SECRET_KEY:
					IcmsConfig.AWS_S3_SECRET_KEY = getString(config.getValue(), IcmsConfig.AWS_S3_SECRET_KEY);
					break;
				case IcmsConfig.PROPERTY_FOLDER_CLAIMS:
					IcmsConfig.FOLDER_CLAIMS = getString(config.getValue(), IcmsConfig.FOLDER_CLAIMS);
					break;
				case IcmsConfig.PROPERTY_FOLDER_NONCLAIMS:
					IcmsConfig.FOLDER_NONCLAIMS = getString(config.getValue(), IcmsConfig.FOLDER_NONCLAIMS);
					break;
				case IcmsConfig.PROPERTY_FOLDER_RESEARCH:
					IcmsConfig.FOLDER_RESEARCH = getString(config.getValue(), IcmsConfig.FOLDER_RESEARCH);
					break;
				case IcmsConfig.PROPERTY_FOLDER_OTHERS:
					IcmsConfig.FOLDER_OTHERS = getString(config.getValue(), IcmsConfig.FOLDER_OTHERS);
					break;
				case IcmsConfig.PROPERTY_FOLDER_WC_10:
					IcmsConfig.FOLDER_WC_10 = getString(config.getValue(), IcmsConfig.FOLDER_WC_10);
					break;
				case IcmsConfig.PROPERTY_SYSTEM_USER:
					IcmsConfig.SYSTEM_USER = getLong(config.getValue(), IcmsConfig.SYSTEM_USER);
					break;
				case IcmsConfig.PROPERTY_USER_AD_EXTENSION:
					IcmsConfig.USER_AD_EXTENSION = getString(config.getValue(), IcmsConfig.USER_AD_EXTENSION);
					break;
				case IcmsConfig.PROPERTY_LDAP_URL:
					IcmsConfig.LDAP_URL = getString(config.getValue(), IcmsConfig.LDAP_URL);
					break;
				case IcmsConfig.PROPERTY_JMS_QUEUE_USER:
					IcmsConfig.JMS_QUEUE_USER = getString(config.getValue(), IcmsConfig.JMS_QUEUE_USER);
					break;
				case IcmsConfig.PROPERTY_JMS_QUEUE_PASSWORD:
					IcmsConfig.JMS_QUEUE_PASSWORD = getString(config.getValue(), IcmsConfig.JMS_QUEUE_PASSWORD);
					break;
				case IcmsConfig.PROPERTY_PASSWORD_EXPIRATION_DURATION:
					IcmsConfig.PASSWORD_EXPIRATION_DURATION = getInteger(config.getValue(),
							IcmsConfig.PASSWORD_EXPIRATION_DURATION);
					break;
				case IcmsConfig.PROPERTY_ALLOWED_LOGIN_ATTEMPTS:
					IcmsConfig.ALLOWED_LOGIN_ATTEMPTS = getInteger(config.getValue(),
							IcmsConfig.ALLOWED_LOGIN_ATTEMPTS);
					break;
				case IcmsConfig.PROPERTY_MAX_OLD_PASSWORD_HASHES:
					IcmsConfig.MAX_OLD_PASSWORD_HASHES = getInteger(config.getValue(),
							IcmsConfig.MAX_OLD_PASSWORD_HASHES);
					break;
				case IcmsConfig.PROPERTY_ADMIN_EMAIL:
					IcmsConfig.ADMIN_EMAIL = getString(config.getValue(), IcmsConfig.ADMIN_EMAIL);
					break;
				case IcmsConfig.PROPERTY_EMAIL_MAILER:
					IcmsConfig.EMAIL_MAILER = getString(config.getValue(), IcmsConfig.EMAIL_MAILER);
					break;
				case IcmsConfig.PROPERTY_ICMS_SUPPORT_EMAIL:
					IcmsConfig.ICMS_SUPPORT_EMAIL = getString(config.getValue(), IcmsConfig.ICMS_SUPPORT_EMAIL);
					break;
				case IcmsConfig.PROPERTY_RECORD_DISPOSITION:
					IcmsConfig.RECORD_DISPOSITION = getBoolean(config.getValue(), IcmsConfig.RECORD_DISPOSITION);
					break;
				case IcmsConfig.PROPERTY_SYSTEM_ANTIVIR:
					IcmsConfig.SYSTEM_ANTIVIR = getString(config.getValue(), IcmsConfig.SYSTEM_ANTIVIR);
					break;
				case IcmsConfig.PROPERTY_RABBIT_MQ_HOST:
					IcmsConfig.RABBIT_MQ_HOST = getString(config.getValue(), IcmsConfig.RABBIT_MQ_HOST);
					break;
				case IcmsConfig.PROPERTY_RABBIT_MQ_DOC_PRODUCER_USER:
					IcmsConfig.RABBIT_MQ_DOC_PRODUCER_USER = getString(config.getValue(),
							IcmsConfig.RABBIT_MQ_DOC_PRODUCER_USER);
					break;
				case IcmsConfig.PROPERTY_RABBIT_MQ_DOC_PRODUCER_PASSWORD:
					IcmsConfig.RABBIT_MQ_DOC_PRODUCER_PASSWORD = getString(config.getValue(),
							IcmsConfig.RABBIT_MQ_DOC_PRODUCER_PASSWORD);
					break;
				case IcmsConfig.PROPERTY_RABBIT_MQ_EMAIL_PRODUCER_USER:
					IcmsConfig.RABBIT_MQ_EMAIL_PRODUCER_USER = getString(config.getValue(),
							IcmsConfig.RABBIT_MQ_EMAIL_PRODUCER_USER);
					break;
				case IcmsConfig.PROPERTY_RABBIT_MQ_EMAIL_PRODUCER_PASSWORD:
					IcmsConfig.RABBIT_MQ_EMAIL_PRODUCER_PASSWORD = getString(config.getValue(),
							IcmsConfig.RABBIT_MQ_EMAIL_PRODUCER_PASSWORD);
					break;
				case IcmsConfig.PROPERTY_DOCUMENT_EXCHANGE_NAME:
					IcmsConfig.DOCUMENT_EXCHANGE_NAME = getString(config.getValue(), IcmsConfig.DOCUMENT_EXCHANGE_NAME);
					break;
				case IcmsConfig.PROPERTY_EMAIL_EXCHANGE_NAME:
					IcmsConfig.EMAIL_EXCHANGE_NAME = getString(config.getValue(), IcmsConfig.EMAIL_EXCHANGE_NAME);
					break;
				case IcmsConfig.PROPERTY_DOCUMENT_ROUTING_KEY:
					IcmsConfig.DOCUMENT_ROUTING_KEY = getString(config.getValue(), IcmsConfig.DOCUMENT_ROUTING_KEY);
					break;
				case IcmsConfig.PROPERTY_EMAIL_ROUTING_KEY:
					IcmsConfig.EMAIL_ROUTING_KEY = getString(config.getValue(), IcmsConfig.EMAIL_ROUTING_KEY);
					break;
				case IcmsConfig.PROPERTY_RABBIT_MQ_WORKFLOW_PRODUCER_USER:
					IcmsConfig.RABBIT_MQ_WORKFLOW_PRODUCER_USER = getString(config.getValue(),
							IcmsConfig.RABBIT_MQ_WORKFLOW_PRODUCER_USER);
					break;
				case IcmsConfig.PROPERTY_RABBIT_MQ_WORKFLOW_PRODUCER_PASSWORD:
					IcmsConfig.RABBIT_MQ_WORKFLOW_PRODUCER_PASSWORD = getString(config.getValue(),
							IcmsConfig.RABBIT_MQ_WORKFLOW_PRODUCER_PASSWORD);
					break;
				case IcmsConfig.PROPERTY_WORKFLOW_BRIDGE_EXCHANGE_NAME:
					IcmsConfig.WORKFLOW_BRIDGE_EXCHANGE_NAME = getString(config.getValue(),
							IcmsConfig.WORKFLOW_BRIDGE_EXCHANGE_NAME);
					break;
				case IcmsConfig.PROPERTY_WORKFLOW_BRIDGE_ROUTING_KEY:
					IcmsConfig.WORKFLOW_BRIDGE_ROUTING_KEY = getString(config.getValue(),
							IcmsConfig.WORKFLOW_BRIDGE_ROUTING_KEY);
					break;
				case IcmsConfig.PROPERTY_REST_API_USER:
					IcmsConfig.REST_API_USER = getString(config.getValue(), IcmsConfig.REST_API_USER);
					break;
				case IcmsConfig.PROPERTY_REST_API_PASSWORD:
					IcmsConfig.REST_API_PASSWORD = getString(config.getValue(), IcmsConfig.REST_API_PASSWORD);
					break;
				case IcmsConfig.PROPERTY_REST_API_KEY:
					IcmsConfig.REST_API_KEY = getString(config.getValue(), IcmsConfig.REST_API_KEY);
					break;
				case IcmsConfig.PROPERTY_EDIT_DISTANCE_SIMILARITY:
					IcmsConfig.EDIT_DISTANCE_SIMILARITY = getInteger(config.getValue(),
							IcmsConfig.EDIT_DISTANCE_SIMILARITY);
					break;
				case IcmsConfig.PROPERTY_TRUST_STORE:
					IcmsConfig.TRUST_STORE = getString(config.getValue(), IcmsConfig.TRUST_STORE);
					break;
				case IcmsConfig.PROPERTY_TRUST_STORE_PASSWORD:
					IcmsConfig.TRUST_STORE_PASSWORD = getString(config.getValue(), IcmsConfig.TRUST_STORE_PASSWORD);
					break;
				default:
					break;
				}
			}
		}
	}
}
