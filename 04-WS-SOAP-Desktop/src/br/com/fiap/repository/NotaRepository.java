package br.com.fiap.repository;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcPs;
import br.com.fiap.bo.NotaBOStub.CalcPsResponse;

public class NotaRepository {

	public float calcularPs(float am, float nac) {

		try {
			NotaBOStub req = new NotaBOStub();
			
			CalcPs params = new CalcPs();
			params.setAm(am);
			params.setNac(nac);
			
			CalcPsResponse res = req.calcPs(params);
			
			return res.get_return();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0f;
		
	}
	
}
