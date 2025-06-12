package com.example.demo;

import com.example.demo.entity.Rating;
import com.example.demo.entity.User;
import com.example.demo.repository.RatingRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;

    @Autowired
    public RatingService(UserRepository userRepository,RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
        this.userRepository = userRepository;
    }

    public Rating createRating(Rating rating, String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!isValidRating(rating)) {
            throw new IllegalArgumentException("All rating values must be between 1 and 5");
        }
        if(user.getRole() == User.Role.ADMIN){
            throw new IllegalArgumentException("You are not allowed to add rating as an admin");
        }

        rating.setUser(user);
        return ratingRepository.save(rating);
    }

    private boolean isValidRating(Rating rating) {
        return isInRange(rating.getAmbiance()) &&
                isInRange(rating.getFood()) &&
                isInRange(rating.getService()) &&
                isInRange(rating.getCleanliness()) &&
                isInRange(rating.getDrinks());
    }

    private boolean isInRange(int value) {
        return value >= 1 && value <= 5;
    }

    public List<Rating> getAllRatings(String email) throws Exception {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

//        if(user.getRole() == User.Role.USER){
//            throw new Exception("You are not allowed to view ratings as an user");
//        }
        return ratingRepository.findAll();
    }

public List<Rating> filterRatings(
        Integer ambiance,
        Integer food,
        Integer service,
        Integer cleanliness,
        Integer drinks
) {
    List<Rating> allRatings = ratingRepository.findAll();

    return allRatings.stream()
            .filter(r -> ambiance == null || r.getAmbiance() == ambiance)
            .filter(r -> food == null || r.getFood() == food)
            .filter(r -> service == null || r.getService() == service)
            .filter(r -> cleanliness == null || r.getCleanliness() == cleanliness)
            .filter(r -> drinks == null || r.getDrinks() == drinks)
            .collect(Collectors.toList());
}


    public Map<String, Double> getRatingsReport() {
        List<Rating> ratings = ratingRepository.findAll();
        Map<String, Double> report = new HashMap<>();

        if (ratings.isEmpty()) return report;

        double ambianceAvg = ratings.stream().mapToInt(Rating::getAmbiance).average().orElse(0.0);
        double foodAvg = ratings.stream().mapToInt(Rating::getFood).average().orElse(0.0);
        double serviceAvg = ratings.stream().mapToInt(Rating::getService).average().orElse(0.0);
        double cleanlinessAvg = ratings.stream().mapToInt(Rating::getCleanliness).average().orElse(0.0);
        double drinksAvg = ratings.stream().mapToInt(Rating::getDrinks).average().orElse(0.0);

        double overallAvg = (ambianceAvg + foodAvg + serviceAvg + cleanlinessAvg + drinksAvg) / 5.0;

        report.put("Ambiance", ambianceAvg);
        report.put("Food", foodAvg);
        report.put("Service", serviceAvg);
        report.put("Cleanliness", cleanlinessAvg);
        report.put("Drinks", drinksAvg);
        report.put("Overall", overallAvg);

        return report;
    }
}
