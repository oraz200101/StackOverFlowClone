package com.example.stack.dao;

import com.example.stack.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query("SELECT t FROM Tag t order by t.name")
    List<Tag> getAllSort();
}
