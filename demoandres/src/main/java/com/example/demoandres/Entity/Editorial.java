package com.example.demoandres.Entity;

import java.util.Set;
//import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Editorial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idedito;
	private String nombre;
	private String pais;
	
	@OneToMany(mappedBy = "editorial")
	private Set<Libro>libros;
}
