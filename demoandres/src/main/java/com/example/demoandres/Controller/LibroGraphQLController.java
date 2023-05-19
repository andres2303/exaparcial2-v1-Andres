package com.example.demoandres.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demoandres.Entity.Autor;
import com.example.demoandres.Entity.Editorial;
import com.example.demoandres.Entity.Libro;
import com.example.demoandres.Repository.AutorRepository;
import com.example.demoandres.Repository.EditorialRepository;
import com.example.demoandres.Repository.LibroRepository;
import com.example.demoandres.dto.LibroRequest;

@Controller
public class LibroGraphQLController {

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private EditorialRepository editorialRepository;
	
	@Autowired
	private LibroRepository libroRepository;
	
	@QueryMapping
	public List<Autor> listaAutor(){
		return autorRepository.findAll();
	}
	
	@QueryMapping
	public List<Editorial> listaEditorial(){
		return editorialRepository.findAll();
	}
	
	@QueryMapping
	public List<Libro> listaLibro(){
		return libroRepository.findAll();
	}
	
	@QueryMapping
    public Libro listarLibroById(@Argument String id) {
        return libroRepository.findById(id).orElse(null);
    }
	
	@QueryMapping
    public Editorial listarEditorialById(@Argument Long id) {
        return editorialRepository.findById(id).orElse(null);
    }
	
	@QueryMapping
    public Autor listarAutorById(@Argument Long id) {
        return autorRepository.findById(id).orElse(null);
    }
	
    @MutationMapping
    public Libro actualizarLibro(@Argument String id,@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autorId()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorialId()).orElse(null);
        Libro libroBDd = new Libro();
        
        libroBDd.setId(id);
        libroBDd.setTitulo(libroRequest.titulo());
        libroBDd.setDescripcion(libroRequest.descripcion());
        libroBDd.setPaginas(libroRequest.paginas());
        libroBDd.setEdicion(libroRequest.edicion());
        libroBDd.setAutor(autor);
        libroBDd.setEditorial(editorial);

        return libroRepository.save(libroBDd);
    }
    
	@MutationMapping
	public void eliminarLibro(@Argument String id) {
		libroRepository.deleteById(id);
	}
	
	@MutationMapping
	public void eliminarAutor(@Argument Long id) {
		autorRepository.deleteById(id);
	}
	@MutationMapping
	public void eliminarEditorial(@Argument Long id) {
		editorialRepository.deleteById(id);
	}
}
