package com.systems.caloriecounter.repository;

import com.systems.caloriecounter.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {


  Profile findByEmail(String email);

}
