package com.weekendproject.connectivly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.GrnPoProduct;


@Repository
public interface GrnPoProductRepository extends JpaRepository<GrnPoProduct, Long>, JpaSpecificationExecutor<GrnPoProduct> {

	List<GrnPoProduct> findAllByPoNumber(String poNumber);

}
