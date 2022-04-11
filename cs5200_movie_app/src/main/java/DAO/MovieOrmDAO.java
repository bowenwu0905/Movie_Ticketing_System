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

  @PostMapping("/girlspower/movies")
  public Movie createMovie(@RequestBody Movie movie){
    return movieRepository.save(movie);
  }

  @GetMapping("/girlspower/movies")
  public List<Movie> findAllMovies(){
    return (List<Movie>) movieRepository.findAll();
  }

  @GetMapping("/girlspower/movies/{movieId}")
  public Movie findMoviesById(
    @PathVariable("movieId") Integer id){
    return movieRepository.findById(id).get();
  }

  @PutMapping("/girlspower/movies/{movieId}")
  public Movie updateMovie(
      @PathVariable("movieId") Integer id,
      @RequestBody() Movie newMovie) {
    Movie movie = this.findMoviesById(id);
    movie.setMovie_name(newMovie.getMovie_name());
    movie.setType(newMovie.getType());
    return movieRepository.save(movie);
  }

  @DeleteMapping("/girlspower/movies/{movieId}")
  public void deleteMovie(
      @PathVariable("movieId") Integer id) {
    movieRepository.deleteById(id);
  }


}
