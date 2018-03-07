package br.com.fiap.view;

import java.util.Scanner;

import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CServico;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class CorreiosView {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite o CEP de origem: ");
		String cepOrigem = scanner.next() + scanner.nextLine();
		
		System.out.print("Digite o CEP de destino: ");
		String cepDestino = scanner.next() + scanner.nextLine();
		
		CalcPrecoPrazoWSStub req = new CalcPrecoPrazoWSStub();
		
		CalcPrazo params = new CalcPrazo();
		
		params.setNCdServico("4014");
		params.setSCepOrigem(cepOrigem);
		params.setSCepDestino(cepDestino);
		
		CalcPrazoResponse res = req.calcPrazo(params);
		
		CServico[] result = res.getCalcPrazoResult().getServicos().getCServico();
		String prazoEntrega = result[0].getDataMaxEntrega();
		
		System.out.println("O prazo máximo para entrega é " + prazoEntrega);
		
		scanner.close();
	}
	
}
