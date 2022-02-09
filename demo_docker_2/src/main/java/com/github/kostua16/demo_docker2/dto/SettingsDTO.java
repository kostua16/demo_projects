package com.github.kostua16.demo_docker2.dto;

public class SettingsDTO {

    private String name;

    private String value;

    public SettingsDTO() {
        this("default", "default");
    }

    public SettingsDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }


    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

}
