package exercicio3;

public class Main {
    public static void main(String[] args) {
 
        Aluno aluno1 = new Aluno(20, "João", 7.5);
        Aluno aluno2 = new Aluno(21, "Maria", 8.0);
        Aluno aluno3 = new Aluno(22, "José", 6.0);
        Aluno aluno4 = new Aluno(23, "Ana", 9.0);
        Aluno aluno5 = new Aluno(24, "Carlos", 8.5);
        Aluno aluno6 = new Aluno(25, "Beatriz", 7.0);  

        
        VetorAluno vetor = new VetorAluno();

       
        vetor.adiciona(aluno1.getNota());
        vetor.adiciona(aluno2.getNota());
        vetor.adiciona(aluno3.getNota());
        vetor.adiciona(aluno4.getNota());
        vetor.adiciona(aluno5.getNota());

       
        System.out.println("Tamanho atual do vetor (deve ser 5): ");
        System.out.println(vetor.tamanho());

        
        vetor.adiciona(aluno6.getNota());
        System.out.println("\nTamanho após adicionar uma nota extra (deve expandir para 10): ");
        System.out.println(vetor.tamanho());

        
        System.out.println("\nVerificando se o vetor contém a nota de João (7.5): ");
        System.out.println(vetor.contem(aluno1.getNota()));  

        System.out.println("\nVerificando se o vetor contém a nota de Beatriz (7.0): ");
        System.out.println(vetor.contem(aluno6.getNota())); 

        System.out.println("\nVerificando se o vetor contém a nota de um aluno inexistente (10.0): ");
        System.out.println(vetor.contem(10.0)); 

        
        System.out.println("\nRemovendo a nota de Maria (8.0)...");
        vetor.remover(aluno2.getNota());  
        System.out.println(vetor.tamanho());  

        System.out.println("\nVerificando se o vetor contém a nota de Maria após remoção: ");
        System.out.println(vetor.contem(aluno2.getNota()));  
    }
}

