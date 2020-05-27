package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Libro;

@Repository
public class DaoLibroImpl implements DaoLibro
{
    @PersistenceContext()
    EntityManager em;

    @Transactional
    public void altaLibro(Libro c)
    {
        em.persist(c);
    }

    @Transactional
    public void actualizarLibro(Libro c)
    {
        if (em.find(Libro.class, c.getId()) != null) {
            em.merge(c);
        }
    }

    @Transactional
    public void eliminarLibro(int idLibro)
    {
        Libro libro = em.find(Libro.class, idLibro);
        if (libro != null) {
            em.remove(libro);
        }
    }

    public Libro buscarLibro(int idLibro)
    {
        return em.find(Libro.class, idLibro);
    }

    @SuppressWarnings("unchecked")
    public List<Libro> recuperarTodosLibros()
    {
        String jpql = "Select c From Libro c";
        Query query = em.createQuery(jpql);
        return (List<Libro>) query.getResultList();
    }

}
