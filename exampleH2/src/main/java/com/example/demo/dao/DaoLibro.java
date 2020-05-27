package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Libro;

public interface DaoLibro
{
    void altaLibro(Libro c);

    void actualizarLibro(Libro c);

    void eliminarLibro(int idLibro);

    Libro buscarLibro(int idLibro);

    List<Libro> recuperarTodosLibros();
}
