package instantcoffee.cinemaxx.dto;

import instantcoffee.cinemaxx.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;


@NoArgsConstructor
@Getter
@Setter
public class MovieDTOCustomer {
    private String title;
    private String description;
    private int ageRestriction;
    private int rating;
    List<ActorDTO> actors;
    private String image;
    private String poster;
    private String trailer;


    public MovieDTOCustomer(Movie movie) {
        this.title = movie.getTitle();
        this.description = movie.getDescription();
        this.ageRestriction = movie.getAgeRestriction();
        this.rating = movie.getRating();
        actors = movie.getActors().stream().map(actor -> new ActorDTO(actor.getFirstName(), actor.getLastName())).collect(Collectors.toList());
        this.image = movie.getImage();
        this.poster = movie.getPoster();
        this.trailer = movie.getTrailer();
    }

    private static ModelMapper modelMapper = new ModelMapper();

    public static MovieDTOCustomer entityToDTO(Movie movie) {
        MovieDTOCustomer movieDTO = modelMapper.map(movie, MovieDTOCustomer.class);
        return movieDTO;
    }

    public static List<MovieDTOCustomer> entityToDTO(List<Movie> movies) {
        return movies.stream().map(x -> entityToDTO(x)).collect(Collectors.toList());
    }
}
