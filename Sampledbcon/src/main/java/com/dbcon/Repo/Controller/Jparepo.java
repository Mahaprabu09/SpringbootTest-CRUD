package com.dbcon.Repo.Controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dbcon.Entity.Quote;


public interface Jparepo extends JpaRepository<Quote, Long> {
	   @Query("SELECT q FROM Quote q WHERE q.quote LIKE %?1%")
	    List<Quote> getContainingQuote(String word);   

}
