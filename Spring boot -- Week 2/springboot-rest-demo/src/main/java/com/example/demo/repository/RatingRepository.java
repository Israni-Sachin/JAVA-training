package com.example.demo.repository;

import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    // JpaRepository gives you all CRUD methods by default!!!
    List<Rating> findByUser(User user);
    List<Rating> findByAmbianceAndFood(int ambiance, int food);
}
