package lab3;

import java.util.*;

class Theater {
    String theaterName;
    List<Auditorium> auditoriums;

    Theater(String theaterName) {
        this.theaterName = theaterName;
        this.auditoriums = new ArrayList<>();
    }

    void addAuditorium(Auditorium auditorium) {
        auditoriums.add(auditorium);
    }
}

class Auditorium {
    int auditoriumId;
    int numberOfRows;
    int numberOfSeatsPerRow;
    SeatLayout[][] seatLayout;

    Auditorium(int auditoriumId, int numberOfRows, int numberOfSeatsPerRow) {
        this.auditoriumId = auditoriumId;
        this.numberOfRows = numberOfRows;
        this.numberOfSeatsPerRow = numberOfSeatsPerRow;
        this.seatLayout = new SeatLayout[numberOfRows][numberOfSeatsPerRow];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeatsPerRow; j++) {
                seatLayout[i][j] = new SeatLayout(i, j);
            }
        }
    }

    void displaySeats() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeatsPerRow; j++) {
                System.out.print(seatLayout[i][j].isBooked ? "X " : "O ");
            }
            System.out.println();
        }
    }
}

class SeatLayout {
    int rowNumber;
    int seatNumber;
    boolean isBooked;

    SeatLayout(int rowNumber, int seatNumber) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.isBooked = false;
    }
}

class Film {
    String filmTitle;
    int filmDuration;

    Film(String filmTitle, int filmDuration) {
        this.filmTitle = filmTitle;
        this.filmDuration = filmDuration;
    }
}

class Screening {
    Film film;
    Auditorium auditorium;
    Date screeningTime;

    Screening(Film film, Auditorium auditorium, Date screeningTime) {
        this.film = film;
        this.auditorium = auditorium;
        this.screeningTime = screeningTime;
    }
}

class Booking {
    Screening screening;
    SeatLayout seat;

    Booking(Screening screening, SeatLayout seat) {
        this.screening = screening;
        this.seat = seat;
        this.seat.isBooked = true;
    }
}

public class BookingSystem {
    static List<Theater> theaters = new ArrayList<>();
    static List<Film> films = new ArrayList<>();
    static List<Screening> screenings = new ArrayList<>();
    static Scanner inputScanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Администратор\n2. Пользователь\n3. Выход");
            int option = inputScanner.nextInt();
            if (option == 1) {
                adminOptions();
            } else if (option == 2) {
                userOptions();
            } else if (option == 3) {
                break;
            }
        }
    }

    static void adminOptions() {
        while (true) {
            System.out.println("1. Добавить кинотеатр\n2. Добавить зал\n3. Добавить фильм\n4. Создать сеанс\n5. Назад");
            int option = inputScanner.nextInt();
            if (option == 1) {
                System.out.println("Введите название кинотеатра:");
                String name = inputScanner.next();
                theaters.add(new Theater(name));
            } else if (option == 2) {
                System.out.println("Выберите кинотеатр:");
                for (int i = 0; i < theaters.size(); i++) {
                    System.out.println((i + 1) + ". " + theaters.get(i).theaterName);
                }
                int theaterIndex = inputScanner.nextInt() - 1;
                System.out.println("Введите количество рядов и мест в ряду:");
                int rows = inputScanner.nextInt();
                int seatsPerRow = inputScanner.nextInt();
                theaters.get(theaterIndex).addAuditorium(new Auditorium(theaters.get(theaterIndex).auditoriums.size() + 1, rows, seatsPerRow));
            } else if (option == 3) {
                System.out.println("Введите название фильма и длительность (в минутах):");
                String title = inputScanner.next();
                int duration = inputScanner.nextInt();
                films.add(new Film(title, duration));
            } else if (option == 4) {
                System.out.println("Выберите фильм:");
                for (int i = 0; i < films.size(); i++) {
                    System.out.println((i + 1) + ". " + films.get(i).filmTitle);
                }
                int filmIndex = inputScanner.nextInt() - 1;
                System.out.println("Выберите кинотеатр:");
                for (int i = 0; i < theaters.size(); i++) {
                    System.out.println((i + 1) + ". " + theaters.get(i).theaterName);
                }
                int theaterIndex = inputScanner.nextInt() - 1;
                System.out.println("Выберите зал:");
                for (int i = 0; i < theaters.get(theaterIndex).auditoriums.size(); i++) {
                    System.out.println((i + 1) + ". Зал " + theaters.get(theaterIndex).auditoriums.get(i).auditoriumId);
                }
                int auditoriumIndex = inputScanner.nextInt() - 1;
                System.out.println("Введите дату и время сеанса (в формате ГГГГ-ММ-ДД ЧЧ:ММ):");
                screenings.add(new Screening(films.get(filmIndex), theaters.get(theaterIndex).auditoriums.get(auditoriumIndex), new Date()));
            } else if (option == 5) {
                break;
            }
        }
    }

    static void userOptions() {
        while (true) {
            System.out.println("1. Поиск сеанса\n2. Купить билет\n3. Назад");
            int option = inputScanner.nextInt();
            if (option == 1) {
                System.out.println("Введите название фильма:");
                String title = inputScanner.next();
                for (Screening screening : screenings) {
                    if (screening.film.filmTitle.equalsIgnoreCase(title)) {
                        System.out.println("Сеанс: " + screening.film.filmTitle + " в " + screening.auditorium.auditoriumId + " зале, время: " + screening.screeningTime);
                    }
                }
            } else if (option == 2) {
                System.out.println("Выберите сеанс:");
                for (int i = 0; i < screenings.size(); i++) {
                    System.out.println((i + 1) + ". " + screenings.get(i).film.filmTitle + " в " + screenings.get(i).auditorium.auditoriumId + " зале, время: " + screenings.get(i).screeningTime);
                }
                int screeningIndex = inputScanner.nextInt() - 1;
                Screening screening = screenings.get(screeningIndex);
                System.out.println("План зала:");
                screening.auditorium.displaySeats();
                System.out.println("Выберите ряд и место:");
                int row = inputScanner.nextInt() - 1;
                int seat = inputScanner.nextInt() - 1;
                if (!screening.auditorium.seatLayout[row][seat].isBooked) {
                    new Booking(screening, screening.auditorium.seatLayout[row][seat]);
                    System.out.println("Билет куплен!");
                } else {
                    System.out.println("Место уже занято!");
                }
            } else if (option == 3) {
                break;
            }
        }
    }
}