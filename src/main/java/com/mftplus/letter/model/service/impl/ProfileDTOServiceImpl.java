package com.mftplus.letter.model.service.impl;

import com.mftplus.letter.model.entity.Person;
import com.mftplus.letter.model.entity.ProfileDto;
import com.mftplus.letter.model.service.interfaces.ProfileDTOService;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class ProfileDTOServiceImpl implements ProfileDTOService {
    @Inject
    private PersonServiceImpl personService;
    @Inject
    private UserServiceImpl userService;

    @Override
    public void save(ProfileDto profileDto) throws Exception {

    }

    @Override
    public void edit(ProfileDto profileDto) throws Exception {

    }

    @Override
    public void remove(ProfileDto profileDto) throws Exception {

    }

    @Override
    public void removeById(Long id) throws Exception {

    }

    @Override
    public Optional<ProfileDto> findById(Long id) throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<ProfileDto> findByUsername(String username) throws Exception {
        ProfileDto profileDto = new ProfileDto();
        userService.findByUsername(username);

        return Optional.empty();
    }

    @Override
    public List<ProfileDto> findAll() throws Exception {
        ProfileDto profileDto = new ProfileDto();
        List<Person> person = personService.findAll();
//        profileDto.setName();

        return null;
    }
}
