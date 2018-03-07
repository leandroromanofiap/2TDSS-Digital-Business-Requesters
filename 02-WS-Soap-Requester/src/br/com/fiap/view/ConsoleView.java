package br.com.fiap.view;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcMedia;
import br.com.fiap.bo.NotaBOStub.CalcMediaResponse;

public class ConsoleView {

	public static void main(String[] args) throws Exception {
		
		NotaBOStub stub = new NotaBOStub();
		
		CalcMedia parametros = new CalcMedia();
		
		CalcMediaResponse resultado = stub.calcMedia(parametros);
		
		System.out.println(resultado.get_return());
		
	}
	
}
