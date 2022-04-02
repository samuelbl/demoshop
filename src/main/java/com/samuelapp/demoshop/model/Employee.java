package com.samuelapp.demoshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private EmployeeType type;
    @ManyToOne
    private Shop shop;
    private String telephone;
    private String address;
    @Column(name = "employment_date")
    private Date employmentDate;
}
