package com.metro.one.utils.enums;

import lombok.Getter;

@Getter
public enum UserRoleEnum {

    MANAGER("MANAGER"),
    USER("USER");

    public final String value;

    UserRoleEnum(String value) {
        this.value = value;
    }

}
