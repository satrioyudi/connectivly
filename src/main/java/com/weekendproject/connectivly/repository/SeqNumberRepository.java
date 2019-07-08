package com.weekendproject.connectivly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.SeqNumber;


@Repository
public interface SeqNumberRepository extends JpaRepository<SeqNumber, Long> {

	SeqNumber findTopByOrderBySeqIdDesc();

	SeqNumber findFirstByOrderBySeqIdDesc();

	SeqNumber findTopByOrderByIdDesc();

	SeqNumber findTopByCodeOrderByIdDesc(String code);


}
