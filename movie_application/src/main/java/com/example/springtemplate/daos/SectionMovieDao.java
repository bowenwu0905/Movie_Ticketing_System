package com.example.springtemplate.daos;

import com.example.springtemplate.models.Movie;
import com.example.springtemplate.models.Section;
import com.example.springtemplate.repositories.MovieRepository;
import com.example.springtemplate.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class SectionMovieDao {
  @Autowired
  SectionRepository sectionRepository;
  @Autowired
  MovieRepository movieRepository;

  @GetMapping("/girlspower/addSection/{sectionId}/toMovie/{movieId}")
  public Movie addSectionToMovie(
      @PathVariable("sectionId") Integer sectionId,
      @PathVariable("movieId") Integer movieId
  ){
    Movie movie = movieRepository.findById(movieId).get();
    Section section = sectionRepository.findById(sectionId).get();
    movie.getSections().add(section);
    section.setMovie(movie);
    sectionRepository.save(section);
    return movie;
  }

  @GetMapping("/girlspower/removeSection/{sectionId}/fromMovie/{movieId}")
  public Movie removeSectionFromMovie(
      @PathVariable("sectionId") Integer sectionId,
      @PathVariable("movieId") Integer movieId
  ){
    Movie movie = movieRepository.findById(movieId).get();
    Section section = sectionRepository.findById(sectionId).get();
    movie.getSections().remove(section);
    section.setMovie(null);
    sectionRepository.save(section);
    return movie;

  }


}
