package main;

import com.alura.challenge.conversor.interfaz.Window;
import com.alura.challenge.conversor.modelos.Connect;
import com.alura.challenge.conversor.modelos.Currency;
import com.alura.challenge.conversor.modelos.RequestCurrency;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.http.HttpResponse;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Connect con = new Connect();
        HttpResponse<String> response;
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        response = con.request("latest/" + "ARS");

        RequestCurrency curr = gson.fromJson(response.body(), RequestCurrency.class);
        Currency moneda = new Currency(curr);
        response = con.request("codes");
        curr = gson.fromJson(response.body(), RequestCurrency.class);
        moneda.store(curr);
        System.out.println(moneda.getNameList());

        System.out.println("Prueba introduce cualquier cosa.");
        int in = input.nextInt();
        List<Map.Entry<String,String>> list = new ArrayList<>(moneda.getNameList().entrySet());
        Map.Entry<String, String> primerPar = list.get(in);
        String primeraClave = primerPar.getKey();
        String primerValor = primerPar.getValue();
        System.out.println(primeraClave + " " + primerValor);

        System.out.println("Tomando el valor del lugar: " + moneda.getName().get(in+1));
        System.out.println("¿Cuántos " + moneda.getName().get(0) + " a " + moneda.getName().get(in+1) + " quieres convertir?");
        Double ind = input.nextDouble();
        Double lo = ind * moneda.getValue().get(in+1);
        System.out.println(lo);


    }
}
