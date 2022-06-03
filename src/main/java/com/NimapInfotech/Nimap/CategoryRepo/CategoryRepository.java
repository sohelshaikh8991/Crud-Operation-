package com.NimapInfotech.Nimap.CategoryRepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.NimapInfotech.Nimap.CategoryEntity.Category;
import com.NimapInfotech.Nimap.ProductDto.ProductDto;

@Repository()
public interface CategoryRepository extends CrudRepository<Category,Long>{

}
