package com.applications.werainkhatri.phonebook;

import android.support.annotation.NonNull;

import java.lang.annotation.Annotation;

public class Contact {
    private String name;
    private long number;

    public Contact(String name, long number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public long getNumber() {
        return number;
    }

    @NonNull
    @Override
    public String toString() {
        return name + "`" + number;
    }
}
