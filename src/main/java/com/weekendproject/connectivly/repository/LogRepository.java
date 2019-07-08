package com.weekendproject.connectivly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.LogProcess;


@Repository
public interface LogRepository extends JpaRepository<LogProcess, Long>, JpaSpecificationExecutor<LogProcess> {

}
