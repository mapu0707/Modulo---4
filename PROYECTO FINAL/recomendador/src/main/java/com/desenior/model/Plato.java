package com.desenior.model;

public class Plato {
    private String nombre;
    private Double precio;
    private Categoria categoria;
    private Stand stand;
    private Integer calorias;

    public Plato(String nombre, double precio, int calorias, Categoria categoria, Stand stand) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.stand = stand;
        this.calorias = calorias;
    }

   public String getNombre() {
    return nombre;
   }

   public void setNombre(String nombre) {
    this.nombre = nombre;
   }

   public Double getPrecio() {
    return precio;
   }

   public void setPrecio(Double precio) {
    this.precio = precio;
   }

   public Categoria getCategoria() {
    return categoria;
   }

   public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
   }

   public Stand getStand() {
    return stand;
   }

   public void setStand(Stand stand) {
    this.stand = stand;
   }

   public Integer getCalorias() {
    return calorias;
   }

   public void setCalorias(Integer calorias) {
    this.calorias = calorias;
   }

   @Override
   public String toString() {
    return "Plato [nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + ", stand=" + stand
            + ", calorias=" + calorias + "]";
   }

  
    
}
