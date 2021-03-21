public class Teste {
    public static void main(String[] args) throws Exception {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        System.out.println("Lista encadeada criada");

        System.out.println("\n\n\nTeste Adicionar Inicio\n");
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tAntes.........: " + lista.imprimir());
        for (int i=1; i<=3; i++){
            lista = testeAdicionaInicio(lista, i);
            System.out.println("Quant. Elementos = " + lista.tamanho() + "\tElemento = " + i + "..: " + lista.imprimir());
        }

        System.out.println("\n\n\nTeste Adicionar Fim\n");
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tAntes.........: " + lista.imprimir());
        for (int i=4; i<=6; i++){
            lista = testeAdicionaFim(lista, i);
            System.out.println("Quant. Elementos = " + lista.tamanho() + "\tElemento = " + i + "..: " + lista.imprimir());
        }

        System.out.println("\n\n\nTeste Adicionar Em Uma Posição\n");
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tAntes.........: " + lista.imprimir());
        for (int i=7; i<=9; i++){
            lista = testeAdiciona(lista, i);
            System.out.println("Quant. Elementos = " + lista.tamanho() + "\tPosição: " + (i-3) + "\t|\tElemento = " + i + "..: " + lista.imprimir());
        }

        System.out.println("\n\n\nTeste Remove Inicio\n");
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tAntes.........: " + lista.imprimir());
        lista = testeRemoveInicio(lista);
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tDepois........: " + lista.imprimir());

        System.out.println("\n\n\nTeste Remove Fim\n");
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tAntes.........: " + lista.imprimir());
        lista = testeRemoveFim(lista);
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tDepois........: " + lista.imprimir());

        System.out.println("\n\n\nTeste Remove De Uma Posição\n");
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tAntes..........: " + lista.imprimir());
        for (int i=3; i<=5; i+=2){
            lista = testeRemove(lista, i);
            System.out.println("Quant. Elementos = " + lista.tamanho() + "\tPosição = " + i + " ...: " + lista.imprimir());
        }

        System.out.println("\n\n\nTeste Recupera\n");
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tLista.........: " + lista.imprimir());
        System.out.println("Posição..........: 3\tElemento......: " + lista.Recupera(3));

        System.out.println("\n\n\nTeste Limpa\n");
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tAntes.........: " + lista.imprimir());
        lista.limpa();
        System.out.println("Quant. Elementos = " + lista.tamanho() + "\tDepois........: " + lista.imprimir());

    }

    static ListaEncadeada testeAdicionaInicio(ListaEncadeada<Integer> lista, int teste){
        lista.adicionaInicio(teste);
        return lista;
    }

    static ListaEncadeada testeAdicionaFim(ListaEncadeada<Integer> lista, int teste){
        lista.adicionaFim(teste);
        return lista;
    }

    static ListaEncadeada testeAdiciona(ListaEncadeada<Integer> lista, int teste) throws Exception {
        int posicao = teste - 3;
        lista.adiciona(teste, posicao);
        return lista;
    }

    static ListaEncadeada testeRemoveInicio(ListaEncadeada<Integer> lista){
        lista.removeInicio();
        return lista;
    }

    static ListaEncadeada testeRemoveFim(ListaEncadeada<Integer> lista){
        lista.removeFim();
        return lista;
    }

    static ListaEncadeada testeRemove(ListaEncadeada<Integer> lista, int teste){
        lista.remove(teste);
        return lista;
    }

}
