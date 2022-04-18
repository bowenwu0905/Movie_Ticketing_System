package com.example._movie_application.daos;

import com.example._movie_application.Repositories.MovieRepository;
import com.example._movie_application.Repositories.SectionRepository;
import com.example._movie_application.models.Movie;
import com.example._movie_application.models.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class MovieOrmDao {
  MovieRepository movieRepository;
  SectionRepository sectionRepository;

  @PostMapping("/girlspower/movies")
  public Movie createMovie(@RequestBody Movie movie){
    return movieRepository.save(movie);
  }

  @GetMapping("/girlspower/movies")
  public List<Movie> findAllMovies(){
    return (List<Movie>) movieRepository.findAll();
  }

  @GetMapping("/girlspower/movies/{movieId}")
  public Movie findMovieById(
      @PathVariable("movieId") Integer id){
    return movieRepository.findById(id).get();
  }

  @PutMapping("/girlspower/movies/{movieId}")
  public Movie updateMovie(
      @PathVariable("movieId") Integer id,
      @RequestBody() Movie newMovie) {
    Movie movie = this.findMovieById(id);
    movie.setMovie_name(newMovie.getMovie_name());
    movie.setType(newMovie.getType());
    return movieRepository.save(movie);
  }

  @DeleteMapping("/girlspower/movies/{movieId}")
  public void deleteMovie(
      @PathVariable("movieId") Integer id) {

    List<Section> sections = this.findMovieById(id).getSections();
    for(Section section: sections){
      sectionRepository.deleteById(section.getSection_id());
    }
    movieRepository.deleteById(id);

  }


}
