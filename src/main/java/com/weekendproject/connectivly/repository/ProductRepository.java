package com.weekendproject.connectivly.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products, Long>, JpaSpecificationExecutor<Products> {

	Page<Products> findAllByUserId(Pageable page, String userName);

	Page<Products> findAllByUserIdAndDeletedAtIsNull(Pageable page, String userName);

}
