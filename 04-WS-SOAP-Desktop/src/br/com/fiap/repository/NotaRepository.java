package br.com.fiap.repository;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcPs;
import br.com.fiap.bo.NotaBOStub.CalcPsResponse;

public class NotaRepository {

	private NotaBOStub stub;
	
	public float calcularPs(float am, float nac) throws Exception {

		stub = new NotaBOStub();
		
		CalcPs params = new CalcPs();
		params.setAm(am);
		params.setNac(nac);
		
		CalcPsResponse res = stub.calcPs(params);
		
		return res.get_return();
		
	}
	
}
