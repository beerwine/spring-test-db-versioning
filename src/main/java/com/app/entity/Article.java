package com.app.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "article", schema = "public")
@SequenceGenerator(name = "article_id_sequence", sequenceName = "article_id_sequence", initialValue = 20, allocationSize = 1)
public class Article extends AbstractEntity{
    public static final String AUTHORS_PROPERTY = "authors";

    private String name;
    private Set<Author> authors = new HashSet<>();

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_id_sequence")
    public Long getId() {
        return super.getId();
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "articles")
    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
