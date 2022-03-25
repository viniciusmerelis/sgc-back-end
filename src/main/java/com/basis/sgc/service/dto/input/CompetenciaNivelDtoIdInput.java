package com.basis.sgc.service.dto.input;

import com.basis.sgc.enums.Nivel;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class CompetenciaNivelDtoIdInput implements Serializable {
    @NotNull
    private Integer id;
    @NotNull
    private Nivel nivel;
}
