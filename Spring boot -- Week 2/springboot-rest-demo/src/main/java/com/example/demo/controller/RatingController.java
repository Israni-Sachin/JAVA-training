package com.example.demo.controller;

import com.example.demo.entity.Rating;
import com.example.demo.RatingService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user/ratings")
public class RatingController {

    private final RatingService ratingService;
    private final UserRepository userRepository;

    @Autowired
    public RatingController(RatingService ratingService, UserRepository userRepository) {
        this.ratingService = ratingService;
        this.userRepository = userRepository;
    }

//    @PostMapping
//    public Rating createRating(@RequestBody Rating rating) {
//        return ratingService.createRating(rating);
//
//    }

//    @GetMapping("/user")
//    public Optional<User> getUser(@RequestParam String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @PostMapping("/user")
//    public User createUser(@RequestBody User user) {
//        return userRepository.save(user);
//    }

//    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public List<Rating> getAllRatings(Principal principal) throws Exception{
//        return ratingService.getAllRatings(principal.getName());
//    }

    @PostMapping
//    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> createRating(@RequestBody Rating rating, Principal principal) {
        try {
            Rating saved = ratingService.createRating(rating, principal.getName());
            return ResponseEntity.ok(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @GetMapping("/filter")
//    @PreAuthorize("hasRole('ADMIN')")
//    public List<Rating> filterRatings(
//            @RequestParam(required = false) Integer ambiance,
//            @RequestParam(required = false) Integer food,
//            @RequestParam(required = false) Integer service,
//            @RequestParam(required = false) Integer cleanliness,
//            @RequestParam(required = false) Integer drinks
//    ) {
//        return ratingService.filterRatings(ambiance, food, service, cleanliness, drinks);
//    }

    // View average per category and overall
//    @GetMapping("/report")
//    @PreAuthorize("hasRole('ADMIN')")
//    public Map<String, Double> getRatingReport() {
//        return ratingService.getRatingsReport();
//    }
}
