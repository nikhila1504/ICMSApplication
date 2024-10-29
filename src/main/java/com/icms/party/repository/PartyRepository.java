package com.icms.party.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.Party_Dummy;

@Repository
public interface PartyRepository extends CrudRepository<Party_Dummy,Integer>{

}
