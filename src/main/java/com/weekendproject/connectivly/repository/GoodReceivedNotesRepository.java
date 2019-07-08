package com.weekendproject.connectivly.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.weekendproject.connectivly.model.GoodReceivedNotes;


@Repository
public interface GoodReceivedNotesRepository extends JpaRepository<GoodReceivedNotes, Long>, JpaSpecificationExecutor<GoodReceivedNotes> {

	Page<GoodReceivedNotes> findAllByUserId(Pageable page, String decodeJwt);

	GoodReceivedNotes findByCode(String code);


}
