package exercicio2;
public class VetorAluno {

	private double [] notas = new double[5];
    private int totalNotas = 0; //add objt aluno

    public void adiciona(double nota){
        this.notas[this.totalNotas] = nota;
        this.totalNotas++;
    }

    public void tamanho(){
        System.out.println("Tamanho do vetor: " + this.notas.length);
    }
    public boolean contem(double nota){
        for(int i = 0; i < this.totalNotas; i++){
            if(nota == this.notas[i]){
                return true;
            }
        }
        return false;
    }
}
