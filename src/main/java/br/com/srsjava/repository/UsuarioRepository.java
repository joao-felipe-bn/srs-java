package br.com.srsjava.repository;

import br.com.srsjava.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, BigInteger> {
}