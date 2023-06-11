package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.KorisnikManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import java.util.Scanner;

public class HelloApplication2 {
    public static void prijavaIliRegistracija(int ulaz) throws CeraVeException {

        if (ulaz == 0) { //za registraciju
            int provjera = 0;
            String ime;
            System.out.println("Unesite svoje ime: ");
            Scanner scanner1 = new Scanner(System.in);
            ime = scanner1.next();

            String prezime;
            System.out.println("\nUnesite svoje prezime: ");
            Scanner scanner2 = new Scanner(System.in);
            prezime = scanner2.next();

            String adresa;
            System.out.println("\nUnesite svoju adresu: ");
            Scanner scanner3 = new Scanner(System.in);
            adresa = scanner1.next();

            String email;
            System.out.println("\nUnesite svoj email: ");
            Scanner scanner4 = new Scanner(System.in);
            email = scanner4.next();

            String password;
            System.out.println("Password: ");
            Scanner scanner5 = new Scanner(System.in);
            password = scanner5.next();


            if (ime != null && prezime != null && adresa != null && email != null & password != null & password.length() >= 8) {
                Korisnik noviKorisnik = new Korisnik();
                noviKorisnik.setIme(ime);
                noviKorisnik.setPrezime(prezime);
                noviKorisnik.setAdresa(adresa);
                noviKorisnik.setEmail(email);
                noviKorisnik.setPassword(password);
                KorisnikManager.dodajKorisnika(noviKorisnik);
                System.out.println("\nUspjesno ste registrovani, mozete se prijaviti!");
                prijavaIliRegistracija(1);
            }else {
                System.out.println("\nUneseni podaci nisu u ispravnom formatu, pokusajte ponovo.");
                prijavaIliRegistracija(0);
            }
        } else if (ulaz == 1) { //za prijavu
            int provjera = 0;
            String email;
            System.out.println("Unesite svoj email: ");
            Scanner scanner = new Scanner(System.in);
            email = scanner.next();

            String password;
            System.out.println("\nUnesite svoj password: ");
            password = scanner.next();

            Korisnik korisnik = DaoFactory.korisnikDao().pronadjiEmail(email);
            while (true) {
                if (korisnik != null && korisnik.getPassword().equals(password)) {
                    System.out.println("\nUspjesno ste prijavljeni!");
                    break;
                } else {
                    System.out.println("\nUneseni su neispravni podaci, pokusajte ponovo.");
                    provjera = 1;
                    break;
                }
            }
            if (provjera == 1) prijavaIliRegistracija(1);
        }
    }

    public static void main( String[] args ) throws CeraVeException
    {
        System.out.println("DOBRO DOSLI NA OFFICIAL STRANICU ZA NARUCIVANJE CERAVE PROIZVODA!"
        + "\nMolimo unesite broj 0 ukoliko nemate racun na nasoj aplikaciji ili broj 1 ukoliko zelite da se prijavite.");
        Scanner scanner = new Scanner(System.in);
        int ulaz = scanner.nextInt();
        prijavaIliRegistracija(ulaz);
    }

}
