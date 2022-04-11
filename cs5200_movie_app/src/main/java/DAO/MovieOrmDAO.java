package DAO;

import Repositories.MovieRepository;
import models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class MovieOrmDAO {
  @Autowired
  MovieRepository movieRepository;

  @PostMapping("/api/movies")
  public Movie createMovie(@RequestBody Movie movie){
    return movieRepository.save(movie);
  }

  @GetMapping("/api/movies")
  public List<Movie> findAllMovies(){
    return (List<Movie>) movieRepository.findAll();
  }

  @GetMapping("/api/movies/{movieId}")
  public Movie findMoviesById(
    @PathVariable("movieId") Integer id){
    return movieRepository.findById(id).get();
  }

  @PutMapping("/api/movies/{movieId}")
  public Movie updateMovie(
      @PathVariable("movieId") Integer id,
      @RequestBody() Movie newMovie) {
    Movie movie = this.findMoviesById(id);
    movie.setMovie_name(newMovie.getMovie_name());
    return movieRepository.save(movie);
  }

  @DeleteMapping("/api/courses/{movieId}")
  public void deleteMovie(
      @PathVariable("movieId") Integer id) {
    movieRepository.deleteById(id);
  }



}
