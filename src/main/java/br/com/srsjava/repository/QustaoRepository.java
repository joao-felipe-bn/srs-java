package br.com.srsjava.repository;

import br.com.srsjava.entity.QuestaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface QustaoRepository extends JpaRepository<QuestaoEntity, BigInteger> {
}