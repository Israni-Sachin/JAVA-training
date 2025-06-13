package com.example.demo.controller;


import com.example.demo.RatingService;
import com.example.demo.entity.Rating;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/ratings")
public class AdminController {

    private final RatingService ratingService;
    private final UserRepository userRepository;

    @Autowired
    public AdminController(RatingService ratingService, UserRepository userRepository) {
        this.ratingService = ratingService;
        this.userRepository = userRepository;
    }

    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Rating> getAllRatings(Principal principal) throws Exception{
        return ratingService.getAllRatings(principal.getName());
    }

    @GetMapping("/filter")
//    @PreAuthorize("hasRole('ADMIN')")
    public List<Rating> filterRatings(
            @RequestParam(required = false) Integer ambiance,
            @RequestParam(required = false) Integer food,
            @RequestParam(required = false) Integer service,
            @RequestParam(required = false) Integer cleanliness,
            @RequestParam(required = false) Integer drinks
    ) {
        return ratingService.filterRatings(ambiance, food, service, cleanliness, drinks);
    }

    @GetMapping("/report")
//    @PreAuthorize("hasRole('ADMIN')")
    public Map<String, Double> getRatingReport() {
        return ratingService.getRatingsReport();
    }
}
