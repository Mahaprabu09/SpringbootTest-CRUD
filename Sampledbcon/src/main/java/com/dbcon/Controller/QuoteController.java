package com.dbcon.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbcon.Entity.Quote;
import com.dbcon.Repo.Controller.Jparepo;

@RestController
public class QuoteController {
	
	
	    @Autowired
	    private Jparepo quoteRepo;

	    @GetMapping("/quotes")
	    public List<Quote> getQuotes(@RequestParam("search") Optional<String> searchParam){
	        return searchParam.map( param->quoteRepo.getContainingQuote(param) )
	                .orElse(quoteRepo.findAll());
	    }

	    @GetMapping("/quotes/{quoteId}" )
	    public ResponseEntity<String> readQuote(@PathVariable("quoteId") Long id) {
	        return ResponseEntity.of(quoteRepo.findById(id).map(Quote::getQuote));
	    }

	    @PostMapping("/quotes")
	    public Quote addQuote(@RequestBody String quote) {
	        Quote q = new Quote();
	        q.setQuote(quote);
	        return quoteRepo.save(q);
	    }

	    @RequestMapping(value="/quotes/{quoteId}", method=RequestMethod.DELETE)
	    public void deleteQuote(@PathVariable(value = "quoteId") Long id) {
	    	quoteRepo.deleteById(id);
	    }

}
