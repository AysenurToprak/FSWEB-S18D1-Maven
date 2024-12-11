package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.Kitap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KitapRepository extends JpaRepository<Kitap, Long> {

    //Dram ve Hikaye türündeki kitapları listeleyin. JOIN kullanmadan yapın.
    String QUESTION_1 = "Select k.* from kitap as k, tur as t Where k.turno = t.turno and t.ad in ('Hikaye','Dram')";
    @Query(value = QUESTION_1, nativeQuery = true)
    List<Kitap> findBooks();


    String QUESTION_10 = "Select AVG(k.puan) from kitap as k";
    @Query(value = QUESTION_10, nativeQuery = true)
    Double findAvgPointOfBooks();


}
