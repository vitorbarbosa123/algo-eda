package AULAS.tabelasHash;

public class FuncaoHash {

  int[] tabela;

  private int hash(int chave) {
    return chave;
  }
  // a chave é o próprio valor de hash
  // problemas: chaves com grandes valores;
  // numero da chave pode ser menor do que o usado

  // alternativa
  private int hashMelhorado(int chave) {
    return chave % tabela.length;
  }
  // a utilização do modulo garante que:
  // vai gerar um inteiro de indices válidos do array
  // para mesma chave, a função sempre terá o mesmo valor

  
}
