package com.godel.employee.entity;

import com.godel.employee.utils.validation.annotations.ValidName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @NotBlank(message = "First name is required field")
    @Column(name = "first_name", nullable = false, length = 30)
    @ValidName
    @Size(min = 2, message = "First name must be min 2 symbols")
    private String firstName;

    @NotBlank(message = "Last name is required field")
    @Column(name = "last_name", nullable = false, length = 30)
    @ValidName
    @Size(min = 2, message = "Last name must be min 2 symbols")
    private String lastName;

    @Column(name = "department_id")
    private Long department;

    @Column(name = "job_title", length = 30)
    private String jobTitle;

    @Column(name = "gender", nullable = false, length = 10)
    private String gender;
}
