/*
 * Questão: 
 *
 * Suponha que você tem uma pilha S contendo n elementos e uma lista duplamente
 * ligada Q que está inicialmente vazia. DESCREVA como você pode usar Q para 
 * percorrer S para ver se ela contém um certo elemento x, com a restrição adicional
 * que seu algoritmo deve retornar os elementos de volta para S em sua ordem 
 * original. Lembrando que você não pode usar nenhuma outra estrutura auxiliar 
 * para resolver esse problema - apenas S e Q e demais variáveis simples.
 *
 * Resolução:
 *
 * Para exemplificar, vamos supor que eu tenho uma garagem bastante estreita e
 * que não é possível manobrar os carros dentro dela, ou seja, quando eu estacionar
 * um carro ele vai para o final da garagem e o próximo carro que entrar vai
 * impedir que este saia, nesta garagem eu preciso guardar todos os meus carros
 * (Camaro, Corvette, Tesla S, Fusca, Corolla, Onix, Agile, Punto, Chevette,
 * Mustang, BMW 320i e Jeep Renegado) e para remover algum da garagem eu preciso
 * colocar os outros na mesma ordem que estava anteriormente, para isso vou escrever
 * um algoritmo que ao remover um carro da minha garagem eu guardo a sua ordem em
 * uma lista duplamente ligada. segue a implementação disso em JAVA:
 */

public class Atividade3 {

    public static void main(String[] args) {

        // Esta pilha vai representar minha gargem;
        Stack<String> S = new Stack<String>();

        // Esta lista duplamente ligada representa os carros que foram removidos
        DoublyLinkedList<String> Q = new DoublyLinkedList<String>();

        // Cada push representa um carro sendo estacionado na garagem
        S.push("Camaro");
        S.push("Corvette");
        S.push("Tesla S"); // hahaha eu sou rico
        S.push("Fusca"); // hahaha só q n
        S.push("Corolla");
        S.push("Onix");
        S.push("Agile");
        S.push("Punto");
        S.push("Chevette");
        S.push("Mustang");
        S.push("BMW 320i");
        S.push("Jeep Renegade");

        // Exibe os carros na garagem
        System.out.println("Carros atualmente na garagem:");
        System.out.println(S.toString());

        // Este é o carro que eu quero remover da garagem
        String x = "Tesla S";
        String r;
        // Neste ponto eu vou removendo os carros o carro x
        do {
            r = S.pop();
            Q.add(r);
        } while (r != x);

        // Aqui eu mostro a lista de carros que foi removido
        System.out.println("Carros que foram removidos");
        System.out.println(Q.toString());

        // Aqui é listado os carros que pemaneceram na garagem
        System.out.println("Carros que permanecerem na garagem");
        System.out.println(S.toString());
    }

}

/*
 * $ javac Atividade3.java Stack.java DoublyLinkedList.java && java Atividade3
 * 
 * Carros atualmente na garagem:
 * Jeep Renegade BMW 320i Mustang Chevette Punto Agile Onix Corolla Fusca Tesla S Corvette Camaro
 * Carros que foram removidos
 * Jeep Renegade BMW 320i Mustang Chevette Punto Agile Onix Corolla Fusca Tesla S
 * Carros que permanecerem na garagem
 * Corvette Camaro
 */
