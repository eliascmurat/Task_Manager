package br.com.islink.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskCategory {

    OCCASIONAL("Ocasional"),
    FIXED("Fixo"),
    SCHEDULED("Agendado");

    private String name;

}
