package com.weekendproject.connectivly.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.BackOrder;


@Repository
public interface BackOrderRepository extends JpaRepository<BackOrder, Long>, JpaSpecificationExecutor<BackOrder> {

	Page<BackOrder> findAllByUserId(Pageable page, String string);

	Page<BackOrder> findAllByUserIdAndProductId(String string, Long id);


}
