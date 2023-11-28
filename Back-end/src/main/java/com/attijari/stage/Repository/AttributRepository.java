package com.attijari.stage.Repository;
import com.attijari.stage.Entity.Attributs;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ComponentScan
public interface AttributRepository extends JpaRepository<Attributs, Long> {
    @Query("SELECT a FROM Attributs a LEFT JOIN FETCH a.module")
    List<Attributs> findAllWithModule();
}
