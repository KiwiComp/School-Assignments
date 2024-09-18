// Klassen med instansvariabler.
public class Book {
    String title;
    String author;
    int year;
    int edition;
    boolean available;

    // Konstruktören, available är inte med som parameter/attribut då den är default true, dvs. i lager.
    public Book (String title, String author, int year, int edition) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.edition = edition;
        this.available = true;
    }

    // Låna en bok.
    public String loanBook() {
        if (this.available) {
            this.available=false;
            return "Du har lånat följande bok: " + this.title + "."; // return behöver vara sist då funktionen avslutas med return.
        } else {
            return this.title + ": Boken är utlånad.";
        }
    }

    // Returnera en bok, motsatsen till loanBook.
    public String returnBook() {
        if (!this.available) {
            this.available=true;
            return "Du har lämnat tillbaka följande bok: " + this.title + ".";
        } else {
            return "Boken " + this.title + " är inte utlånad.";
        }
    }

    public String toString() {
        return  "Title: " + this.title + "\n" +
                "Author: " + this.author + "\n" +
                "Year of publication: " + this.year + "\n" +
                "Edition: " + this.edition + "\n" +
//                "Available: " + this.available + "\n";
                "Status: " + ((this.available)  ? "Available" : "Unavailable")+ "\n"; // Funkar väldigt bra för boolean. Gör om utskriften så att inte true/false genereras, utan det nya som är inskrivet på var sin sida om :.
                //(condition) ? value if true : value if false;
    }

    public String getTitle() {
        return this.title;
    }

// + "\n"
}


