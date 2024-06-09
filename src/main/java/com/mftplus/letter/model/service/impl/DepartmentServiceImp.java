package com.mftplus.letter.model.service.impl;

import com.mftplus.letter.model.entity.Department;
import com.mftplus.letter.model.service.interfaces.DepartmentService;
import jakarta.enterprise.context.SessionScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Slf4j
@SessionScoped
public class DepartmentServiceImp implements DepartmentService, Serializable {
    @PersistenceContext(unitName = "automation")
    private EntityManager entityManager;

    @Transactional
    @Override
    public void save(Department department) throws Exception {
        log.info("Section Saved");
        entityManager.persist(department);
    }

    @Transactional
    @Override
    public void edit(Department department) throws Exception {
        entityManager.merge(department);
    }

    @Transactional
    @Override
    public void remove(Department department) throws Exception {
        department.setDeleted(true);
        entityManager.merge(department);
    }

    @Transactional
    @Override
    public void removeById(Long id) throws Exception {
        Department department = entityManager.find(Department.class, id);
        department.setDeleted(true);
        entityManager.merge(department);
    }

    @Transactional
    @Override
    public List<Department> findAll() throws Exception {
        TypedQuery<Department> query = entityManager.createQuery("select oo from departmentEntity oo", Department.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Optional<Department> findById(Long id) throws Exception {
        return Optional.ofNullable(entityManager.find(Department.class, id));
    }

    @Transactional
    @Override
    public Optional<Department> findByTitle(String title) throws Exception {
        TypedQuery<Department> query = entityManager.createQuery("select oo from departmentEntity oo where oo.title=:title", Department.class);
        query.setParameter( "title",title);
        return Optional.ofNullable(entityManager.find(Department.class, title));
    }

}
