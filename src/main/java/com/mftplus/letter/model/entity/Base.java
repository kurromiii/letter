package com.mftplus.letter.model.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@SuperBuilder
public class Base {
    //todo : problem with version id when editing
//    @Version
//    @JsonbTransient
//    private  Long versionId;
    @JsonbTransient
    private Boolean deleted;

}
