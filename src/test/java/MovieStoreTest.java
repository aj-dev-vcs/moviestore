import model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MovieStoreTest {

    private final MovieStore movieStore = new MovieStore();
    private final Movie harryPotter = new Movie("Harry Potter", "Rowling", 2000);
    private final Movie starWars = new Movie("Star Wars", "Shwimmer", 1999);
    private final Movie starTrek = new Movie("STAR Trek", "Shwimmer", 2002);
    private final Movie shawshank = new Movie("Shawshank Redemption", "Bob", 2001);
    private final Movie takeThat = new Movie("Take That", "Shwimmer", 2010);



    @Test
    public void resturnsNoResultsWhenNoTitlePartiallyMatchSearch() throws Exception{
        MovieStore movieStore = new MovieStore();
        List<Movie> results= movieStore.findByPartialTitle("abc");
        assertThat(results.size(), is(0));
    }

    @Test
    public void findsAMovieWhenTitleIsPartiallyMatched() throws Exception{
//        MovieStore movieStore = new MovieStore();
//        Movie harryPotter = new Movie("Harry Potter");
//
//        movieStore.add(harryPotter);
//        movieStore.add(new Movie("Shawshank Redemption"));
//        movieStore.add(new Movie("Star Wars"));
//        movieStore.add(new Movie("Star Trek"));

        List<Movie> results= movieStore.findByPartialTitle("arry");

        assertThat(results.size(), is(1));
        assertThat(String.valueOf(results.contains(harryPotter)), results.contains(harryPotter));
    }

    @Before
    public void setUp() throws Exception {
        movieStore.add(harryPotter);
        movieStore.add(shawshank);
        movieStore.add(starWars);
        movieStore.add(starTrek);
        movieStore.add(takeThat);

    }

    @Test
    public void findsMoviesWhenTitleArePartiallyMatched() throws Exception{
        List<Movie> results= movieStore.findByPartialTitle("tar");

        assertThat(results.size(), is(2));
        assertThat(String.valueOf(results.contains(starTrek)), results.contains(starTrek));
    }

    @Test
    public void findsMoviesWhenDirectorExactlyMatches() throws Exception{
        List<Movie> results= movieStore.findByDirector("Shwimmer");

        assertThat(results.size(), is(3));
//        assertThat(results, contains(starTrek, starWars, takeThat));
    }

    @Test
    public void findsMoviesWhenReleaseYearIsBetweenTwoValues() throws Exception{
        List<Movie> results= movieStore.findByReleaseYear(1999,2002);

        assertThat(results.size(), is(2));
//        assertThat(results, contains(harryPottery, shawshank));
    }
}