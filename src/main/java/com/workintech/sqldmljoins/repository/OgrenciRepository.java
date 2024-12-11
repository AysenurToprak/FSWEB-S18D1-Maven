package com.workintech.sqldmljoins.repository;

import com.workintech.sqldmljoins.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {


    //Kitap alan öğrencilerin öğrenci bilgilerini listeleyin..
    String QUESTION_2 = "Select o.* from ogrenci as o Inner Join islem as i On o.ogrno = i.ogrno";
    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findStudentsWithBook();


    //Kitap almayan öğrencileri listeleyin.
    String QUESTION_3 = "Select o.* from ogrenci as o Left Join islem as i On o.ogrno = i.ogrno where i.ogrno is null";
    @Query(value = QUESTION_3, nativeQuery = true)
    List<Ogrenci> findStudentsWithNoBook();

    //10A veya 10B sınıfındaki öğrencileri sınıf ve okuduğu kitap sayısını getirin.
    String QUESTION_4 = "Select o.sinif, count(i.kitapno) from ogrenci as o left Join islem as i On o.ogrno = i.ogrno where o.sinif in('10A','10B') group by o.sinif";
    @Query(value = QUESTION_4, nativeQuery = true)
    List<KitapCount> findClassesWithBookCount();

    //Öğrenci tablosundaki öğrenci sayısını gösterin
    String QUESTION_5 = "Select count(o.ogrno) from ogrenci as o ";
    @Query(value = QUESTION_5, nativeQuery = true)
    Integer findStudentCount();

    //Öğrenci tablosunda kaç farklı isimde öğrenci olduğunu listeleyiniz.
    String QUESTION_6 = "Select count(distinct o.ad) from ogrenci as o ";
    @Query(value = QUESTION_6, nativeQuery = true)
    Integer findUniqueStudentNameCount();

    //--İsme göre öğrenci sayılarının adedini bulunuz.
    //--Ali: 2, Mehmet: 3
    String QUESTION_7 = "Select o.ad, count(o.ad) from ogrenci as o group by o.ad";
    @Query(value = QUESTION_7, nativeQuery = true)
    List<StudentNameCount> findStudentNameCount();


    String QUESTION_8 = "Select o.sinif, count(o.ad) from ogrenci as o group by o.sinif";
    @Query(value = QUESTION_8, nativeQuery = true)
    List<StudentClassCount> findStudentClassCount();

    String QUESTION_9 = "Select o.ad,o.soyad, count(i.kitapno) from ogrenci as o inner join islem as i on o.ogrno = i.ogrno group by o.ad,o.soyad";
    @Query(value = QUESTION_9, nativeQuery = true)
    List<StudentNameSurnameCount> findStudentNameSurnameCount();
}
