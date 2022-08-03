import model.Movie;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;

public class MovieStore {
    List<Movie> movies = new LinkedList<Movie>();

    public List<Movie> findByPartialTitle(final String partialTitle) {
        List<Movie> result = new LinkedList<Movie>();
        //loop through the list of movies
        for (Movie movie : movies) {
            //find a partial title match
            if(new Predicate() {
                @Override
                public boolean matches(Movie movie) {
                    return movie.title().toUpperCase().contains(partialTitle.toUpperCase());
                }
            }.matches(movie)){
                result.add(movie);
            }
        }
//        return new LinkedList<Movie>();
        return result;
    }

    public void add(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> findByDirector(final String director) {
        List<Movie> result = new LinkedList<Movie>();
        //loop through the list of movies
        for (Movie movie : movies) {
            //find a partial title match
//            if(movie.director().equals(director)){
//                result.add(movie);
//            }
            if(new Predicate() {
                @Override
                public boolean matches(Movie movie) {
                    return movie.director().equals(director);
                }
            }.matches(movie)){
                result.add(movie);
            }
        }
        return result;
    }

    public List<Movie> findByReleaseYear(final int from, final int to) {
        List<Movie> result = new LinkedList<Movie>();
        //loop through the list of movies
        for (Movie movie : movies) {
            //find a partial title match
            if(new Predicate() {
                @Override
                public boolean matches(Movie movie) {
                    return movie.releaseYear() > from && movie.releaseYear() < to;
                }
            }.matches(movie)){
                result.add(movie);
            }
        }
        return result;
    }

    interface Predicate {
        boolean matches(Movie movie);
    }
}
