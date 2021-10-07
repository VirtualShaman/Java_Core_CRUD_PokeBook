package com.coding_dojo.crud_pokebook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding_dojo.crud_pokebook.models.PokeBook;
import com.coding_dojo.crud_pokebook.repositories.PokeBookRepository;

@Service
public class PokeBookService {
 // adding the expense repository as a dependency
	private final PokeBookRepository repository;
 
 public PokeBookService(PokeBookRepository repository) {
     this.repository = repository;
 }
 // returns all the expenses
 public List<PokeBook> allPokeBooks() {
     return repository.findAll();
 }
 // creates a expense
 public PokeBook createPokeBook(PokeBook b) {
     return repository.save(b);
 }
 // retrieves a expense
 public PokeBook findPokeBook(Long id) {
     Optional<PokeBook> optionalBook = repository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
public PokeBook updatePokeBook(Long id, String name, String vendor, String desc, Double price) {
	PokeBook expense = new PokeBook(name, vendor, desc, price);
	expense.setId(id);
	repository.save(expense);
	return null;
}
public PokeBook updatePokeBook(PokeBook expense) {
	repository.save(expense);
	return null;
}
public void deletePokeBook(Long id) {
	repository.deleteById(id);
	
}
}


