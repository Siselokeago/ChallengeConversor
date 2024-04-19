package com.alura.challenge.conversor.modelos;

import java.util.ArrayList;
import java.util.Map;

public class Unit {
    private Map<String, String> nameList;
    private ArrayList<Double> value;
    private ArrayList<String> name;

    public ArrayList<Double> getValue() {
        return value;
    }

    public ArrayList<String> getName() {
        return name;
    }

    public void setValue(ArrayList<Double> value) {
        this.value = value;
    }

    public void setName(ArrayList<String> name) {
        this.name = name;
    }

    public Map<String, String> getNameList() {
        return nameList;
    }

    public void setNameList(Map<String, String> nameList) {
        this.nameList = nameList;
    }
}
