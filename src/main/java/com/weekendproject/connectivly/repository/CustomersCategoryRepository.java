package com.weekendproject.connectivly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.CustomerCategoryCustomer;


@Repository
public interface CustomersCategoryRepository extends JpaRepository<CustomerCategoryCustomer, Long>, JpaSpecificationExecutor<CustomerCategoryCustomer> {


}
