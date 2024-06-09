package com.mftplus.letter.model.entity;

import jakarta.enterprise.context.RequestScoped;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString

@Entity(name = "departmentEntity")
@Table(name = "department_tbl")
@RequestScoped
public class Department extends Base {
    @Id
    @SequenceGenerator(name = "departmentSeq", sequenceName = "department_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departmentSeq")
    @Column(name = "department_id", length = 20)
    private Long id;

    @Column(name = "department_title", length = 50)
    private String title;

    @Column(name = "department_duty", length = 50)
    private String duty;

    @Column(name = "department_name", length = 20)
    private String phoneNumber;

    @ManyToOne
    private Organisation organisation;

    @JsonbTransient
    @OneToMany(mappedBy = "department")
    private List<User> userList;

    public void addUser(User user){
        if (userList==null){
            userList = new ArrayList<>();
        }
        userList.add(user);
    }

    @JsonbTransient
    @OneToMany
    private List<Department> departmentPart;

    public void addDepartment(Department department){
        if (departmentPart==null){
            departmentPart = new ArrayList<>();
        }
        departmentPart.add(department);
    }

}