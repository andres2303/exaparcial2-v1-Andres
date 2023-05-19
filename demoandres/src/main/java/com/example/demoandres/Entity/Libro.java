package com.example.demoandres.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Libro {

	@Id
	private String id;
	private String titulo;
	private String descripcion;
	private int paginas;
	private String edicion;
	
	@ManyToOne
    @JoinColumn(name="idautor")
    private Autor autor;
	
	@ManyToOne
    @JoinColumn(name="idedito")
    private Editorial editorial;
}
