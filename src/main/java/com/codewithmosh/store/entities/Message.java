package com.codewithmosh.store.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Message {
    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private String text;
}
