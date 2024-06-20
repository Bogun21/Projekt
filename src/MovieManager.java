import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {
    private List<Movie> movies = new ArrayList<>();
    private List<RentalHistoryEntry> rentalHistory = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void removeMovie(int id) {
        movies.removeIf(movie -> movie.getId() == id);
    }

    public void updateMovie(int id, Movie updatedMovie) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getId() == id) {
                movies.set(i, updatedMovie);
                return;
            }
        }
    }

    public void rentMovie(int movieId, int userId) {
        rentalHistory.add(new RentalHistoryEntry(movieId, userId, LocalDate.now(), null));
    }

    public void returnMovie(int movieId, LocalDate returnDate) {
        for (RentalHistoryEntry entry : rentalHistory) {
            if (entry.getMovieId() == movieId && entry.getReturnDate() == null) {
                entry.setReturnDate(returnDate);
                return;
            }
        }
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

    public List<RentalHistoryEntry> getRentalHistory() {
        return new ArrayList<>(rentalHistory);
    }


    public List<Movie> searchMoviesByTitle(String title) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                result.add(movie);
            }
        }
        return result;
    }

    public List<Movie> searchMoviesByCategory(String category) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getCategory().equalsIgnoreCase(category)) {
                result.add(movie);
            }
        }
        return result;
    }
}
