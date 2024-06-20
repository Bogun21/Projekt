import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class MovieRentalApp {
    private static UserManager userManager = new UserManager();
    private static MovieManager movieManager = new MovieManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Wybierz opcję:");
            System.out.println("1. Filmy");
            System.out.println("2. Użytkownicy");
            System.out.println("3. Wyświetl historię wypożyczeń");
            System.out.println("4. Wyjście");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    movieOptions(scanner);
                    break;
                case 2:
                    userOptions(scanner);
                    break;
                case 3:
                    displayRentalHistory();
                    break;
                case 4:
                    System.out.println("Zakończono.");
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void movieOptions(Scanner scanner) {
        while (true) {
            System.out.println("Opcje dotyczące filmów:");
            System.out.println("1. Dodaj film");
            System.out.println("2. Usuń film");
            System.out.println("3. Zaktualizuj film");
            System.out.println("4. Wypożycz film");
            System.out.println("5. Zwróć film");
            System.out.println("6. Szukaj filmów");
            System.out.println("7. Wyświetl wszystkie filmy");
            System.out.println("8. Powrót do głównego menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMovie(scanner);
                    break;
                case 2:
                    removeMovie(scanner);
                    break;
                case 3:
                    updateMovie(scanner);
                    break;
                case 4:
                    rentMovie(scanner);
                    break;
                case 5:
                    returnMovie(scanner);
                    break;
                case 6:
                    searchMovies(scanner);
                    break;
                case 7:
                    displayAllMovies();
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void userOptions(Scanner scanner) {
        while (true) {
            System.out.println("Opcje dotyczące użytkowników:");
            System.out.println("1. Dodaj użytkownika");
            System.out.println("2. Usuń użytkownika");
            System.out.println("3. Wyświetl wszystkich użytkowników");
            System.out.println("4. Powrót do głównego menu");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addUser(scanner);
                    break;
                case 2:
                    removeUser(scanner);
                    break;
                case 3:
                    displayAllUsers();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
        }
    }

    private static void addMovie(Scanner scanner) {
        System.out.println("Podaj tytuł filmu:");
        String title = scanner.nextLine();

        System.out.println("Podaj rok produkcji:");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj kategorię:");
        String category = scanner.nextLine();

        System.out.println("Podaj ilość:");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Movie movie = new Movie.MovieBuilder()
                .setTitle(title)
                .setYear(year)
                .setCategory(category)
                .setQuantity(quantity)
                .build();

        movieManager.addMovie(movie);
        System.out.println("Film został dodany: " + movie);
    }

    private static void removeMovie(Scanner scanner) {
        System.out.println("Podaj ID filmu do usunięcia:");
        int id = scanner.nextInt();
        scanner.nextLine();

        movieManager.removeMovie(id);
        System.out.println("Film o ID " + id + " został usunięty.");
    }

    private static void updateMovie(Scanner scanner) {
        System.out.println("Podaj ID filmu do aktualizacji:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj nowy tytuł filmu:");
        String title = scanner.nextLine();

        System.out.println("Podaj nowy rok produkcji:");
        int year = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj nową kategorię:");
        String category = scanner.nextLine();

        System.out.println("Podaj nową ilość:");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Movie updatedMovie = new Movie.MovieBuilder()
                .setTitle(title)
                .setYear(year)
                .setCategory(category)
                .setQuantity(quantity)
                .build();

        movieManager.updateMovie(id, updatedMovie);
        System.out.println("Film o ID " + id + " został zaktualizowany.");
    }

    private static void rentMovie(Scanner scanner) {
        System.out.println("Podaj ID filmu do wypożyczenia:");
        int movieId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj ID użytkownika wypożyczającego film:");
        int userId = scanner.nextInt();
        scanner.nextLine();

        movieManager.rentMovie(movieId, userId);
        System.out.println("Film o ID " + movieId + " został wypożyczony przez użytkownika o ID " + userId + ". Maksymalny termin zwrotu: " + LocalDate.now().plusDays(14));
    }

    private static void returnMovie(Scanner scanner) {
        System.out.println("Podaj ID filmu do zwrotu:");
        int movieId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj datę zwrotu (RRRR-MM-DD):");
        String returnDateStr = scanner.nextLine();
        LocalDate returnDate = LocalDate.parse(returnDateStr);

        movieManager.returnMovie(movieId, returnDate);
        System.out.println("Film o ID " + movieId + " został zwrócony.");
    }

    private static void searchMovies(Scanner scanner) {
        System.out.println("Wybierz opcję wyszukiwania:");
        System.out.println("1. Wyszukaj po tytule");
        System.out.println("2. Wyszukaj po gatunku");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Podaj tytuł filmu:");
                String title = scanner.nextLine();
                List<Movie> moviesByTitle = movieManager.searchMoviesByTitle(title);
                moviesByTitle.forEach(System.out::println);
                break;
            case 2:
                System.out.println("Podaj gatunek filmu:");
                String category = scanner.nextLine();
                List<Movie> moviesByCategory = movieManager.searchMoviesByCategory(category);
                moviesByCategory.forEach(System.out::println);
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
        }
    }

    private static void displayAllMovies() {
        List<Movie> allMovies = movieManager.getAllMovies();
        for (Movie movie : allMovies) {
            System.out.println("Tytuł: " + movie.getTitle());
            System.out.println("Rok produkcji: " + movie.getYear());
            System.out.println("Kategoria: " + movie.getCategory());
            System.out.println("Ilość: " + movie.getQuantity());
            System.out.println();
        }
    }

    private static void addUser(Scanner scanner) {
        System.out.println("Podaj imię:");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String lastName = scanner.nextLine();

        User user = new User.Builder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .build();

        userManager.addUser(user);

    }

    private static void removeUser(Scanner scanner) {
        System.out.println("Podaj ID użytkownika do usunięcia:");
        int id = scanner.nextInt();
        scanner.nextLine();

        userManager.removeUser(id);
    }

    private static void displayAllUsers() {
        List<User> allUsers = userManager.getAllUsers();
        for (User user : allUsers) {
            System.out.println("ID: " + user.getId());
            System.out.println("Imię: " + user.getFirstName());
            System.out.println("Nazwisko: " + user.getLastName());
            System.out.println();
        }
    }

    private static void displayRentalHistory() {
        List<RentalHistoryEntry> history = movieManager.getRentalHistory();
        if (history.isEmpty()) {
            System.out.println("Brak historii wypożyczeń.");
        } else {
            System.out.println("Historia wypożyczeń:");
            for (RentalHistoryEntry entry : history) {
                System.out.println("ID Filmu: " + entry.getMovieId());
                System.out.println("ID Użytkownika: " + entry.getUserId());
                System.out.println("Data wypożyczenia: " + entry.getRentalDate());
                System.out.println("Data zwrotu: " + entry.getReturnDate());
                System.out.println();
            }
        }
    }
}
