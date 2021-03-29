package src;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import org.graalvm.compiler.asm.sparc.SPARCAssembler.Br;


public class Corrida{ 
   
   private static Veiculo[] carros = new Veiculo[20];
  
   public static void main(String[] args) {
      Opcoes();
   }
   
   
   public static void Opcoes()
   {
    
    int num = 1;
    while(num != 11){

      Scanner entrada = new Scanner(System.in);
      System.out.println("\n -- Menu da corrida -- \n");
      System.out.println("1- Para incluir veiculo; "); // ta feito
      System.out.println("2- Para remover veiculo; "); // cinglair
      System.out.println("3- Para abastecer veiculo;");  // cris
      System.out.println("4- Para movimentar veiculo;");  // cinglair
      System.out.println("5- Para movimentar todos os veiculo;");// cris
      System.out.println("6- Para imprimir todos veiculo;");// cinglair
      System.out.println("7- Para esvaziar pneu especifico;");//cris
      System.out.println("8- Para calibrar pneu especifico;"); // cinglair
      System.out.println("9- Para calibrar todos os pneus;");  // cris
      System.out.println("10- Imprimir pista;");//cris
      System.out.println("11- Sair da aplicação;");
      System.out.println("Digite a opção desejada: ");
      num = entrada.nextInt();
  
      switch (num) {
          case 1:
            incluirCarro();
            break;
          case 2:
            removerCarro();
            break;
          case 3:
            abastecer();
            break;
          case 4:
            movimentar();
            break;
          case 5:
            movimentarTodos();
            break;
          case 6:
            imprimirDados();
            break;
          case 7:
            esvaziarPneu();
            break;
          case 8:
            calibrarPneu();
            break;
          case 9:
            calibrarTodos();
            break;
          case 10:
            carrosPista();
            break;
          case 11:
            System.out.println("Volte Sempre !!!");
            break;
          default:
            System.out.println("Número inválido");
     }
    }
   }
   public static int pedirID() {
    int id;
    System.out.print("\nInforme o id do carro: ");
    Scanner teclado = new Scanner(System.in);
    id = teclado.nextInt();
    return id;
}
  
  public static void incluirCarro() { // case 1:
      int i;
      for (i = 0; i < carros.length; i++) {
          if (carros[i] == null) {
              carros[i] = new Veiculo();
              carros[i].iniciarVeiculo();
              carros[i].setId(i+1);
              i = carros.length;
              System.out.println("\nVeículo adicionado com sucesso");
          }
      }
      if (i < carros.length) {
          System.out.println("\nNão foi possível adicionar o veículo");
      }
  }
  public static void removerCarro(){ //case 2:
    int id = pedirID();
    if (id > 0 && id <= carros.length && carros[id-1] != null){
      carros[id-1] = null;
      System.out.print("\nCarro removido com sucesso\n");
    }
    else{
      System.out.print("\nCarro não encontrado\n");
    }
  }
  public static void abastecer() //case 3:
    {
      int id = pedirID();
      
      Scanner ler = new Scanner(System.in);
      float combustivel;
      System.out.printf("Informe a quantidade de combustivel: \n");
      combustivel = ler.nextFloat(); 
      System.out.print( combustivel);
      carros[id-1].setCombustivel(combustivel + carros[id-1].getCombustivel()); 
      
    }

    public static void movimentar(){ //case 4:
      
      int id = pedirID();
      Scanner ler = new Scanner(System.in);
      System.out.printf("Informe a distância a ser movimentada: \n");
      int movimento = ler.nextInt();
      carros[id-1].setDistPecorrida(movimento);
      System.out.printf("Veículo movimentado com sucesso \n");

    }

    public static void movimentarTodos(){ //case 5:
      
      Scanner ler = new Scanner(System.in);
      System.out.printf("Informe a distância a ser movimentada: \n");
      int movimento = ler.nextInt();
      for (Veiculo veiculo : carros) {
        if(veiculo != null){
          veiculo.setDistPecorrida(movimento);
        }
      }
      System.out.printf("Veículos movimentados com sucesso \n");

    }

    public static void imprimirDados(){ //case 6:

      for (Veiculo veiculo : carros) {
        if(veiculo != null)
          System.out.print(veiculo);
      }
    }

    public static void esvaziarPneu(){
      int id = pedirID();
      Scanner ler = new Scanner(System.in);
      int pneu = -1;
      while(pneu < 0 || pneu > 4){
        System.out.printf("Informe o pneu a ser esvaziado: \n");
        pneu = ler.nextInt();
        if(pneu < 0 || pneu > 4)
          System.out.printf("Pneu incorreto, informe uma opção válida");
      }
      carros[id-1].esvaziarPneu(pneu);
      System.out.printf("Pneu esvaziado");
    }

    public static void calibrarPneu(){
      int id = pedirID();
      Scanner ler = new Scanner(System.in);
      
      int pneu = -1;
      while(pneu < 0 || pneu > 4){
        System.out.printf("Informe o pneu a ser calibrado: \n");
        pneu = ler.nextInt();
        if(pneu < 0 || pneu > 4)
          System.out.printf("Pneu incorreto, informe uma opção válida");
      }
      carros[id-1].calibrarPneu(pneu);
      System.out.printf("Pneu calibrado");
    }

    public static void calibrarTodos(){
      int id = pedirID();
      carros[id-1].calibrarTodosPneu();
      System.out.printf("Pneus calibrados");
    }

    public static void carrosPista(){
      for (Veiculo veiculo : carros) {
        if(veiculo!=null)
          veiculo.carroNaPista();
      }

    }
}