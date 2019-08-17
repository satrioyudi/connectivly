package com.weekendproject.connectivly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.SalesOrderProduct;


@Repository
public interface SalesOrderProductRepository extends JpaRepository<SalesOrderProduct, Long>, JpaSpecificationExecutor<SalesOrderProduct> {


}
