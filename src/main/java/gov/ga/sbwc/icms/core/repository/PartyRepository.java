package gov.ga.sbwc.icms.core.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gov.ga.sbwc.icms.common.entity.core.Party_Dummy;

@Repository
public interface PartyRepository extends CrudRepository<Party_Dummy,Integer>{

}
