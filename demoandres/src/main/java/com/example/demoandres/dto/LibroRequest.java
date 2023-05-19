package com.example.demoandres.dto;

public record LibroRequest(
		
		String id,
		
		String titulo,
		String descripcion, 
		int paginas, 
		String edicion, 
		Long autorId,
		Long editorialId
		
		) {

}
