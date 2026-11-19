package com.app.redis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Table(name = "DEPARTMENT")
public class Department implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "DEPT_ID")
  private Long deptId;

  @Column(name = "DEPT_NAME")
  private String deptName;

  @Column(name = "DEPT_LOC")
  private String deptLoc;

  protected Department() {}

  public Department(String deptName, String deptLoc) {
    this.deptName = deptName;
    this.deptLoc = deptLoc;
  }

  public void update(String deptName, String deptLoc) {
    this.deptName = deptName;
    this.deptLoc = deptLoc;
  }
}

