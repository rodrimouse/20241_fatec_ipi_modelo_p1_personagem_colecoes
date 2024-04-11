import java.util.Random;
public class JogoV2 {
  public static void main(String[] args) throws Exception{
    var p = new Personagem();
    //exercicio: adicione um personagem que come demais
    var gerador = new Random();
    p.nome = "Gamal";
    // p2.sono = 10;
    // p2.energia = 1;
    // p2.fome = 2;
    // p3.sono = 4;
    // p3.fome = 10;
    // p3.energia = 2;
    
    while(p.energia > 0){
      int oQueFazer = gerador.nextInt(1);
      switch(oQueFazer){
        default:
          p.cacar();
          break;
        // case 1:
        //   p.comer();
        //   break;
        // case 2:
        //   p.dormir();
        //   break;
      }
      System.out.println(p);
      System.out.println("**************************");
      Thread.sleep(2000);
    }
  }
  // srand(time(NULL))
}