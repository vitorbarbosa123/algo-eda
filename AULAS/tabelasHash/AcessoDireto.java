package AULAS.tabelasHash;

public class AcessoDireto {

  public static void main(String[] args) {
    Aluno[] alunos = new Aluno[2000];

    Aluno joao = new Aluno(21, "João Arthur");

    // inserindo em tempo constante
    alunos[joao.getMatricula()] = joao;

    // buscando em tempo constante
    if (alunos[joao.getMatricula()] != null)


    // removendo em tempo constante
    alunos[joao.getMatricula()] = null;
  }

  
}
