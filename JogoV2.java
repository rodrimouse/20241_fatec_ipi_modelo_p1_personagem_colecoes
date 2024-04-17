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
      int brigaDeGalo = gerador.nextInt(2);
      if(brigaDeGalo == 0 && p.energia >0 && p2.energia >0){
          p.energia--;
          System.out.printf("\n%s bateu mais forte!\n",p2.nome);
      }
      else if(brigaDeGalo == 1 && p2.energia >0 && p.energia >0){
          p2.energia--;
          System.out.printf("\n%s Bateu mais forte!\n", p.nome);
      }
      
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