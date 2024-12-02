package com.icms.party.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icms.party.entity.SecurityUser;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {

}
