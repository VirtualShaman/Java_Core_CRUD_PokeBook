package com.coding_dojo.crud_pokebook.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coding_dojo.crud_pokebook.models.PokeBook;
import com.coding_dojo.crud_pokebook.services.PokeBookService;

@Controller
public class PokeBookController {
 private final PokeBookService pokebookService;
 
 public PokeBookController(PokeBookService pokebookService){
     this.pokebookService = pokebookService;
 }
 
 @RequestMapping("/expenses")
 public String index(Model model, @ModelAttribute("expense") PokeBook expense) {
     List<PokeBook> expenses = pokebookService.allPokeBooks();
     model.addAttribute("expenses", expenses);
     return "index.jsp";
 }
 @RequestMapping("/expenses/{id}")
 public String showoff(@PathVariable("id") Long id, Model model) {
     model.addAttribute("expense", pokebookService.findPokeBook(id));
     return "showoff.jsp";
 }
 @RequestMapping(value="/addexpense", method=RequestMethod.POST)
 public String create(@Valid @ModelAttribute("expense") PokeBook expense, BindingResult result) {
     if (result.hasErrors()) {
         return "index.jsp";
     } else {
         pokebookService.createPokeBook(expense);
         return "redirect:/expenses";
     }
 }
 @RequestMapping("/expenses/edit/{id}")
 public String edit(@PathVariable("id") Long id, Model model) {
     PokeBook expense = pokebookService.findPokeBook(id);
     model.addAttribute("expense", expense);
     return "edit.jsp";
 }
 
 @RequestMapping(value="/expenses/{id}", method=RequestMethod.PUT)
 public String update(@Valid @ModelAttribute("expense") PokeBook expense, BindingResult result) {
     if (result.hasErrors()) {
         return "/expenses/edit.jsp";
     } else {
         pokebookService.updatePokeBook(expense);
         return "redirect:/expenses";
     }
 }
 @RequestMapping(value="/expenses/delete/{id}", method=RequestMethod.DELETE)
 public String destroy(@PathVariable("id") Long id) {
     pokebookService.deletePokeBook(id);
     return "redirect:/expenses";
 }
}

