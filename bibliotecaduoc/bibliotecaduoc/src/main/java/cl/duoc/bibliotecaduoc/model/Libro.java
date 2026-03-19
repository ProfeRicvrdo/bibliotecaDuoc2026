package cl.duoc.bibliotecaduoc.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Libro {

    private int id;
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private String fechaPublicacion;

}
