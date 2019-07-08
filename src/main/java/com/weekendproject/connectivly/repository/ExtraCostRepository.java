package com.weekendproject.connectivly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.ExtraCost;


@Repository
public interface ExtraCostRepository extends JpaRepository<ExtraCost, Long>, JpaSpecificationExecutor<ExtraCost> {

	List<ExtraCost> findAllByUserId(String decodeJwt);

}
