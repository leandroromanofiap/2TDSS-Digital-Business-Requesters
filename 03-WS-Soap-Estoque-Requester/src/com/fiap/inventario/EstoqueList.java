package com.fiap.inventario;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.fiap.inventario.EstoqueStub.Listar;
import com.fiap.inventario.EstoqueStub.ListarResponse;
import com.fiap.inventario.EstoqueStub.ProdutoTO;

public class EstoqueList {

	public static void main(String[] args) {
		
		try {
			EstoqueStub req = new EstoqueStub();
			
			Listar params = new Listar();
			
			ListarResponse res = req.listar(params);
			
			ProdutoTO[] resProdutos = res.get_return();
			
			List<ProdutoTO> resProdutosList = Arrays.asList(resProdutos);
			
			for (ProdutoTO produto : resProdutosList)
				System.out.println(produto.toString());
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
	}
	
}
