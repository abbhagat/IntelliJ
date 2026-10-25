package com.app.redis.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEPARTMENT")
public class Department implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "DEPT_ID")
  private int deptId;

  @Column(name = "DEPT_NAME")
  private String deptName;

  @Column(name = "DEPT_LOC")
  private String deptLoc;

}

