package com.api.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "itens")
public class Itens implements Serializable {

    private static final long serialVersionUID = -8886577733981409069L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    public Long getId() {
        return id;
    }

    public Itens setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Itens setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Itens setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Itens setImage(String image) {
        this.image = image;
        return this;
    }

    public Itens build(){
        return this;
    }
}
