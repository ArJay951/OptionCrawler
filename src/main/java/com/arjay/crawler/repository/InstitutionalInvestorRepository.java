package com.arjay.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arjay.crawler.pojo.mysql.InstitutionalInvestor;

public interface InstitutionalInvestorRepository extends JpaRepository<InstitutionalInvestor, Long> {

}
