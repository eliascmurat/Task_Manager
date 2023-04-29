package br.com.islink.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatus {

    TODO("Não iniciada"),
    DOING("Em andamento"),
    DONE("Pronta");

    private String name;

}
