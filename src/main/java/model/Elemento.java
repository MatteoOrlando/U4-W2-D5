package model;

public abstract class Elemento {
    private String codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public Elemento(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public Elemento() {

    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }
  
}

