package utils;

import exceptions.ElementoNonTrovatoException;
import model.Elemento;
import model.Libro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatalogoBiblioteca {
    private List<Elemento> catalogo;

    public CatalogoBiblioteca() {
        this.catalogo = new ArrayList<>();
    }

    public void aggiungiElemento(Elemento elemento) {
        catalogo.add(elemento);
    }

    public void rimuoviElemento(String codiceISBN) throws ElementoNonTrovatoException {
        Elemento elementoDaRimuovere = null;
        for (Elemento elemento : catalogo) {
            if (elemento.getCodiceISBN() != null && elemento.getCodiceISBN().equals(codiceISBN)) {
                elementoDaRimuovere = elemento;
                break;
            }
        }
        if (elementoDaRimuovere != null) {
            catalogo.remove(elementoDaRimuovere);
        } else {
            throw new ElementoNonTrovatoException ("Elemento con codice ISBN " + codiceISBN + " non trovato.");
        }
    }

    public List<Elemento> ricercaPerAnnoPubblicazione(int anno) {
        return catalogo.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<Elemento> ricercaPerAutore(String autore) {
        return catalogo.stream()
                .filter(elemento -> elemento instanceof Libro)
                .map(elemento -> (Libro) elemento)
                .filter(libro -> libro.getAutore().equals(autore))
                .collect(Collectors.toList());
    }


    public List<Elemento> getCatalogo() {
        return catalogo;
    }
}

