package br.com.bernardes.lucas.repository;

import br.com.bernardes.lucas.entity.MyObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyObjectRepository extends JpaRepository<MyObject, String> {
}
