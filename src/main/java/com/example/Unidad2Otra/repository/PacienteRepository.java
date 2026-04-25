package com.example.Unidad2Otra.repository;

import com.example.Unidad2Otra.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p FROM Paciente p WHERE p.apellido = :apellido")
    List<Paciente> buscarPorApellidos(@Param("apellido")String apellido);

    @Query(value = "SELECT * FROM paciente WHERE correo= :correo", nativeQuery = true)
    Paciente buscarPorCorreo(@Param("correo") String correo);

}
