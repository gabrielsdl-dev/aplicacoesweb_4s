package com.example.ImagemPecas.infra.repository;

import com.example.ImagemPecas.domain.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository <Image, String> {

}
