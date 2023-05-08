package ba.unsa.etf.rpr.exceptions;

public class CeraVeException extends Exception {

    public CeraVeException(String message, Exception reason) {
        super(message, reason);
    }

    public CeraVeException(String message) {
        super(message);
    }
}
