package br.com.fiap.repository;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.EstoqueStub;
import br.com.fiap.bo.EstoqueStub.BuscarProduto;
import br.com.fiap.bo.EstoqueStub.BuscarProdutoResponse;
import br.com.fiap.bo.EstoqueStub.ProdutoTO;

public class EstoqueRepository {

	private EstoqueStub stub;
	
	public EstoqueRepository() throws AxisFault {
		stub = new EstoqueStub();
	}
	
	public ProdutoTO consultarProduto(int id) throws RemoteException {
		
		BuscarProduto params = new BuscarProduto();
		params.setCodProduto(String.valueOf(id));
		
		BuscarProdutoResponse res = stub.buscarProduto(params);
		
		return res.get_return();
		
	}
	
}
