package com.example.ImagemPecas.infra.repository;

import com.example.ImagemPecas.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository <Image, String> {

    Optional<Image> findById();
}
