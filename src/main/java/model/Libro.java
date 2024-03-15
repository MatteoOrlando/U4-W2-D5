package model;

public class Libro extends Elemento {
    private String autore;
    private String genere;

    public Libro(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
    }

    public Libro() {
        super();
    }


    public String getAutore() {
        return autore;
    }
}
