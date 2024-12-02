package com.icms.party.constants;

public class IcmsConfig {
	
	// Properties	
	public static final String PROPERTY_PASSWORD_EXPIRATION_DURATION = "password.expiration.duration";
	public static final String PROPERTY_ALLOWED_LOGIN_ATTEMPTS = "allowed.login.attempts";
	public static final String PROPERTY_MAX_OLD_PASSWORD_HASHES = "max.oldpassword.hashes";
	public static final String PROPERTY_MASTER_KEY = "master.key";
    public static final String PROPERTY_ENCRYPTION_KEY_LENGTH = "encryption.key.length";
    public static final String PROPERTY_ENCRYPTION_ALGORITHM = "encryption.algorithm";
    public static final String PROPERTY_HASH_ALGORITHM = "hash.algorithm";
    public static final String PROPERTY_HASH_ITERATIONS = "hash.iterations";
    public static final String PROPERTY_RANDOM_ALGORITHM = "random.algorithm";
    public static final String PROPERTY_LOG_SERVER_IP = "log.server.ip";
    public static final String PROPERTY_CHARACTER_ENCODING = "character.encoding";
    
	// Maintenance Configuratuion
	public static final String PROPERTY_MAINTENANCE_FLAG = "maintenance.flag";
	public static final String PROPERTY_MAINTENANCE_MESSAGE = "maintenance.message";
	
	// Maintenance Configuratuion
	public static final String PROPERTY_ENVIRONMENT = "environment";
	
	// AWS S3 Configuration
	public static final String PROPERTY_AWS_S3_REGION = "aws.s3.region";
	public static final String PROPERTY_AWS_S3_BUCKET = "aws.s3.bucket";
	public static final String PROPERTY_AWS_S3_ACCESS_KEY = "aws.s3.access-key";
	public static final String PROPERTY_AWS_S3_SECRET_KEY = "aws.s3.secret-key";
	
	// Folder Configuration
	public static final String PROPERTY_FOLDER_CLAIMS = "alfresco.folder.claims";
	public static final String PROPERTY_FOLDER_NONCLAIMS = "alfresco.folder.nonclaims";
	public static final String PROPERTY_FOLDER_RESEARCH = "alfresco.folder.research";
	public static final String PROPERTY_FOLDER_OTHERS = "alfresco.folder.others";
	public static final String PROPERTY_FOLDER_WC_10 = "alfresco.folder.wc10";
	
	// System Antivirus Configuration
	public static final String PROPERTY_SYSTEM_ANTIVIR = "system.antivir";

	// Email Configuration
	public static final String PROPERTY_ENFORCEMENT_EMAIL = "enforcement.email";
	public static final String PROPERTY_MANAGEDCARE_EMAIL = "managedcare.email";
	public static final String PROPERTY_MFR_APPEALS_EMAIL = "mfrappeals.email";
	public static final String PROPERTY_LICENSURE_EMAIL = "licensure.email";
	public static final String PROPERTY_SETTLEMENTS_GROUP_EMAIL = "settlements.group.email";
	public static final String PROPERTY_EDI_SUPPORT_EMAIL = "edi.support.email";
	public static final String PROPERTY_ICMS_SUPPORT_EMAIL = "icms.support.email";
	
	// System User Configuration
	public static final String PROPERTY_SYSTEM_USER = "system.user";
	
	// LDAP Configuration
	public static final String PROPERTY_USER_AD_EXTENSION = "user.ad.extension";
	public static final String PROPERTY_LDAP_URL = "ldap.url";
	public static final String PROPERTY_ADMIN_EMAIL = "admin.email";
	public static final String PROPERTY_EMAIL_MAILER = "email.mailer";
	
	// JMS Queue Configuration
	public static final String PROPERTY_JMS_QUEUE_USER = "jms.queue.user";
	public static final String PROPERTY_JMS_QUEUE_PASSWORD = "jms.queue.password";
	
	// Record Disposition Configuration
	public static final String PROPERTY_RECORD_DISPOSITION = "record.disposition";	
	
	// Rabbit MQ Configuration
	public static final String PROPERTY_RABBIT_MQ_HOST = "rabbitmq.host";
	public static final String PROPERTY_RABBIT_MQ_DOC_PRODUCER_USER = "rabbitmq.doc.producer.user";
	public static final String PROPERTY_RABBIT_MQ_DOC_PRODUCER_PASSWORD = "rabbitmq.doc.producer.password";
	public static final String PROPERTY_RABBIT_MQ_EMAIL_PRODUCER_USER = "rabbitmq.email.producer.user";
	public static final String PROPERTY_RABBIT_MQ_EMAIL_PRODUCER_PASSWORD = "rabbitmq.email.producer.password";
	public static final String PROPERTY_DOCUMENT_EXCHANGE_NAME = "rabbitmq.document.exchange.name";
	public static final String PROPERTY_DOCUMENT_ROUTING_KEY = "rabbitmq.document.routing.key";
	public static final String PROPERTY_EMAIL_EXCHANGE_NAME = "rabbitmq.email.exchange.name";
	public static final String PROPERTY_EMAIL_ROUTING_KEY = "rabbitmq.email.routing.key";
	public static final String PROPERTY_RABBIT_MQ_WORKFLOW_PRODUCER_USER = "rabbitmq.workflow.producer.user";
	public static final String PROPERTY_RABBIT_MQ_WORKFLOW_PRODUCER_PASSWORD = "rabbitmq.workflow.producer.password";
	public static final String PROPERTY_WORKFLOW_BRIDGE_EXCHANGE_NAME = "rabbitmq.workflow.bridge.exchange.name";
	public static final String PROPERTY_WORKFLOW_BRIDGE_ROUTING_KEY = "rabbitmq.workflow.bridge.routing.key";	

