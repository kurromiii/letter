package com.mftplus.letter.model.service.interfaces;

import com.mftplus.letter.model.entity.ProfileDto;

import java.util.List;
import java.util.Optional;

public interface ProfileDTOService {
    void save(ProfileDto profileDto) throws Exception;
    void edit(ProfileDto profileDto) throws Exception;
    void remove(ProfileDto profileDto) throws Exception;
    void removeById(Long id) throws Exception;

    Optional<ProfileDto> findById(Long id) throws Exception;
    Optional<ProfileDto> findByUsername(String username) throws Exception;
    List<ProfileDto> findAll() throws Exception;
}
