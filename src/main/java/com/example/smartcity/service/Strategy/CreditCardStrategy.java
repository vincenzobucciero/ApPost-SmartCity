package com.example.smartcity.service.Strategy;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * La classe CreditCardStrategy rappresenta la strategia di pagamento con carta di credito.
 * Implementa l'interfaccia PaymentStrategy e definisce i metodi necessari per controllare la validità
 * della carta di credito e per effettuare il pagamento.
 */
public class CreditCardStrategy implements PaymentStrategy {
    private String nome;
    private String numeroCarta;
    private String cvv;
    private String dataScadenza;


    /**
     * Costruttore della classe CreditCardStrategy.
     * Inizializza i campi dati nome, numeroCarta, cvv e dataScadenza con i valori passati come parametro.
     *
     * @param nome il nome del titolare della carta di credito
     * @param numeroCarta il numero della carta di credito
     * @param cvv il codice CVV della carta di credito
     * @param dataScadenza la data di scadenza della carta di credito nel formato "yy-MM"
     */
    public CreditCardStrategy(String nome, String numeroCarta, String cvv, String dataScadenza){
        this.nome = nome;
        this.numeroCarta = numeroCarta;
        this.cvv = cvv;
        this.dataScadenza = dataScadenza;
    }


    /**
     * Metodo che controlla se il numero della carta di credito sia valido.
     *
     * @return true se il numero della carta di credito è valido, false altrimenti
     */
    private boolean checkCreditCardNumber() {

        if (numeroCarta == null || numeroCarta.length() != 20) {
            return false;
        }
        //controlla se il numero della carta di credito contiene solo cifre
        Pattern creditCardPattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
        Matcher creditCardMatcher = creditCardPattern.matcher(numeroCarta);
        return !creditCardMatcher.find();
    }


    /**
     * Metodo che controlla se la carta di credito non sia scaduta.
     *
     * @return true se la carta di credito non è scaduta, false altrimenti
     */
    private boolean checkCreditCardExpirationDate() {
        SimpleDateFormat f = new SimpleDateFormat("yy-MM");
        String oggi = f.format(new Date());

        //compare to ritorna un numero > di 0 se data scadenza è contenuta nella data di oggi
        // < 0 il contrario
        // = 0 uguali (l'ho considerato come scaduta)
        //compareToIgnoreCase ignora i caratteri tra le stringhe
        if(oggi.compareToIgnoreCase(dataScadenza) > 0 ){
            System.out.println("Scaduta");
            return false;
        }
        else
            System.out.println("Valida");
        return true;

    }

    //controlla che il cvv sia valido
    private boolean checkCreditCardCVV() {

        if (cvv == null || cvv.length() != 3)
            return false;

        // controlla che contenga solo cifre
        Pattern creditCardCVVPattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
        Matcher creditCardCVVMatcher = creditCardCVVPattern.matcher(cvv);
        return !creditCardCVVMatcher.find();
    }


    /**
     * Metodo che controlla se il codice CVV della carta di credito sia valido.
     *
     * @return true se il codice CVV è valido, false altrimenti
     */
    private boolean checkPaymentMethodData() {

        if (!checkCreditCardNumber()) return false;
        if (!checkCreditCardExpirationDate()) return false;
        if (!checkCreditCardCVV()) return false;
        return true;
    }


    /**
     * Metodo che effettua il pagamento utilizzando una carta di credito.
     *
     * @param amount l'importo da pagare.
     * @return true se il pagamento è stato effettuato con successo, false altrimenti.
     */
    @Override
    public boolean pay(double amount) {
        if (checkPaymentMethodData()) {
            System.out.println(amount + " pagamento con successo con carta di credito");
            return true;
        }
        else {
            System.out.println("credenziali non valide");
            return false;
        }
    }
}