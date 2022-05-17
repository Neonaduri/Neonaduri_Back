package com.project.neonaduri.post.days.repository;


import com.project.neonaduri.post.days.model.Days;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaysRepository extends JpaRepository<Days, Long> {

//    List<Days> findByPlacesIn(Collection<List<Places>> places);
}
