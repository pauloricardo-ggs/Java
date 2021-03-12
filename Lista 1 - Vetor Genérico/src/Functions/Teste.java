package Functions;

public class Teste {
    public static void main(String[] args){
        Vetor<Integer> vetor = new Vetor<Integer>(5);
        System.out.println("Vetor criado");

        System.out.println("\n\n\nTeste Adicionar Inicio (Desloca as posições ocupadas para a direita e põe o elemento na " +
                "\nprimeira posição)\n");
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tAntes.........: " + vetor.imprimir());
        for (int i=1; i<=3; i++){
            vetor = testeAdicionaInicio(vetor, i);
            System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\telemento = " + i + "..: " + vetor.imprimir());
        }

        System.out.println("\n\n\nTeste Adicionar Fim (Coloca o elemento na primeira posição livre)\n");
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tAntes.........: " + vetor.imprimir());
        for (int i=4; i<=6; i++){
            vetor = testeAdicionaFim(vetor, i);
            System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\telemento = " + i + "..: " + vetor.imprimir());
        }

        System.out.println("\n\n\nTeste Adicionar Em Uma Posição (O algoritmo identifica se existem posições vazias entre " +
                "\nposições ocupadas. Se houver, o algoritmo desloca as posições ocupadas para a esquerda, " +
                "\nnão deixando lacunas)\n");
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tAntes.........: " + vetor.imprimir());
        for (int i=7; i<=9; i++){
            vetor = testeAdiciona(vetor, i);
            System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\telemento = " + i + "..: " + vetor.imprimir());
        }

        System.out.println("\n\n\nTeste Remove Inicio (Remove o elemento na primeira posição e move todos os outros para esquerda)\n");
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tAntes.........: " + vetor.imprimir());
        vetor = testeRemoveInicio(vetor);
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tDepois........: " + vetor.imprimir());

        System.out.println("\n\n\nTeste Remove Fim (Remove o elemento na última posição)\n");
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tAntes.........: " + vetor.imprimir());
        vetor = testeRemoveFim(vetor);
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tDepois........: " + vetor.imprimir());

        System.out.println("\n\n\nTeste Remove De Uma Posição (Remove o elemento na posição dada)\n");
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tAntes.........: " + vetor.imprimir());
        for (int i=3; i<=5; i+=2){
            vetor = testeRemove(vetor, i);
            System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tPosição = " + i + "...: " + vetor.imprimir());
        }

        System.out.println("\n\n\nTeste Recupera (Retorna o elemento na posição dada)\n");
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tVetor.........: " + vetor.imprimir());
        System.out.println("Posição..........: 3\tElemento......: " + vetor.Recupera(3));

        System.out.println("\n\n\nTeste Limpa (Limpa o vetor e retorna para o tamnho original)\n");
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tAntes.........: " + vetor.imprimir());
        vetor.limpa();
        System.out.println("Quant. Elementos = " + vetor.Tamanho() + "\tDepois........: " + vetor.imprimir());

    }

    static Vetor testeAdicionaInicio(Vetor<Integer> vetor, int teste){
        vetor.adicionaInicio(teste);
        return vetor;
    }

    static Vetor testeAdicionaFim(Vetor<Integer> vetor, int teste){
        vetor.adicionaFim(teste);
        return vetor;
    }

    static Vetor testeAdiciona(Vetor<Integer> vetor, int teste){
        int posicao=9;
        if (teste==8) posicao=3;
        else if (teste==9) posicao=5;
        vetor.adiciona(teste, posicao);
        return vetor;
    }

    static Vetor testeRemoveInicio(Vetor<Integer> vetor){
        vetor.removeInicio();
        return vetor;
    }

    static Vetor testeRemoveFim(Vetor<Integer> vetor){
        vetor.removeFim();
        return vetor;
    }

    static Vetor testeRemove(Vetor<Integer> vetor, int teste){
        vetor.remove(teste);
        return vetor;
    }

}
