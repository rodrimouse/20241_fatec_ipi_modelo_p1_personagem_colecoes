import java.util.Random;

public class JogoV2 {
  public static void main(String[] args) throws Exception{
    var p = new Personagem();
    var p2 = new Personagem();

    //exercicio: adicione um personagem que come demais
    var gerador = new Random();
    p.nome = "Gamal";
    p2.nome = "Dersin2k";
    
    while(p.energia > 0 || p2.energia > 0){
      
      p.jogar(p);
      p2.jogar(p2);
      if(p.energia > 0){
        System.out.println(p);
        System.out.println("**************************");
      }
      if(p2.energia > 0){
        System.out.println(p2);
        System.out.println("**************************");
      }
      Thread.sleep(1000);
    }
  }
  
}