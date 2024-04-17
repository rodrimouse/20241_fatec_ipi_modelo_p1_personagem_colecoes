import java.util.Random;

public class Personagem{
  //variáveis de instância(objeto)
  String nome;
  int energia;
  private int fome;
  private int sono;
  private VetorDinamico inventario;

  //esse é o construtor padrão
  //criado automaticamente pelo compilador, ainda que não seja escrito explicitamente
  Personagem(){
    
    nome = null;
    energia = 10;
    fome = 0;
    sono = 0;
    inventario = new VetorDinamico();
    Random gerador = new Random();
        for (int i = 0; i < 4; i++) {
            int oQueAdicionar = gerador.nextInt(6);
            inventario.adicionar(pegarItemAleatorio(oQueAdicionar));
        }
  }

  //construtor personalizado
  //o que viabiliza a sua existência é a sobrecarga de construtores
  Personagem(int energia, int fome, int sono){
    if (energia >= 0 && energia <= 10)
      this.energia = energia;
    if (fome >= 0 && fome <= 10)
      this.fome = fome;
    if (sono >= 0 && sono <= 10)
      this.sono = sono;
  }

  void cacar(){
    var gerador = new Random();
    System.out.printf("%s esta cacando...\n", nome);
    energia -= 2; // energia = energia - 2;
    fome = Math.min(fome + 1, 10);
    //resolver com o ternário
    sono = sono < 10 ? sono + 1 : sono;
    int oQueCacar = gerador.nextInt(5);
    inventario.adicionar(pegarItemAleatorio(oQueCacar));
    

    if(energia <= 0){
      System.out.println("O personagem morreu");
    }
  }

  private String pegarItemAleatorio(int sorteado) {
    switch (sorteado) {
        default:
            return "Javali selvagem";
        case 1:
            return "Amora";
        case 2:
            return "Batata frita";
        case 3:
            return "Cogumelo mágico";
        case 4:
            return "Duende";
    }
}

  void comer() {
    //se tiver fome
      //comer e reduzir o valor de fome de 1
      //aumentar o valor de energia de 1
    //caso contrario
      //so vai avisar que esta sem fome
      if (fome > 0) {
        if (inventario.tamanho() > 0) {
            inventario.removerNoFinal();
            System.out.printf("%s está comendo...\n", nome);
            fome--;
            energia = Math.min(10, energia + 1);
        } else {
            System.out.printf("%s não tem itens para comer...\n", nome);
        }
    } else {
        System.out.printf("%s não está com fome...\n", nome);
    }
  }

  void dormir(){
    if(sono >= 1){
      System.out.printf("%s esta dormindo...\n", nome);
      sono -= 1;
      energia = Math.min(energia + 1, 10);
    }
    else{
      System.out.printf("%s sem sono...\n", nome);
    }
  }

  void jogar(Personagem p){
    var gerador = new Random();
    if(vivo(p)){
    int oQueFazer = gerador.nextInt(3);
    switch(oQueFazer){
      default:
        p.cacar();
        break;
      case 1:
        p.comer();
        break;
      case 2:
        p.dormir();
        break;
      }
    }
    else{
      System.out.printf("%s está morto...\n", p.nome);
    }
  }

  boolean vivo(Personagem p){
    if(p.energia !=0){
      return true;
    }
    else{
      return false;
    }
  }
  public String toString(){
    return String.format(
      "%s: (e:%d, f:%d, s:%d), Inventário: %s",
      nome, energia, fome, sono, inventario
    );
  }
}