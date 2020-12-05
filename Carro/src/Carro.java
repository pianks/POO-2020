import java.util.Scanner;
public class Carro {

    int tanque = 0;
    int maxTanque = 100;
    int banco = 0;
    int maxBanco = 2;

    public void embarcar(int qtd){
        if(banco > 1){
            System.out.println("O carro está cheio!!");
        }else{
            System.out.println("Ainda existe vaga");
            banco += qtd;
        }
    }

    public void desembarcar(int qtd){
        if(banco < 0){
            System.out.println("Não tem ninguém no carro");
        }else{
            System.out.println("Pode desembarcar");
            banco -= qtd;
        }
    }

    public void abastecer(int qtd){
        if(qtd + this.tanque >= maxTanque){
            int qtdTEMPORARIA = qtd;
            while(true){
                if(this.tanque<this.maxTanque){
                    this.tanque += 1;
                    qtd -=1;
                }else
                break;
            }
                qtdTEMPORARIA -= qtd;
                System.out.println("Vocês abasteceu "+qtdTEMPORARIA+" de gasolina e foram descartadas "+qtd+" de gasolina");
        }
    }

    public void dirigir(int qtd){
        qtd = this.tanque;
        if(this.banco > 0 && this.tanque > 0){
            int tantoKM = 0;
            while(true){
                if(this.banco > 0 && qtd > 0){
                    this.tanque -=1;
                    qtd -=1;
                    tantoKM +=1;
                }else{
                    System.out.println("O tanto de KM dirigido foi "+tantoKM+" KM");
                    break;
                }               
            }

        }else{
            System.out.println("Não tem como dirigir");
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
		Carro carro = new Carro();
		while(true) {
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
			if(ui[0].equals("sair")) {
				break;
			}else if(ui[0].equals("embarcar")) {
                            int qtd = Integer.parseInt(ui[1]);
                            carro.embarcar(qtd);
			}else if(ui[0].equals("desembarcar")){
                            int qtd = Integer.parseInt(ui[1]);
                            carro.desembarcar(qtd);
                        }else if(ui[0].equals("abastecer")){
                            int qtd = Integer.parseInt(ui[1]);
                            carro.abastecer(qtd);
                        }else if(ui[0].equals("dirigir")){
                            int qtd = Integer.parseInt(ui[1]);
                            carro.dirigir(qtd);
                        }else {
				System.out.println("Comando invalido");
			}
		}
		scanner.close();
    }
}
