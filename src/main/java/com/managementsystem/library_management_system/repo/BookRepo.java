package com.managementsystem.library_management_system.repo;

import com.managementsystem.library_management_system.dto.BookSaveDTO;
import com.managementsystem.library_management_system.entity.Book;
import com.managementsystem.library_management_system.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory_Name(String category);

    List<Book> findAllByAuthor_Name(String author);


@Query(value = "SELECT * FROM Book  where author_id =:id  and category_id=:categoryId",nativeQuery = true)
    List<Book> findAllByCategoryAndAuthor(int categoryId, int id);
}
