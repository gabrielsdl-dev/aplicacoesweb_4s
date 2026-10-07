package com.example.ImagemPecas.infra.repository;

import com.example.ImagemPecas.domain.entity.Image;
import com.example.ImagemPecas.domain.enums.ImageExtension;
import com.example.ImagemPecas.infra.repository.specs.GenericSpecs;
import com.example.ImagemPecas.infra.repository.specs.ImageSpecs;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.ImagemPecas.infra.repository.specs.ImageSpecs.*;
import static org.springframework.data.jpa.domain.Specification.anyOf;
import static org.springframework.data.jpa.domain.Specification.where;


public interface ImageRepository extends JpaRepository<Image, String>,
        JpaSpecificationExecutor<Image> {

    default List<Image> findByExtensionAndNameOrTags(ImageExtension extension, String query){
        //SELECT * FROM IMAGE WHERE 1 = 1
        //Specification<Image> conjunction = (root, q, criteriaBuilder) -> criteriaBuilder.conjunction();
        //Specification<Image> spec = Specification.where(conjunction);

        Specification<Image> spec = where(GenericSpecs.conjunction());

        if(extension != null){
            //AND EXTENSION = 'PNG'
            spec = spec.and(extensionEqual(extension));
        }

        if(StringUtils.hasText(query)){
            //Specification<Image> nameLike = (root, q, cb) -> cb.like(cb.upper(root.get("name")), "%" + query.toUpperCase() + "%");
            //Specification<Image> tagsLike = (root, q, cb) -> cb.like(cb.upper(root.get("tags")), "%" + query.toUpperCase() + "%");

            //Specification<Image> nameOrTagsLike = Specification.anyOf(nameLike, tagsLike);

            spec = spec.and(anyOf(nameLike(query), tagsLike(query)));
        }

        return findAll(spec);
    }
}
