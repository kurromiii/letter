package com.mftplus.letter.model.service.interfaces;

import com.mftplus.letter.model.entity.CompositeKey;
import com.mftplus.letter.model.entity.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesService {
    void save(Roles role) throws Exception;
    void edit(Roles role) throws Exception;
    void remove(Roles role) throws Exception;
    void removeById(String roleName,String username) throws Exception;

    Optional<Roles> findById(CompositeKey compositeKey) throws Exception;
    List<Roles> findAll() throws Exception;
    List<Roles> findByRoleName(String roleName) throws Exception;
    List<Roles> findByUser(String username) throws Exception;
}
