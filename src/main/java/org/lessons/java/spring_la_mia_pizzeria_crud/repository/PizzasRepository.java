package org.lessons.java.spring_la_mia_pizzeria_crud.repository;
import org.lessons.java.spring_la_mia_pizzeria_crud.models.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PizzasRepository extends JpaRepository<Pizza , Integer> {
    
}
