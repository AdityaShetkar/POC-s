package com.mcs.externalservices;

import com.mcs.model.UserRating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RATING-DATA-SERVICE", /*url = "http://localhost:8083/rating/users/"*/ url = "http://10.0.102.108:8086/ratings/users/")
public interface RatingDataService {

//    @GetMapping("/{userId}")
//    public UserRating getUserRating(@PathVariable("userId") String userId);

    @GetMapping("/users/{userId}")
    public UserRating getlistRating(@PathVariable("userId") String userId);

}
