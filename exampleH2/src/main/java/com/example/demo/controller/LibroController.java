package com.example.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DaoLibro;
import com.example.demo.model.Libro;

@RestController
public class LibroController
{

    @Autowired
    DaoLibro repositorio;

    @RequestMapping(value = "/libro", produces = MediaType.APPLICATION_JSON_VALUE)
    public Libro getLibro()
    {

        return repositorio.buscarLibro(1);
    }

    @RequestMapping(value = "/libros", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Libro> getLibros()
    {

        return repositorio.recuperarTodosLibros();
    }

    @PostConstruct
    public void provisionaLibros()
    {
        repositorio.altaLibro(new Libro("alguno"));
    }
}
