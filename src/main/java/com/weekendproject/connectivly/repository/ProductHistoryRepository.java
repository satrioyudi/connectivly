package com.weekendproject.connectivly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.ProductHistory;


@Repository
public interface ProductHistoryRepository extends JpaRepository<ProductHistory, Long>, JpaSpecificationExecutor<ProductHistory> {
	
	List<ProductHistory> findAllByProductIdAndUserId(Long prodId, String userId);

}
