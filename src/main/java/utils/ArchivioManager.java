package utils;

import model.Elemento;

import java.io.*;
import java.util.List;

public class ArchivioManager {

    //definisco il metodo per per salvare e/o caricare sul disco il catalogo attraverso l utilizzo di due parametri:
    // 1.catalogo (la lista degli elementi), 2.percorsoFile ( stringa che rappresenta il percorso del file in cui catalogo verrá salvato)

    public static void salvataggioSuDisco(List<Elemento> catalogo, String percorsoFile) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(percorsoFile))) {
            outputStream.writeObject(catalogo);
        }
    }


    public static List<Elemento> caricamentoDaDisco(String percorsoFile) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(percorsoFile))) {
            return (List<Elemento>) inputStream.readObject();
        }
    }
}
