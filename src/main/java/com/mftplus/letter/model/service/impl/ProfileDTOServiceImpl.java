package com.mftplus.letter.model.service.impl;

import com.mftplus.letter.model.entity.Letter;
import com.mftplus.letter.model.entity.Person;
import com.mftplus.letter.model.entity.ProfileDto;
import com.mftplus.letter.model.entity.User;
import com.mftplus.letter.model.service.interfaces.ProfileDTOService;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
public class ProfileDTOServiceImpl implements ProfileDTOService {


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
//        Optional<User> user = userService.findByUsername(username);

        return Optional.empty();
    }

    @Override
    public List<ProfileDto> findAll() throws Exception {

        List<ProfileDto> profileDtoList = new ArrayList<>();
//        UserServiceImpl userService = new UserServiceImpl();
        LetterServiceImpl letterService = new LetterServiceImpl();
//        List<User> users = userService.findAll();
        List<Letter> le = letterService.findAll();
        System.out.println(le);


//        for (User user : userService.findAll()) {
//            ProfileDto profileDto = new ProfileDto();
//            profileDto.setName(user.getPerson().getName());
//            profileDto.setFamily(user.getPerson().getFamily());
//            profileDto.setNationalCode(user.getPerson().getNationalCode());
//            profileDto.setGender(String.valueOf(user.getPerson().getGender()));
//            profileDto.setUsername(user.getUsername());
//            profileDto.setPassword(user.getPassword());
//            profileDto.setRole(String.valueOf(user.getRole()));
//            profileDtoList.add(profileDto);
//        }
        return profileDtoList;
    }
}
