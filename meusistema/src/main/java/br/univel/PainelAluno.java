package br.univel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;



public class PainelAluno extends PainelAlunoBase {

	private Aluno alunoSelecionado;
	private AlunoModel modelo;
	
	public PainelAluno() {
		super();
		limparCampos();
		configurarBotoes();
		configuraTabela();
		//configuraMenus();
	}

	



	private void configuraTabela() {
		
		AlunoDao dao = new AlunoDao();
		List<Aluno> lista = dao.getTodos();
		
		this.modelo = new AlunoModel(lista);
		// this.modelo = new ContatoModel();
		super.table.setModel(modelo);
		
		super.table.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int idx = table.getSelectedRow();
					if (idx < 0) {
						
					} else {
						System.out.println("Linha " + idx);
						carregarLinha(idx);
					}
				}
			}
		});

			
		
	}


	protected void carregarLinha(int idx) {
		Aluno a = this.modelo.getAluno(idx);
		this.alunoSelecionado = a;
				
		super.txfId.setText(String.valueOf(a.getId()));
		super.txfNome.setText(a.getNome());
		super.txfIdade.setText(String.valueOf(a.getIdade()));
		super.txfTelefone.setText(a.getTelefone());
		
		super.btnExcluir.setEnabled(true);
		
	}


	private void configurarBotoes() {
		super.btnNovo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Novo");
				novo();
			}
		});
		super.btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Salvar");
				salvar();
			}
		});
		super.btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicou Excluir");
				excluir();
			}
		});
	}


	protected void excluir() {
		this.modelo.remover(this.alunoSelecionado);
		limparCampos();
	}


	protected void salvar() {
		if (alunoSelecionado == null) {
			Aluno c = new Aluno();
			
			String strId = txfId.getText().trim();
			String strNome = txfNome.getText().trim();
			String strIdade = txfIdade.getText().trim();					
			String strTelefone = txfTelefone.getText().trim();
			
			int intId = Integer.parseInt(strId);
			int intIdade = Integer.parseInt(strId);
			
			c.setId(intId);
			c.setNome(strNome);
			c.setIdade(intIdade);
			c.setTelefone(strTelefone);
			
			this.modelo.adicionar(c);
			
			limparCampos();
			
		} else {
			
			String strId = txfId.getText().trim();
			String strNome = txfNome.getText().trim();
			String strTelefone = txfTelefone.getText().trim();
			
			int intId = Integer.parseInt(strId);
			int intIdade = Integer.parseInt(strId);
			
			this.alunoSelecionado.setId(intId);
			this.alunoSelecionado.setNome(strNome);
			this.alunoSelecionado.setIdade(intIdade);
			this.alunoSelecionado.setTelefone(strTelefone);
			
			limparCampos();
			this.modelo.fireTableDataChanged();
		}
		
	}


	protected void novo() {
		this.alunoSelecionado = null;
		
		limparCampos();
	}


	private void limparCampos() {
		
		super.txfId.setText("");
		super.txfNome.setText("");
		super.txfTelefone.setText("");
		super.txfIdade.setText("");
		
		super.btnExcluir.setEnabled(false);
	}
}
