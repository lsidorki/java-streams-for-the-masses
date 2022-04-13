package com.lsidorki.dto;

public class Player {

    private String firstName;
    private String lastName;
    private String city;
    private Integer goals;

    public Player(String firstName, String lastName, String city, Integer goals) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.goals = goals;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public Integer getGoals() {
        return goals;
    }

    public boolean isFrom(String cityFilter) {
        return city.equalsIgnoreCase(cityFilter);
    }
}
