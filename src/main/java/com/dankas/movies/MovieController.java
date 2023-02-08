package com.dankas.movies;

import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000",allowCredentials = "true",allowedHeaders = "*")

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
public class MovieController{
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMove(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.singeMovie(imdbId),HttpStatus.OK);

    }
}
