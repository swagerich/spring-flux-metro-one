package com.metro.one.utils.enums;

import lombok.Getter;

@Getter
public enum DocumentTypeEnum {

    DNI("DNI"),
    PASSPORT("PASSPORT");

    public final String value;

    DocumentTypeEnum(String value) {
        this.value = value;
    }
}
