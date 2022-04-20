package com.example.springtemplate.daos;


import com.example.springtemplate.models.Movie;
import com.example.springtemplate.models.Section;
import com.example.springtemplate.repositories.MovieRepository;
import com.example.springtemplate.repositories.SectionRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class MovieOrmDao {
  @Autowired
  MovieRepository movieRepository;
  @Autowired
  SectionRepository sectionRepository;
  @Autowired
  SectionOrmDao sectionOrmDao;

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
    movie.setMovie_type(newMovie.getMovie_type());
    return movieRepository.save(movie);
  }

  @DeleteMapping("/girlspower/movies/{movieId}")
  public void deleteMovie(
      @PathVariable("movieId") Integer id) {

    List<Section> sections = this.findMovieById(id).getSections();
    List<Integer> sectionsID = new ArrayList<>();

    for(Section section: sections){
      sectionsID.add(section.getSection_id());
    }
    for(Integer i : sectionsID){
      sectionOrmDao.deleteSection(i);
    }
    movieRepository.deleteById(id);

  }


}
