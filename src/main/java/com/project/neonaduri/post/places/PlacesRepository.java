package com.project.neonaduri.post.places;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlacesRepository extends JpaRepository<Places, Long> {

//    List<Places> findByPlaceNameContaining(String placeName);
}
