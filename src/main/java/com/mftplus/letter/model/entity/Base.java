package com.mftplus.letter.model.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
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
    @Version
    @JsonbTransient
    private  Long versionId;
    @JsonbTransient
    private boolean deleted;
}
