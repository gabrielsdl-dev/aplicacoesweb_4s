package com.example.ImagemPecas.application.images;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/v1/images")

public class ImagesController {
    @PostMapping //TUDO QUE ESTÁ COM O @ É UMA ANOTAÇÃO
    public ResponseEntity save(
            @RequestParam("file")MultipartFile file,
            @RequestParam("name") String name,
            @RequestParam("tags") List<String> tags
            )
    {
        return ResponseEntity.ok().build();

    }
}
