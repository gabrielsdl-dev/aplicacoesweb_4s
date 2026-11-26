package com.example.ImagemPecas.domain.enums;

import lombok.Getter;
import org.springframework.http.MediaType;

import java.util.Arrays;

public enum ImageExtension {
    PNG(MediaType.IMAGE_PNG),
    JPEG(MediaType.IMAGE_JPEG),
    GIF(MediaType.IMAGE_GIF);


    @Getter
    private final MediaType mediaType;

    ImageExtension(MediaType mediaType){
        this.mediaType = mediaType;
    }

    public static ImageExtension valueof(MediaType mediaType){
        if (mediaType == null) {
            return null;
        }
        return Arrays.stream(values()).filter(ie -> ie.mediaType.equals(mediaType))
                .findFirst()
                .orElse(null);
    }

    public static ImageExtension ofName(String name){
        if (name == null || name.isBlank()) {
            return null;
        }
        // Aceita "JPG" como apelido de JPEG
        if (name.equalsIgnoreCase("JPG")) {
            return JPEG;
        }
        return Arrays.stream(values())
                .filter(ie -> ie.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
