package com.example.smartcity.service.Strategy;

/**
 * Questa interfaccia definisce il contratto che ogni strategia di pagamento deve rispettare.
 * Ha un metodo 'pay' che prende come parametro l'ammontare da pagare e restituisce un valore booleano
 * che indica se il pagamento è andato a buon fine o meno.
 */
public interface PaymentStrategy {

    /**
     * Metodo che effettua il pagamento dell'ammontare specificato.
     *
     * @param amount l'ammontare da pagare.
     * @return true se il pagamento è andato a buon fine, false altrimenti.
     */
    boolean pay(double amount);


}