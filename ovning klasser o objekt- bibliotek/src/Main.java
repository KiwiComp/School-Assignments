import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Skapa en lista av alla objekt dvs alla books.
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("apple", "fruity", 2003, 2002));
        books.add(new Book("carrot", "veggie", 1998, 2001));
        books.add(new Book("horsie", "animal", 1982, 1987));
        books.add(new Book("anty", "insect", 2008, 2012));
        books.add(new Book("birchy", "tree", 1902, 1952));
        books.add(new Book("Across the Nightingale Floor", "Lian Hearn", 2003, 2011));
        books.add(new Book("1984", "George Orwell", 1949, 2008));
        books.add(new Book ("To Kill a Mockingbird", "Harper Lee", 1960, 2015));
        books.add(new Book ("Du sköna nya värld", "Aldous Huxley", 1932, 2006));
        books.add(new Book ("Krig och fred", "Leo Tolstoy", 1869, 2007));
        books.add(new Book ("Catcher in the Rye", "J.D. Salinger,", 1951, 2010));


        Scanner scanner = new Scanner(System.in);
        int chosenAlternative;

        do {
            System.out.println("Välj ett alternativ i listan nedan genom att skriva in alternativets siffra: \n" +
                    "1. Lägg till en bok till bibliotekets register.\n" +
                    "2. Sök efter en boks titel.\n" +
                    "3. Se alla tillgängliga böcker.\n" +
                    "4. Lämna tillbaka en bok.\n" +
                    "5. Avsluta");

            chosenAlternative = scanner.nextInt();
            scanner.nextLine();

            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Du valde alternativ " + chosenAlternative + "\n");

            if (chosenAlternative == 1) {
                System.out.println("Skriv in titeln på boken du vill lägga till i biblioteket: ");
                String addTitle = scanner.nextLine();

                System.out.println("Skriv in författaren till boken du vill lägga till: ");
                String addAuthor = scanner.nextLine();

                System.out.println("Skriv in utgivningsår för boken du vill lägga till: ");
                int addYear = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Slutligen, skriv in upplaga för boken du vill lägga till: ");
                int addEdition = scanner.nextInt();
                scanner.nextLine();

                Book book1 = new Book (addTitle, addAuthor, addYear, addEdition);

                books.add(book1);

                System.out.println("\n" + "Här är informationen om boken du lagt till: \n" + book1);

            } else if (chosenAlternative == 2) {
                System.out.println("Skriv titeln på boken du söker.");
                String searchTitle = scanner.nextLine();
                System.out.println("\n" + "Du valde att söka efter " + searchTitle + ".\n" );

//                Book foundBook = searchBookByTitle(books, searchTitle); // Om jag vill använda min funktion istället.
                Book foundBook = null;
                for(int i = 0; i < books.size(); i++) {
//                    String bookTitle = books.get(i).getTitle(); // Hämta titeln från Book-objektet om den är private och har en getter.
                    String bookTitle = books.get(i).title; // om den ör public och inte behöver en getter

                    if (searchTitle.equalsIgnoreCase(bookTitle)) {
                        foundBook = books.get(i);
                        break;
                    }
                }

                if (foundBook != null) {
                    System.out.println("Boken hittades. Här är information om boken: \n");
                    System.out.println(foundBook);

                    System.out.println("Vill du låna denna bok? (j/n) " + "(Titel du sökte efter: " + foundBook.title + ")");

                    boolean isRunning = true;
                    while (isRunning) {
                        String responseLoanBook = scanner.nextLine();
                        if (responseLoanBook.equalsIgnoreCase("j")) {
                            String loanResult = foundBook.loanBook();
                            System.out.println(loanResult);
                            System.out.println("--------------------------------------------------------------");
                            isRunning = false;
                        } else if (responseLoanBook.equalsIgnoreCase("n")) {
                            System.out.println("Du valde att inte låna boken.");
                            isRunning = false;
                        } else {
                            System.out.println("Du valde varken j eller n, gör ett nytt val. Please idiot.");
                        }
                    }
                } else {
                    System.out.println("Boken hittades inte.\n");
                }

            } else if (chosenAlternative == 3) {
                System.out.println("\n" + "Här nedan ser du alla böcker som finns i biblioteket: ");
                for (Book book : books) {
                    System.out.println(book.title + ", av " + book.author);
                }

            } else if (chosenAlternative == 4) {
                System.out.println("Skriv titeln på boken du vill lämna tillbaka.");
                String returnTitle = scanner.nextLine();


//                Book foundBook = searchBookByTitle(books, searchTitle); // Om jag vill använda min funktion istället.
                Book foundReturnBook = null;
                for(int i = 0; i < books.size(); i++) {
//                    String bookTitle = books.get(i).getTitle(); // Hämta titeln från Book-objektet om den är private och har en getter.
                    String bookTitle = books.get(i).title; // om den är public och inte behöver en getter

                    if (returnTitle.equalsIgnoreCase(bookTitle)) {
                        foundReturnBook = books.get(i);
                        break;
                    }
                }

                if (foundReturnBook != null) {
                    System.out.println(foundReturnBook.returnBook());

                } else {
                    System.out.println("Boken hittades inte.\n");
                }
            }

        } while (chosenAlternative != 5);

        System.out.println("Tack för att du använder bibliotekets tjänst, välkommen tillbaka!");
    }

    public static Book searchBookByTitle(ArrayList<Book> books, String titleHere) {
        for (Book book : books) {
            if ((book.getTitle()).equalsIgnoreCase(titleHere)) {
                return book;
            }
        }
        return null;
    }
}