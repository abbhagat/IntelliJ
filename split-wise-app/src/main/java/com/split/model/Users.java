package com.split.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "USERS")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private long userID;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="EMAIL")
    private String email;

    @ManyToMany(mappedBy = "usersList")
    private List<Group> groupList = new ArrayList<>();
}
