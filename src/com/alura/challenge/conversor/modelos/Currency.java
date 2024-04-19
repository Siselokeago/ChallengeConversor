package com.alura.challenge.conversor.modelos;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Currency extends Unit {

    public Currency(RequestCurrency req){
        this.setName(new ArrayList<>(req.conversion_rates().keySet()));
        this.setValue(new ArrayList<>(req.conversion_rates().values()));
        System.out.println(this.getName());
        System.out.println(this.getValue());
    }

    public void store(RequestCurrency curr){
        Map<String, String> map = new TreeMap<>();
        curr.supported_codes().forEach( pair -> map.put(pair.get(0), pair.get(1)));
        this.setNameList(map);

    }

}
