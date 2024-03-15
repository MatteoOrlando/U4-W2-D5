package Main_Application;

import model.Elemento;
import model.Libro;
import model.Rivista;
import utils.ArchivioManager;
import utils.CatalogoBiblioteca;
import utils.Periodicita;
import exceptions.ElementoNonTrovatoException;

import java.io.IOException;
import java.util.List;

public class CatalogoApp {
    public static void main(String[] args) {
        // Creo un catalogo
        CatalogoBiblioteca catalogo = new CatalogoBiblioteca();

        // Aggiungiamo alcuni libri e riviste al catalogo
        catalogo.aggiungiElemento(new Libro());
        catalogo.aggiungiElemento(new Libro());
        catalogo.aggiungiElemento(new Rivista("5555555555", "National Geographic", 2022, 100, Periodicita.MENSILE));

        // Eseguiamo alcune operazioni sul catalogo
        try {
            catalogo.rimuoviElemento("123456789");
        } catch (ElementoNonTrovatoException e) {
            System.out.println(e.getClass());
        }

        int annoDaCercare = 1954;
        List<Elemento> libriDel1954 = catalogo.ricercaPerAnnoPubblicazione(annoDaCercare);
        System.out.println("Libri pubblicati nel " + annoDaCercare + ":");
        for (Elemento elemento : libriDel1954) {
            System.out.println(elemento);
        }

        List<Elemento> libriDiTolkien = catalogo.ricercaPerAutore("J.R.R. Tolkien");
        System.out.println("\nLibri scritti da J.R.R. Tolkien:");
        for (Elemento elemento : libriDiTolkien) {
            System.out.println(elemento);
        }

        // Salvataggio del catalogo su disco
        try {
            ArchivioManager.salvataggioSuDisco(catalogo.getCatalogo(), "catalogo.dati");
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio del catalogo su disco: " + e.getMessage());
        }

        // Caricamento del catalogo da disco
        try {
            List<Elemento> catalogoCaricato = ArchivioManager.caricamentoDaDisco("catalogo.dati");
            System.out.println("\nCatalogo caricato da disco:");
            for (Elemento elemento : catalogoCaricato) {
                System.out.println(elemento);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore durante il caricamento del catalogo da disco: " + e.getMessage());
        }
    }
}

