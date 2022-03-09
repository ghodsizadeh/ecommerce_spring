package com.chandkhat.ecommerce.web.category;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class CategoryService {


    private final CategoryRepository categoryRepository;

    public static CategoryDto mapToDto(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getProducts().stream().map(ProductServicr::mapToDto).collect(Collectors.toSet())
        );

    }

    public List<CategoryDto> findAll() {
        log.debug("Request to get all Categories");
        return this.categoryRepository.findAll()
                .stream()
                .map(CategoryService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        log.debug("Request to get Category : {}", id);
        return this.categoryRepository.findById(id).map(CategoryService::mapToDto)
                .orElseThrow(IllegalStateException::new);
    }

    public CategoryDto create(CategoryDto categoryDto) {
        log.debug("Request to create Category : {}", categoryDto);
        return mapToDto(this.categoryRepository.save(
                new Category(categoryDto.getName(),
                        categoryDto.getDesctiption(),
                        Collections.emptySet()
                        )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Category : {}", id);
        this.categoryRepository.deleteById(id);
    }
}
