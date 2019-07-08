package com.weekendproject.connectivly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.Customers;


@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long>, JpaSpecificationExecutor<Customers> {

	List<Customers> findAllByUserId(String user);


}
