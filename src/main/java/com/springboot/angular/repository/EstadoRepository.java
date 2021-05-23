package com.springboot.angular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.angular.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}