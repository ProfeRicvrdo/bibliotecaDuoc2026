package cl.duoc.bibliotecaduoc.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.duoc.bibliotecaduoc.model.Libro;

@Repository
public class LibroRepository {

    private List<Libro> listaLibros = new ArrayList<>();

    public LibroRepository(){
        listaLibros.add(new Libro (1, "1234", "Papelucho", "Marcela Paz", "Salamandra", "1997"));
        listaLibros.add(new Libro (2, "2345", "Cien años de soledad", "Gabriel García Márquez", "Sudamericana", "1967"));
        listaLibros.add(new Libro (3, "3456", "Don Quijote de la Mancha", "Miguel de Cervantes", "Francisco de Robles", "1605"));
        listaLibros.add(new Libro (4, "4567", "La sombra del viento", "Carlos Ruiz Zafón", "Planeta", "2001"));
        listaLibros.add(new Libro (5, "5678", "El principito", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", "1943"));
        listaLibros.add(new Libro (6, "6789", "1984", "George Orwell", "Secker & Warburg", "1949"));
        listaLibros.add(new Libro (7, "7890", "Fahrenheit 451", "Ray Bradbury", "Ballantine Books", "1953"));
        listaLibros.add(new Libro (8, "8901", "Harry Potter y la piedra filosofal", "J.K. Rowling", "Bloomsbury", "1997"));
        listaLibros.add(new Libro (9, "9012", "El Hobbit", "J.R.R. Tolkien", "Allen & Unwin", "1937"));
        listaLibros.add(new Libro (10, "123", "Crónica de una muerte anunciada", "Gabriel García Márquez", "La Oveja Negra", "1981"));
    }

    public void agregarLibro(Libro libro){
        listaLibros.add(libro);
    }

    public List<Libro> obtenerLista(){
        return listaLibros;
    }

    public Libro buscarPorId(int idBuscado){

        for(Libro libro: listaLibros){
            if(libro.getId() == idBuscado){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbnBuscado){
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbnBuscado)) {
                return libro;
            }
        }
        return null;
    }

    public void eliminarLibro(int idEliminar){
        Libro libroEliminar = buscarPorId(idEliminar);
        listaLibros.remove(libroEliminar);
    }

    public void actualizarLibro(Libro libroActualizado){
        int pos =0;
        for(int i = 0 ; i < listaLibros.size() ; i++ ){
            if (listaLibros.get(i).getId() == libroActualizado.getId()) {
                pos = i;
            }
        }
        listaLibros.set(pos, libroActualizado);
    }









}
