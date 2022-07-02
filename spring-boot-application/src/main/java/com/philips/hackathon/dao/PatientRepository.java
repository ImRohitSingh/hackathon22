package com.philips.hackathon.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.philips.hackathon.models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
