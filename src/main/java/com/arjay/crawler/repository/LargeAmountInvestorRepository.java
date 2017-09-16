package com.arjay.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arjay.crawler.pojo.mysql.LargeAmountInvestor;

public interface LargeAmountInvestorRepository extends JpaRepository<LargeAmountInvestor, Long> {

}
