package com.javagda25;

import java.util.*;
import java.util.stream.Collectors;


public class SklepKomputerowy {
    private List<Komputer> list = new ArrayList<Komputer>();

    public SklepKomputerowy(List<Komputer> list) {
        this.list = list;
    }

    public void wypiszWszystkieKomputery() {
        list.stream()
                .forEach(wyswietl -> System.out.println(wyswietl));
    }

    public void wypiszKomputeryOMocyWyzszejNiz(int moc) {
        list.stream()
                .filter(p -> p.getPobieranaMoc() > moc)
                .forEach(wypisz -> System.out.println(wypisz));
    }

    public void wypiszCenyNazwyIdentyfikatoryWszystkichKomputerow() {
        list.stream()
                .forEach(wypisz -> System.out.println("Cena: " + wypisz.getCena() + " Nazwa: " + wypisz.getNazwa() + " Identyfikator: " + wypisz.getIdentyfikatorProduktu()));
    }

    public void wypiszWszystkieKomputeryZDwomaProcesorami() {
        list.stream()
                .filter(p -> p.getIlośćProcesorów() == 2)
                .forEach(wypisz -> System.out.println(wypisz));
    }

    public List<Komputer> zwrocWszystkieKomputeryZDwomaProcesorami() {
        List<Komputer> listaKomputerowZDwomaProcesorami = list.stream()
                .filter(p -> p.getIlośćProcesorów() == 2)
                .collect(Collectors.toList());
        listaKomputerowZDwomaProcesorami.forEach(wypisz -> System.out.println(wypisz));
        return listaKomputerowZDwomaProcesorami;
    }

    public double zwrocSredniaIloscProceosorow() {
        OptionalDouble sredniaIloscProcesorow = list.stream()
                .mapToDouble(p -> p.getIlośćProcesorów()).average();
        if (sredniaIloscProcesorow.isPresent()) {
            System.out.println("Średnia ilość procesorów: " + sredniaIloscProcesorow.getAsDouble());
        } else {
            throw new RuntimeException("ValueNotFound");
        }
        return sredniaIloscProcesorow.getAsDouble();
    }

    public List<Komputer> zwróćTylkoKomputeryZTurboIWiecejNiz4Procesorami() {
        List<Komputer> listaKompZTurboIPonad4Proc = list.stream()
                .filter(p -> p.isCzyProcesorMaTurbo() && p.getIlośćProcesorów() > 4)
                .collect(Collectors.toList());
        listaKompZTurboIPonad4Proc.forEach(wyswietl -> System.out.println(wyswietl));
        return listaKompZTurboIPonad4Proc;
    }

    public Komputer zwrocKomputerONajwyzszejPobieranejMocy() {
        Integer kompONajwyzszejPobieralnejMocy = list.stream()
                .mapToInt(p -> p.getPobieranaMoc()).max()
                .getAsInt();

        Optional<Komputer> najwiekszaPobieralnaMoc = list.stream()
                .filter(p -> p.getPobieranaMoc() == kompONajwyzszejPobieralnejMocy)
                .findFirst();
        if (najwiekszaPobieralnaMoc.isPresent()) {
            System.out.println(najwiekszaPobieralnaMoc);
        } else {
            throw new RuntimeException("ValueNotFound");
        }
        return najwiekszaPobieralnaMoc.get();
    }

    public Komputer zwrocKomputerONajnizszejPobieranejMocy() {
        Integer kompONajnizszejPobieralnejMocy = list.stream()
                .mapToInt(p -> p.getPobieranaMoc()).min()
                .getAsInt();

        Optional<Komputer> najnizszaPobieralnaMoc = list.stream()
                .filter(p -> p.getPobieranaMoc() == kompONajnizszejPobieralnejMocy)
                .findFirst();
        if (najnizszaPobieralnaMoc.isPresent()) {
            System.out.println(najnizszaPobieralnaMoc);
        } else {
            throw new RuntimeException("ValueNotFound");
        }
        return najnizszaPobieralnaMoc.get();
    }

    public List<Komputer> zwrocKomputeryKtoreMajaTurboIDwaProcesory() {
        List<Komputer> listaKompZTurboIDwomaProc = list.stream()
                .filter(p -> p.isCzyProcesorMaTurbo() && p.getIlośćProcesorów() == 2)
                .collect(Collectors.toList());
        listaKompZTurboIDwomaProc.stream().forEach(wyswiet -> System.out.println(wyswiet));

        return listaKompZTurboIDwomaProc;
    }
}
