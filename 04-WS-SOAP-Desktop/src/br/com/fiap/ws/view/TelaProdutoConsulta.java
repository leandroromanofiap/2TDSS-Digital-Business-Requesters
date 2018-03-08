package br.com.fiap.ws.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.EstoqueStub.ProdutoTO;
import br.com.fiap.repository.EstoqueRepository;

public class TelaProdutoConsulta {

	protected Shell shlConsultarProdutos;
	private Text txtCodProduto;
	private Text txtNomeProduto;
	private Text txtPrecoProduto;
	private Text txtDescricaoProduto;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaProdutoConsulta window = new TelaProdutoConsulta();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlConsultarProdutos.open();
		shlConsultarProdutos.layout();
		while (!shlConsultarProdutos.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlConsultarProdutos = new Shell();
		shlConsultarProdutos.setSize(450, 236);
		shlConsultarProdutos.setText("Consultar Produtos");
		
		Label lblDigiteOCdigo = new Label(shlConsultarProdutos, SWT.NONE);
		lblDigiteOCdigo.setBounds(10, 10, 414, 15);
		lblDigiteOCdigo.setText("Digite o c\u00F3digo do produto:");
		
		txtCodProduto = new Text(shlConsultarProdutos, SWT.BORDER);
		txtCodProduto.setBounds(10, 31, 76, 21);
		
		Label label = new Label(shlConsultarProdutos, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 71, 414, 2);
		
		Label lblNomeDoProduto = new Label(shlConsultarProdutos, SWT.NONE);
		lblNomeDoProduto.setBounds(10, 79, 152, 15);
		lblNomeDoProduto.setText("Nome do produto:");
		
		txtNomeProduto = new Text(shlConsultarProdutos, SWT.BORDER);
		txtNomeProduto.setBounds(10, 100, 332, 21);
		
		Label lblPreo = new Label(shlConsultarProdutos, SWT.NONE);
		lblPreo.setBounds(348, 79, 55, 15);
		lblPreo.setText("Pre\u00E7o:");
		
		txtPrecoProduto = new Text(shlConsultarProdutos, SWT.BORDER);
		txtPrecoProduto.setBounds(348, 100, 76, 21);
		
		Label lblDescrio = new Label(shlConsultarProdutos, SWT.NONE);
		lblDescrio.setBounds(10, 145, 55, 15);
		lblDescrio.setText("Descri\u00E7\u00E3o");
		
		txtDescricaoProduto = new Text(shlConsultarProdutos, SWT.BORDER);
		txtDescricaoProduto.setBounds(10, 166, 332, 21);
		
		Button btnBuscar = new Button(shlConsultarProdutos, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					EstoqueRepository repository = new EstoqueRepository();
					
					int codProduto = Integer.parseInt(txtCodProduto.getText());
					
					ProdutoTO produto = repository.consultarProduto(codProduto);
					
					txtNomeProduto.setText(produto.getNome());
					txtPrecoProduto.setText("R$" + produto.getPreco());
					txtDescricaoProduto.setText(produto.getDescricao());
				} catch (NullPointerException err) {
					displayMessage("Erro!", "Produto não encontrado!.", err.getMessage(), SWT.ERROR);
					err.printStackTrace();
				} catch (Exception err) {
					displayMessage("Erro!", "Erro ao processar produto.", err.getMessage(), SWT.ERROR);
					err.printStackTrace();
				}
				
			}
		});
		btnBuscar.setBounds(92, 31, 75, 25);
		btnBuscar.setText("Buscar");

	}
	
	private void displayMessage(String title, String message, String stack, int type) {
		MessageBox messageBox = new MessageBox(shlConsultarProdutos, type);

		messageBox.setText(title);
		messageBox.setMessage(message + "\nStack: " + stack);
		messageBox.open();
	}
}
