package com.tinyurl.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "TINY_URL")
@NoArgsConstructor
public class URL implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "LONG_URL")
    private String longURL;

    @Column(name = "SHORT_URL")
    private String shortURL;

}
