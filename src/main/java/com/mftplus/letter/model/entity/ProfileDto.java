package com.mftplus.letter.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString
public class ProfileDto {
    private Long id;
    private String name;
    private String family;
    private String nationalCode;
    private String gender;
    private String username;
    private String password;
    private String role;
}
