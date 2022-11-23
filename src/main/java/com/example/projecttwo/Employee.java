package com.example.projecttwo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {


    private int id;
    private String employeeName;
    private String jobName;
    private Double Salary;


}
