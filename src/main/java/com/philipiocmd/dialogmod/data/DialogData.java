package com.philipiocmd.dialogmod.data;

import com.google.gson.JsonObject;

public class DialogData {
    private String title;
    private String content;
    private JsonObject buttons;

    public DialogData(String title, String content, JsonObject buttons) {
        this.title = title;
        this.content = content;
        this.buttons = buttons;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public JsonObject getButtons() {
        return buttons;
    }
}