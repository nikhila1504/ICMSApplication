package gov.ga.sbwc.icms.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.Wc1Form;

@Repository
public interface Wc1FormRepository extends CrudRepository<Wc1Form, Long> {

}
