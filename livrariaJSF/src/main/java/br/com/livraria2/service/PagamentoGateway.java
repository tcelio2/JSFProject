package br.com.livraria2.service;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import br.com.livraria2.model.Pagamento;

public class PagamentoGateway implements Serializable{

	
	public String pagar(BigDecimal total) {
		Pagamento pagamento = new Pagamento(total);
		String target = "http://book-payment.herokuapp.com/payment";
		Client client = ClientBuilder.newClient();
		return client.target(target).request().post(Entity.json(pagamento), String.class);
	}
}
