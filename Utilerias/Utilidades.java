package Utilerias;
import Archivos.Archivo;
import Biblioteca.*;
import java.util.*;

public class Utilidades {
    ArrayList<Libro> libros = Archivo.getInstance().LeerArchivoLibro();
    /*Busqueda por titulo, autor y genero */ 

    //Busqueda por codigo
    public int search(int codigo){
        //ArrayList<Libro> libros = Archivo.getInstance().LeerArchivoLibro();
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if(libro.getCodigo()==codigo) {
                return i;
            }
        }
        return -1;
    }
    //Busqueda por titulo
    public int busquedaTitulo(String Titulo){
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if(libro.getTitulo().equals(Titulo)) {
                return i;
            }
        }
        return -1;
    }
    
    //Busqueda Autor
    public int busquedaAutor(String autor){
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if(libro.getAutor().equals(autor)) {
                return i;
            }
        }
        return -1;
    }

    //Busqueda genero
    public int busquedaGenero(String Genero){
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            if(libro.getGenero().equals(Genero)) {
                return i;
            }
        }
        return -1;
    }
}
