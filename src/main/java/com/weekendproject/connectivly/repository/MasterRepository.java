package com.weekendproject.connectivly.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.Master;


@Repository
public interface MasterRepository extends JpaRepository<Master, Long>, JpaSpecificationExecutor<Master> {

	List<Master> findAllByUserId(String user);
	
	@Query("select m.brands from com.weekendproject.connectivly.model.Master m where m.userId = ?1")
	List<Master> findBrands(String userId);

	Optional<Master> findByCustomerCategory(String customerCategory);


}
