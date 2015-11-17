package com.app.web.controllers;

import com.app.entity.Author;
import com.app.service.AuthorService;
import com.app.web.dto.ArticleDto;
import com.app.web.dto.AuthorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<AuthorDto> getAuthors() {
        return StreamSupport.stream(authorService.getAuthors().spliterator(), false)
                .map(author -> getAuthorDto(author))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/authors/{idAuthor}", method = RequestMethod.GET)
    public AuthorDto getAuthor(@PathVariable long idAuthor) {
        return getAuthorDto(authorService.getAuthor(idAuthor));
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto) {
        return getAuthorDto(authorService.saveAuthorDto(authorDto));
    }

    private AuthorDto getAuthorDto(Author author) {
        AuthorDto dto = new AuthorDto(author);

        if(org.hibernate.Hibernate.isPropertyInitialized(author, Author.ARTICLES_PROPERTY)) {
            dto.setArticles(author.getArticles().stream().map(article -> new ArticleDto(article)).collect(Collectors.toList()));
        }

        return dto;
    }


}
