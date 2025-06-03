package com.bookStore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bRepo;

	// ✅ Retourne le Book enregistré
	public Book save(Book b) {
		return bRepo.save(b);
	}

	public List<Book> getAllBook() {
		return bRepo.findAll();
	}

	public Book getBookById(int id) {
		return bRepo.findById(id).orElse(null); // meilleure gestion d'absence
	}

	public void deleteById(int id) {
		bRepo.deleteById(id);
	}
}
