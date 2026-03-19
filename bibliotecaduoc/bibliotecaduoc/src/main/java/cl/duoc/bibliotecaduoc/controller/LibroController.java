package cl.duoc.bibliotecaduoc.controller;

import org.springframework.web.bind.annotation.RestController;

import cl.duoc.bibliotecaduoc.model.Libro;
import cl.duoc.bibliotecaduoc.service.LibroService;

import java.util.List;

import javax.naming.spi.ResolveResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping("api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Libro> listarLibros(){
        return libroService.getLibros();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void agregarLibro(@RequestBody Libro libro){
        libroService.saveLibro(libro);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Libro> buscarPorId(@PathVariable int id){
        Libro libro =  libroService.findById(id);

        if (libro != null) {
            return ResponseEntity.ok(libro);
        }else{
            return ResponseEntity.notFound().build();

        }
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Libro> buscarPorIsbn(@PathVariable String isbn) {
        Libro libro = libroService.findByIsbn(isbn);

        if (libro != null) {
            return ResponseEntity.ok(libro);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable int id){
        libroService.delete(id);
    }


    @GetMapping("/total")
    @ResponseStatus(HttpStatus.OK)
    public int getCantidadLibros(){
        return libroService.getCantLibros();
    }
    





}
