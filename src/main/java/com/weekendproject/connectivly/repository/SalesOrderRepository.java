package com.weekendproject.connectivly.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.SalesOrder;


@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long>, JpaSpecificationExecutor<SalesOrder> {

	SalesOrder findByPoCode(String poNumber);

	Optional<SalesOrder> findByCode(String code);

	Page<SalesOrder> findAllByUserIdAndIsLinkedAndIsApproved(Pageable page, String string, String string2, boolean b);


}
