package com.javagda25;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Komputer {
    private int identyfikatorProduktu;
    private double częstotliwośćProcesora;
    private boolean czyProcesorMaTurbo;
    private double wielkośćPamięciRAM;
    private double wielkośćDysku;
    private double cena;
    private int ilośćProcesorów;
    private String nazwa; //model/nazwa/marka
    private int pobieranaMoc; // moc w kW
}
