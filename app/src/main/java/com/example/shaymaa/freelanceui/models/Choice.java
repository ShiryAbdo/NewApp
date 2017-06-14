package com.example.shaymaa.freelanceui.models;

import java.io.Serializable;



public class Choice implements Serializable {

    public String choice_name,choice_description;
    public int choice_id,choice_icon;

    public String getChoice_name() {
        return choice_name;
    }

    public void setChoice_name(String choice_name) {
        this.choice_name = choice_name;
    }

    public String getChoice_description() {
        return choice_description;
    }

    public void setChoice_description(String choice_description) {
        this.choice_description = choice_description;
    }

    public int getChoice_id() {
        return choice_id;
    }

    public void setChoice_id(int choice_id) {
        this.choice_id = choice_id;
    }

    public int getChoice_icon() {
        return choice_icon;
    }

    public void setChoice_icon(int choice_icon) {
        this.choice_icon = choice_icon;
    }
}
