package com.desenior.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.desenior.model.Categoria;
import com.desenior.model.Plato;

public class PlatoService {
    private List<Plato> platos;


    public PlatoService(List<Plato> platos) {
        this.platos = platos;
    }

    public List<Plato> filtrarPlatos(double presupuesto, Categoria categoria) {
        return platos.stream()
                .filter(plato -> plato.getPrecio() <= presupuesto && plato.getCategoria() == categoria)
                .sorted((p1,p2) -> Double.compare(p1.getPrecio(), p2.getPrecio()))
                .collect(Collectors.toList()); 
    }

    public List<Plato> top3Saludables() {
        return platos.stream()
                .sorted((p1, p2) -> Integer.compare(p1.getCalorias(), p2.getCalorias())) 
                .limit(3) 
                .collect(Collectors.toList());
    }

    public Map<Categoria, List<Plato>> agruparPorCategoria() {
        return platos.stream()
                .collect(Collectors.groupingBy(Plato::getCategoria));
    }



 
}