	// REST API Credentials
	public static final String PROPERTY_REST_API_USER = "rest.api.user";
	public static final String PROPERTY_REST_API_PASSWORD = "rest.api.password";	
	public static final String PROPERTY_REST_API_KEY = "rest.api.key";	

	public static final String PROPERTY_EDIT_DISTANCE_SIMILARITY = "edit.distance.similarity";

	// Certs Config
	public static final String PROPERTY_TRUST_STORE = "trustStore";
	public static final String PROPERTY_TRUST_STORE_PASSWORD = "trustStorePassword";

	// Default Values
	public static int PASSWORD_EXPIRATION_DURATION = 3;
	public static int ALLOWED_LOGIN_ATTEMPTS = 3;
	public static int MAX_OLD_PASSWORD_HASHES = 3;
	public static String MASTER_KEY = "";
    public static int ENCRYPTION_KEY_LENGTH = 128;
    public static String ENCRYPTION_ALGORITHM = "AES";
    public static String HASH_ALGORITHM = "SHA-512";
    public static int HASH_ITERATIONS = 1024;
    public static String RANDOM_ALGORITHM = "SHA1PRNG";
    public static boolean LOG_SERVER_IP = true;
    public static String CHARACTER_ENCODING = "UTF-8";
    
	// Maintenance Configuratuion
	public static String MAINTENANCE_MESSAGE = "";
	public static String ENVIRONMENT = "";
	
	// AWS S3 Configuration
	public static String AWS_S3_REGION = "";
	public static String AWS_S3_BUCKET = "";
	public static String AWS_S3_ACCESS_KEY = "";
	public static String AWS_S3_SECRET_KEY = "";
	
	// Folder Configuration
	public static String FOLDER_CLAIMS = "";
	public static String FOLDER_NONCLAIMS = "";
	public static String FOLDER_RESEARCH = "";
	public static String FOLDER_OTHERS = "";
	public static String FOLDER_WC_10 = "";
	
	// System Antivirus
	public static String SYSTEM_ANTIVIR = "";
	
	public static String ENFORCEMENT_EMAIL = "";
	public static String MANAGEDCARE_EMAIL = "";
	public static String MFR_APPEALS_EMAIL = "";
	public static String LICENSURE_EMAIL = "";
	public static String ICMS_SUPPORT_EMAIL = "";
	public static String SETTLEMENTS_GROUP_EMAIL = "";
	public static String EDI_SUPPORT_EMAIL = "";
	
	public static long SYSTEM_USER = 1;
	
	public static String USER_AD_EXTENSION = "";
	public static String LDAP_URL = "";
	public static String ADMIN_EMAIL = "donotreply@sbwc.ga.gov";
	public static String EMAIL_MAILER = "";
	
	public static String JMS_QUEUE_USER = "";
	public static String JMS_QUEUE_PASSWORD = "";

	public static boolean RECORD_DISPOSITION = false;
	
	// Rabbit MQ Configuration
	public static String RABBIT_MQ_HOST = "";
	public static String RABBIT_MQ_DOC_PRODUCER_USER = "";
	public static String RABBIT_MQ_DOC_PRODUCER_PASSWORD = "";
	public static String RABBIT_MQ_EMAIL_PRODUCER_USER = "";
	public static String RABBIT_MQ_EMAIL_PRODUCER_PASSWORD = "";
	public static String DOCUMENT_EXCHANGE_NAME = "document.direct";
	public static String EMAIL_EXCHANGE_NAME = "email.direct";
	
	public static String DOCUMENT_ROUTING_KEY = "form";
	public static String EMAIL_ROUTING_KEY = "email";

	public static String RABBIT_MQ_WORKFLOW_PRODUCER_USER = "";
	public static String RABBIT_MQ_WORKFLOW_PRODUCER_PASSWORD = "";
	public static String WORKFLOW_BRIDGE_EXCHANGE_NAME = "workflow.bridge.direct";
	public static String WORKFLOW_BRIDGE_ROUTING_KEY = "workflow";
	
	public static String REST_API_USER = "";
	public static String REST_API_PASSWORD = "";
	public static String REST_API_KEY = "";	
	//public static SecurityUser systemUser;

	public static Integer EDIT_DISTANCE_SIMILARITY = 65;

	// Certs Config
	public static String TRUST_STORE = "";
	public static String TRUST_STORE_PASSWORD = "";
}
