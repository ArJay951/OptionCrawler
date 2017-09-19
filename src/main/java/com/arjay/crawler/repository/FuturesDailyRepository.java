package com.arjay.crawler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arjay.crawler.pojo.mysql.FuturesDaily;

public interface FuturesDailyRepository extends JpaRepository<FuturesDaily, Long> {

}
