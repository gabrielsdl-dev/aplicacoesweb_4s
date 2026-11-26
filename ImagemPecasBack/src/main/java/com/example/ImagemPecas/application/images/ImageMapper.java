package com.example.ImagemPecas.application.images;
import com.example.ImagemPecas.domain.entity.Image;
import com.example.ImagemPecas.domain.enums.ImageExtension;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class ImageMapper {
    public Image mapToImage(MultipartFile file, String name, List<String> tags) throws IOException
    {
    return Image.builder()
            .name(name)
            .tags(String.join(",", tags))
            .size(file.getSize())
            .extension(extensionOf(file))
            .file(file.getBytes())
            .build();

    }

    /** Retorna a extensão suportada do arquivo, ou null se o formato não for aceito. */
    public ImageExtension extensionOf(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType == null || contentType.isBlank()) {
            return null;
        }
        try {
            return ImageExtension.valueof(MediaType.valueOf(contentType));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public ImageDTO imageToDTO(Image image, String url){
        return ImageDTO.builder()
                .url(url)
                .extension(image.getExtension() != null ? image.getExtension().name() : null)
                .name(image.getName())
                .size(image.getSize())
                .uploadDate(image.getUploadDate() != null ? image.getUploadDate().toLocalDate() : null)
                .build();
    }


}
