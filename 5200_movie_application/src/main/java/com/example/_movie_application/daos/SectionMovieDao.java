package com.example._movie_application.daos;

import com.example._movie_application.models.Movie;
import com.example._movie_application.Repositories.MovieRepository;
import com.example._movie_application.Repositories.SectionRepository;
import com.example._movie_application.models.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SectionMovieDao {

  SectionRepository sectionRepository;
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
