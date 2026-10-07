package com.example.ImagemPecas;

/*
import com.example.ImagemPecas.domain.entity.Image;
import com.example.ImagemPecas.domain.enums.ImageExtension;
import com.example.ImagemPecas.infra.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ImagemPecasApplication {
    /* Teste para gravar informações no banco
    @Bean
    public CommandLineRunner comandLineRunner(@Autowired ImageRepository repository){
        return args ->{
            Image image = Image.builder().extension(ImageExtension.PNG)
                    .name("myimage")
                    .tags("teste")
                    .size(1000L)
                    .build();
            repository.save(image);
        };
    }
    */

	public static void main(String[] args) {
        SpringApplication.run(ImagemPecasApplication.class, args);
	}

}
