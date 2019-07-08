package com.weekendproject.connectivly.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "seq_number")
public class SeqNumber {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long seqId;
	
	@Column(name = "code")
	private String code;

	public Long getSeqId() {
		return seqId;
	}

	public void setSeqId(Long seqId) {
		this.seqId = seqId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
