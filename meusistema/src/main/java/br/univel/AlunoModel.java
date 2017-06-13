package br.univel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AlunoModel extends AbstractTableModel {

	private List<Aluno> lista;
	
	
	
	public AlunoModel(List<Aluno> lista2) {
		if (lista2 == null) {
			this.lista = new ArrayList<>();
		} else {
			this.lista = lista2;
		}
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Idade";
		case 3:
			return "Telefone";
		}
		return null;
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		Aluno a = this.lista.get(row);
		
		switch (column) {
		case 0:
			return a.getId();
		case 1:
			return a.getNome();
		case 2:
			return a.getIdade();
			
		case 3:
			return a.getTelefone();
		}
		return null;
		
		
	}

	public void adicionar(Aluno a) {
		this.lista.add(a);

		
		super.fireTableDataChanged();
	}

	public Aluno getAluno(int idx) {
		return lista.get(idx);
	}

	public void remover(Aluno alunoSelecionado) {
		this.lista.remove(alunoSelecionado);
		super.fireTableDataChanged();
	}
	
	
	
	
}

