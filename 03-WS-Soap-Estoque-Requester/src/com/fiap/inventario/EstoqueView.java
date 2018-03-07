package com.fiap.inventario;

import java.util.Scanner;

import com.fiap.inventario.EstoqueStub.BuscarProduto;
import com.fiap.inventario.EstoqueStub.BuscarProdutoResponse;
import com.fiap.inventario.EstoqueStub.ProdutoTO;

public class EstoqueView {

	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		EstoqueStub req = new EstoqueStub();
		
		BuscarProduto params = new BuscarProduto();
		System.out.print("Digite o código do produto: ");
		String codProduto = scanner.next();
		params.setCodProduto(codProduto);
		
		BuscarProdutoResponse res = req.buscarProduto(params);
		
		try {
			ProdutoTO produtoTO = new ProdutoTO();
			produtoTO.setCodigo(res.get_return().getCodigo());
			produtoTO.setDescricao(res.get_return().getDescricao());
			produtoTO.setNome(res.get_return().getNome());
			produtoTO.setPreco(res.get_return().getPreco());
			
			System.out.println(
					"Cod: " + produtoTO.getCodigo() +
					"\nNome: " + produtoTO.getNome() +
					"\nPreço: " + produtoTO.getPreco());
		} catch (Exception e) {
			System.err.println("Erro ao imprimir produto.");
		} finally {
			scanner.close();
		}
		
	}
	
}
