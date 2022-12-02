public class EndereçamentoAberto {
  
  // método para resolução de colisões por endereçamento
  // aberto
  
  // sondagem linear
  public void put(int chave, Aluno valor) {

    int sondagem = 0;
    int hash;
    while (sondagem < tabela.length) {

      hash = (hash(chave) + sondagem) % tabela.length;

      // caso o indice seja igual a null ou à "APAGADO" ou
      // a chave a ser adicionada é igual a contida na 
      // posição, o elemento é adicionado.
      if( tabela[hash] == null ||
          tabela[hash].getMatricula() == chave ||
          tabela[hash].equals("APAGADO")) {
            tabela[hash] = valor;
            return;
          } 
      sondagem += 1;
    }
    throw new TabelaCheiaException();
  }
}
