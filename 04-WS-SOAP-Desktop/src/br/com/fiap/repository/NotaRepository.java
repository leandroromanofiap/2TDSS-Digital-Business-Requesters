package br.com.fiap.repository;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.NotaBOStub;
import br.com.fiap.bo.NotaBOStub.CalcPs;
import br.com.fiap.bo.NotaBOStub.CalcPsResponse;

public class NotaRepository {

	private NotaBOStub stub;
	
	public NotaRepository() throws AxisFault {
		stub = new NotaBOStub();
	}
	
	public float calcularPs(float am, float nac) throws RemoteException {
		CalcPs params = new CalcPs();
		params.setAm(am);
		params.setNac(nac);
		
		CalcPsResponse res = stub.calcPs(params);
		
		return res.get_return();
	}
	
}
