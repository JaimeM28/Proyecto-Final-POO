package Utilerias;
import Archivos.Archivo;
import Biblioteca.*;
import Usuarios.Administrador;

import java.util.*;

public class Utilidades  {
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

    //orden por genero
    public  void prueba()
	{
		List<Libro> dat = new ArrayList<>(Arrays.asList(new Libro("Harry Potter1","Jk Rwoling",2000,"Ficcion","Ecurium",123456,500,true,5,true),
										                new Libro("Harry Potter2","Jk Rwoling",2000,"Romance","Ecurium",123456,500,true,5,true),
										                new Libro("Harry Potter3","Jk Rwoling",2000,"Ficcion","Ecurium",123456,500,true,5,true),
										                new Libro("Harry Potter3","Jk Rwoling",2000,"Romance","Ecurium",123456,500,true,5,true)
										));

		Collections.sort(dat);
		System.out.println(dat);
		
	}

    

}
