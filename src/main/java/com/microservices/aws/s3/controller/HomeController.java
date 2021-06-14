package com.microservices.aws.s3.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.aws.s3.models.Book;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class HomeController {
	@GetMapping("/hello")
	public String hello()
	{
		log.info("Entered into hello");
		return "Hello World ";
	}
@GetMapping("/books")
	public List<Book> books()
	{
		List<Book> books= Stream.of(
				
				new Book(1, "java", 3000),
				new Book(2, "PHP", 2000),
				new Book(3, "Android", 1000)
				).collect(Collectors.toList());
		
		return books;
	}
	
@GetMapping("/book")
public Book book()
{
	return new Book(1, "java", 3000);
}
@PostMapping("/book")
public String createNewBook(@RequestBody Book book)
{
	log.info("Book recieved -> "+book);
	return "success";
}
}
