package com.coding_dojo.crud_pokebook.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding_dojo.crud_pokebook.models.PokeBook;
import com.coding_dojo.crud_pokebook.services.PokeBookService;

@RestController
public class PokeBookAPI {
    private final PokeBookService pokebookService;
    public PokeBookAPI(PokeBookService pokebookService){
        this.pokebookService = pokebookService;
    }
    @RequestMapping("/api/expenses")
    public List<PokeBook> index() {
        return pokebookService.allPokeBooks();
    }
    
    @RequestMapping(value="/api/expenses", method=RequestMethod.POST)
    public PokeBook create(
        @RequestParam(value="name") String name, 
        @RequestParam(value="vendor") String vendor, 
        @RequestParam(value="description") String desc, 
        @RequestParam(value="price") Double price) {

        PokeBook expense = new PokeBook(name, vendor, desc, price);

        return pokebookService.createPokeBook(expense);
    }
    
    @RequestMapping("/api/expenses/{id}")
    public PokeBook show(@PathVariable("id") Long id) {
        PokeBook expense = pokebookService.findPokeBook(id);
        return expense;
    }
    // other methods removed for brevity
	
	  @RequestMapping(value="/api/expenses/{id}", method=RequestMethod.PUT) public
	  PokeBook update(
	  
	  @PathVariable("id") Long id,
	  
	  @RequestParam(value="name") String name,
	  
	  @RequestParam(value="vendor") String vendor,
	  
	  @RequestParam(value="description") String desc,
	  
	  @RequestParam(value="price") Double price) { PokeBook expense =
	  pokebookService.updatePokeBook(id, name, vendor, desc, price); return
	  expense; }
	  
	  
	  @RequestMapping(value="/api/expenses/{id}", method=RequestMethod.DELETE)
	  public void destroy(@PathVariable("id") Long id) {
	  pokebookService.deletePokeBook(id); }
	 
	 
}
