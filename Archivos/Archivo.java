package Archivos;
import java.io.*;
import Biblioteca.*;
import java.util.*;
import Usuarios.*;

public class Archivo {
    private static Archivo archivo; //Singleton
    private File archivoLibro;
    private File archivoUsuario;

   
    private Archivo(){
        File archivoLi = new File("Libros");
        File archivoUsu = new File("Usuarios");
        if(!archivoLi.exists()){
            try {
                archivoLi.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            } 
        }
        if(!archivoUsu.exists()){
            try {
                archivoUsu.createNewFile();
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
        this.archivoLibro = archivoLi;
        this.archivoUsuario = archivoUsu;
    }

    public ArrayList<Libro> LeerArchivoLibro(){      
        ObjectInputStream archivoLibroIn;
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            archivoLibroIn = new ObjectInputStream(new FileInputStream(archivoLibro));
            libros = (ArrayList<Libro>) archivoLibroIn.readObject();
            archivoLibroIn.close();
            return libros;
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return libros;
    }

    public void GuardarLibro(Libro libro){
        ArrayList<Libro> libros = LeerArchivoLibro();
        ObjectOutputStream archivoLibroOut;
        libros.add(libro);
        try {
            archivoLibroOut = new ObjectOutputStream(new FileOutputStream(archivoLibro));
            archivoLibroOut.writeObject(libros);
            archivoLibroOut.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public void ActualizarLibro(ArrayList<Libro> libros){
        ObjectOutputStream archivoLibroOut;
        try {
            archivoLibroOut = new ObjectOutputStream(new FileOutputStream(archivoLibro));
            archivoLibroOut.writeObject(libros);
            archivoLibroOut.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }


    public ArrayList<Usuario> LeerArchivoUsuario(){
        ObjectInputStream archivoUsuarioIn;
         
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            archivoUsuarioIn = new ObjectInputStream(new FileInputStream(archivoUsuario));
            usuarios = (ArrayList<Usuario>) archivoUsuarioIn.readObject();
            archivoUsuarioIn.close();
            return usuarios;
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return usuarios;
    }

    public void GuardarUsuario(Usuario usuario){
        ObjectOutputStream archivoUsuarioOut;
       
        ArrayList<Usuario> usuarios = LeerArchivoUsuario();
        usuarios.add(usuario);
        try {
            archivoUsuarioOut = new ObjectOutputStream(new FileOutputStream(archivoUsuario));
            archivoUsuarioOut.writeObject(usuarios);
            archivoUsuarioOut.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
   

    public static Archivo getInstance() {
        if (archivo == null) {
            archivo = new Archivo();
        }
        return archivo;
    }
}
