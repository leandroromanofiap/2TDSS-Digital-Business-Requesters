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

import br.com.fiap.repository.NotaRepository;

public class Tela {

	protected Shell shell;
	private Text txtAm;
	private Text txtNac;
	private Text txtPs;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(222, 202);
		shell.setText("SWT Application");

		txtAm = new Text(shell, SWT.BORDER);
		txtAm.setBounds(98, 10, 76, 21);

		txtNac = new Text(shell, SWT.BORDER);
		txtNac.setBounds(98, 37, 76, 21);

		Label lblAm = new Label(shell, SWT.NONE);
		lblAm.setBounds(10, 13, 55, 15);
		lblAm.setText("AM:");

		Label lblNac = new Label(shell, SWT.NONE);
		lblNac.setBounds(10, 40, 55, 15);
		lblNac.setText("NAC:");

		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float am = 0f;
				float nac = 0;
				
				try {
					am = Float.parseFloat(txtAm.getText());
					nac = Float.parseFloat(txtNac.getText());
				} catch (Exception err) {
					displayMessage("Erro!", "Erro ao converter valores inseridos.", err.getMessage(), SWT.ERROR);
					err.printStackTrace();
					return;
				}

				try {
					NotaRepository repository = new NotaRepository();
					float ps = repository.calcularPs(am, nac);

					txtPs.setText(Float.toString(ps));
				} catch (Exception err) {
					displayMessage("Erro!", "Erro ao processar nota da PS.", err.getMessage(), SWT.ERROR);
					err.printStackTrace();
				}
			}
		});
		btnCalcular.setBounds(98, 90, 75, 25);
		btnCalcular.setText("Calcular");

		Label lblPs = new Label(shell, SWT.NONE);
		lblPs.setBounds(10, 125, 55, 15);
		lblPs.setText("PS:");

		txtPs = new Text(shell, SWT.BORDER);
		txtPs.setBounds(98, 121, 76, 21);

	}
	
	private void displayMessage(String title, String message, String stack, int type) {
		MessageBox messageBox = new MessageBox(shell, type);

		messageBox.setText(title);
		messageBox.setMessage(message + "\nStack: " + stack);
		messageBox.open();
	}
}
