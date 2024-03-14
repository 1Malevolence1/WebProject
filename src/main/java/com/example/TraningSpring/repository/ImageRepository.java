package com.example.TraningSpring.repository;

import com.example.TraningSpring.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
