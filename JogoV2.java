import java.util.Random;
public class JogoV2 {
  public static void main(String[] args) throws Exception{
    var p = new Personagem();
    var p2 = new Personagem();
    //exercicio: adicione um personagem que come demais
    var gerador = new Random();
    p.nome = "Gamal";
    p2.nome = "Dersin2k";
    
    while(p.energia > 0 || p2.energia >0){
      int oQueFazer = gerador.nextInt(2);
      switch(oQueFazer){
        default:
          if(p.energia > 0){
            p.cacar();}
            else{
              System.out.printf("%s está morto\n",p.nome);
            }
          p2.cacar();
          break;
        case 1:
          // p.comer();
          p2.comer();
          break;
        // case 2:
        //   p.dormir();
        //   break;
      }
      System.out.println(p);
      System.out.println("**************************");
      System.out.println(p2);
      System.out.println("**************************");
      Thread.sleep(5000);
    }
  }
  // srand(time(NULL))
}