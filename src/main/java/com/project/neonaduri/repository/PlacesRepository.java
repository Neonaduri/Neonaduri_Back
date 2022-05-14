package com.project.neonaduri.repository;


import com.project.neonaduri.model.Places;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Places, Long> {

//    List<Places> findByPlaceNameContaining(String placeName);
}
