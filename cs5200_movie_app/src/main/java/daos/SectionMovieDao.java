package daos;

import Repositories.MovieRepository;
import Repositories.SectionRepository;
import models.Movie;
import models.Section;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class SectionMovieDao {

  SectionRepository sectionRepository;
  MovieRepository movieRepository;

  @GetMapping("/addSection/{sectionId}/toMovie/{movieId}")
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

  @GetMapping("/removeSection/{sectionId}/fromMovie/{movieId}")
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
