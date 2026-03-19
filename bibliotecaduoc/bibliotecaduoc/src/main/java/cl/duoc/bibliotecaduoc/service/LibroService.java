package cl.duoc.bibliotecaduoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.bibliotecaduoc.model.Libro;
import cl.duoc.bibliotecaduoc.repository.LibroRepository;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;


    public List<Libro> getLibros(){
        return libroRepository.obtenerLista();
    }



    public int getCantLibros(){
        return libroRepository.obtenerLista().size();
    }

    public void saveLibro(Libro libro){
        libroRepository.agregarLibro(libro);
    }


    public Libro findByIsbn(String isbn){
        return libroRepository.buscarPorIsbn(isbn);
    }

    public Libro findById(int id){
        return libroRepository.buscarPorId(id);
    }

    public void delete(int id){
        libroRepository.eliminarLibro(id);
    }

    public void updateLibro(Libro libro){
        libroRepository.actualizarLibro(libro);
    }


}
