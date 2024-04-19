package com.alura.challenge.conversor.modelos;

import java.util.ArrayList;
import java.util.Map;

public record RequestCurrency(Map<String, Double> conversion_rates, ArrayList<ArrayList<String>> supported_codes) {
}
