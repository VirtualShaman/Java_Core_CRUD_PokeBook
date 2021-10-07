package com.coding_dojo.crud_pokebook.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coding_dojo.crud_pokebook.models.PokeBook;

@Repository
public interface PokeBookRepository extends CrudRepository<PokeBook, Long>{
 // this method retrieves all the books from the database
 List<PokeBook> findAll();
 // this method finds books with descriptions containing the search string
 List<PokeBook> findByDescriptionContaining(String search);
}


