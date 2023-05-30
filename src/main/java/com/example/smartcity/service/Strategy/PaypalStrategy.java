package com.example.smartcity.service.Strategy;

/**
 * Questa classe rappresenta una strategia di pagamento con Paypal. Implementa l'interfaccia PaymentStrategy.
 */
public class PaypalStrategy implements PaymentStrategy {
    private String emailId;
    private String password;

    /**
     * Costruttore della classe PaypalStrategy.
     *
     * @param email l'email associata all'account Paypal
     * @param password la password associata all'account Paypal
     */
    public PaypalStrategy(String email, String password){
        this.emailId = email;
        this.password = password;
    }

    /**
     * Implementazione del metodo pay() dell'interfaccia PaymentStrategy.
     * Esegue il pagamento attraverso l'account Paypal dell'utente.
     *
     * @param amount l'ammontare da pagare
     * @return true se il pagamento è andato a buon fine, false altrimenti
     */
    @Override
    public boolean pay(double amount) {
        System.out.println(amount + " paid using Paypal.");
        return true;
    }
}