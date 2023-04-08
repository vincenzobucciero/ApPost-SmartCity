package com.example.smartcity.service.Strategy;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CreditCardStrategy implements PaymentStrategy {
    private String nome;
    private String numeroCarta;
    private String cvv;
    //private LocalDate dataScadenza;
    private String dataScadenza;
    public CreditCardStrategy(String nome, String numeroCarta, String cvv, String dataScadenza){
        this.nome = nome;
        this.numeroCarta = numeroCarta;
        this.cvv = cvv;
        this.dataScadenza = dataScadenza;
    }

    //controlla che la carta sia valida
    private boolean checkCreditCardNumber() {

        if (numeroCarta == null || numeroCarta.length() != 16) {
            return false;
        }

        //controlla se il numero della carta di credito contiene solo cifre
        Pattern creditCardPattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
        Matcher creditCardMatcher = creditCardPattern.matcher(numeroCarta);
        return !creditCardMatcher.find();
    }

    //controlla che la carta non sia scaduta
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

    private boolean checkPaymentMethodData() {

        if (!checkCreditCardNumber()) return false;
        if (!checkCreditCardExpirationDate()) return false;
        if (!checkCreditCardCVV()) return false;
        return true;
    }

    @Override
    public void pay(double amount) {
        if (checkPaymentMethodData())
            System.out.println(amount + " pagamento con successo con carta di credito");
        else
            System.out.println("credenziali non valide");
    }
}