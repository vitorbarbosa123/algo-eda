package AULAS.tabelasHash;

import java.util.ArrayList;

public class TabelaHash {
  
  private Aluno[] tabela;

  public TabelaHash() {
    this.tabela = new Aluno[20];
  }

  private int hash(int chave) {
    return chave % this.tabela.length;
  }

  public void put(int chave, Aluno aluno) {
    int hash = hash(chave);
    this.tabela[hash] = aluno;
  }

  // put melhorado
  public void put(int chave, Aluno valor) {
    int hash = hash(chave);
    ArrayList<Aluno> alunos = this.tabela[hash];

    if(alunos == null) {
      alunos = new ArrayList<Aluno>();
      alunos.add(valor);
      this.tabela[hash] = alunos;
    } else {
      for(int i = 0; i < alunos.size(); i++) {
        if(alunos.get(i).getMatricula == chave) {
          alunos.set(i, valor);
          return;
        }
      }
      alunos.add(valor);
    }
  }

  public Aluno remove(int chave) {
    int hash = hash(chave);
    Aluno aluno = this.tabela[hash];
    this.tabela[hash] = null;
    return aluno;

  } 

  //remove melhorado
  public Aluno remove(int chave) {
    int hash = hash(chave);
    ArrayList<Aluno> alunos = this.tabela[hash];

    // iterator serve para interar sobre arraylists
    Iterator<Aluno> it = alunos.iterator();
    Aluno atual = null;

    // enquanto houver itens 
    while(it.hasNext()) {
      // pega o item atual
      atual = it.next();
      if(atual.getMatricula() == chave) {
        //remove itens dentro de um while
        it.remove();
        return atual;
      }
    }
    return atual;
  }

  // performace: O(1)
  public Aluno get(int chave) {
    int hash = hash(chave);
    return this.tabela[hash];
  }

  // get melhorado
  // performace: O(n)
  public Aluno getUpdate(int chave) {
    int hash = hash(chave);
    ArrayList<Aluno> alunos = this.tabela[hash];

    if(alunos == null) return null;

    for(Aluno aluno : alunos) {
      if(aluno.getMatricula() == chave) return aluno;
    }

    return null;
  }
}
