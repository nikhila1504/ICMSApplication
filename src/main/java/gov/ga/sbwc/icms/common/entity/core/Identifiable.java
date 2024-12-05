package gov.ga.sbwc.icms.common.entity.core;

import java.io.Serializable;

public interface Identifiable<T extends Serializable> {
	 T getId();
}
