package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Korisnik;
import ba.unsa.etf.rpr.exceptions.CeraVeException;
import java.util.Scanner;

public class HelloApplication2 {
    public static void prijavaIliRegistracija(int ulaz) throws CeraVeException {
        if (ulaz == 0) { //za registraciju

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
        + "\nMolimo unesite broj 0 ukoliko nemate racun na našoj aplikaciji ili broj 1 ukoliko zelite da se prijavite.");
        Scanner scanner = new Scanner(System.in);
        int ulaz = scanner.nextInt();
        prijavaIliRegistracija(ulaz);



    }

}
