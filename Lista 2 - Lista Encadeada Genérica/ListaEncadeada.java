public class ListaEncadeada<T> {

    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public ListaEncadeada(){
        this.primeira = this.ultima = null;
        this.totalDeElementos = 0;
    }

    public void adiciona(T elemento, int posicao) throws Exception{
        try {
            if (this.totalDeElementos == 0) {
                throw new IndexOutOfBoundsException();
            }
            else if (posicao < 0 || posicao >= this.totalDeElementos) {
                throw new IllegalArgumentException();
            }
            else if(posicao == 0){
                adicionaInicio(elemento);
            }
            else if(posicao == this.totalDeElementos - 1){
                adicionaFim(elemento);
            }
            else {
                Celula nova = new Celula(elemento);
                Iterador<T> it = new Iterador<T>(this.primeira);
                int i = 0;
                while (it.hasNext()) {
                    Celula atual = it.getAtual();
                    if (i != posicao) {
                        if (i == posicao - 1){
                            Celula proximo = atual.getProximo();

                            atual.setProximo(nova);
                            nova.setProximo(proximo);
                            this.totalDeElementos++;
                            break;
                        }
                        it.next();
                        i++;
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e){ System.out.println("A lista está vazia"); }
        catch (IllegalArgumentException e){ System.out.println("A posição está fora de alcance"); }
    }

    public void adicionaInicio(T elemento){
        this.primeira = new Celula(this.primeira, elemento);

        if(this.totalDeElementos == 0){
            this.ultima = this.primeira;
        }
        this.totalDeElementos++;
    }

    public void adicionaFim(T elemento){
        if(this.totalDeElementos == 0){
            adicionaInicio(elemento);
        }else {
            Celula nova = new Celula(elemento);
            this.ultima.setProximo(nova);
            this.ultima = nova;
            totalDeElementos++;
        }
    }

    public boolean existeDado(T elemento){
        try {
            if (this.totalDeElementos == 0) {
                throw new IndexOutOfBoundsException();
            }
            else{
                Iterador<T> it = new Iterador<T>(this.primeira);
                int i = 0;
                while (it.hasNext()) {
                    Celula atual = it.getAtual();
                    if (atual.getElemento() == elemento) {
                        return true;
                    }
                    else {
                        it.next();
                        i++;
                    }
                }
                return false;
            }
        }
        catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    public T Recupera(int posicao){
        try {
            if (this.totalDeElementos == 0) {
                throw new IndexOutOfBoundsException();
            }
            else if (posicao < 0 || posicao >= this.totalDeElementos) {
                throw new IllegalArgumentException();
            }
            else if(posicao == 0){
                return (T) this.primeira.getElemento();
            }
            else if(posicao == this.totalDeElementos - 1){
                return (T) this.ultima.getElemento();
            }
            else {
                Iterador<T> it = new Iterador<T>(this.primeira);
                int i = 0;
                while (it.hasNext()) {
                    Celula atual = it.getAtual();
                    if (i == posicao) {
                        return (T) atual.getElemento();
                    }
                    it.next();
                    i++;
                }
                return null;
            }
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("A lista está vazia");
            return null;
        }
        catch (IllegalArgumentException e){
            System.out.println("A posição está fora de alcance");
            return null;
        }
    }

    public void remove(int posicao){
        try {
            if (this.totalDeElementos == 0) {
                throw new IndexOutOfBoundsException();
            }
            else if (posicao < 0 || posicao >= this.totalDeElementos) {
                throw new IllegalArgumentException();
            }
            else if(posicao == 0){
                removeInicio();
            }
            else if(posicao == this.totalDeElementos - 1){
                removeFim();
            }
            else {
                Iterador<T> it = new Iterador<T>(this.primeira);
                int i = 0;
                while (it.hasNext()) {
                    Celula anterior = it.getAtual();
                    if (i != posicao) {
                        if (i == posicao - 1){
                            Celula atual = anterior.getProximo();
                            Celula proximo = atual.getProximo();
                            anterior.setProximo(proximo);
                            atual.setElemento(null);
                            atual.setProximo(null);
                            this.totalDeElementos--;
                            break;
                        }
                        it.next();
                        i++;
                    }
                }
            }
        }
        catch (IndexOutOfBoundsException e){ System.out.println("A lista está vazia"); }
        catch (IllegalArgumentException e){ System.out.println("A posição está fora de alcance"); }
    }

    public void removeInicio(){
        try {
            if (this.totalDeElementos == 0) {
                throw new IndexOutOfBoundsException();
            }
            else if (this.totalDeElementos == 1) {
                this.primeira.setProximo(null);
                this.primeira.setElemento(null);
                this.ultima = this.primeira;
                this.totalDeElementos = 0;
            }
            else {
                Celula proximo = this.primeira.getProximo();
                this.primeira.setProximo(null);
                this.primeira.setElemento(null);
                this.primeira = proximo;
                this.totalDeElementos--;
            }
        }
        catch (IndexOutOfBoundsException e){ System.out.println("A lista está vazia"); }
    }

    public void removeFim(){
        try {
            if (this.totalDeElementos == 0) {
                throw new IndexOutOfBoundsException();
            }
            else if (this.totalDeElementos == 1) {
                this.primeira.setProximo(null);
                this.primeira.setElemento(null);
                this.ultima = this.primeira;
                this.totalDeElementos = 0;
            }
            else {
                Iterador<T> it = new Iterador<T>(this.primeira);
                int i = 0;
                while (it.hasNext()) {
                    Celula anterior = it.getAtual();
                    if (i == this.totalDeElementos - 2) {
                        anterior.setProximo(null);
                        this.ultima.setElemento(null);
                        this.ultima = anterior;
                        this.totalDeElementos--;
                        break;
                    }
                    it.next();
                    i++;
                }
            }
        }
        catch (IndexOutOfBoundsException e){ System.out.println("A lista está vazia"); }
    }

    public int tamanho(){
        return this.totalDeElementos;
    }

    public void limpa(){
        try {
            if (this.totalDeElementos == 0) {
                throw new IndexOutOfBoundsException();
            }
            else {
                Iterador<T> it = new Iterador<T>(this.primeira);
                int i = 0;
                while (it.hasNext()) {
                    Celula atual = it.getAtual();
                    atual.setProximo(null);
                    atual.setElemento(null);
                    it.next();
                    i++;
                }
                this.totalDeElementos = 0;
                this.primeira.setProximo(null);
                this.primeira.setElemento(null);
                this.ultima = this.primeira;
            }
        }
        catch (IndexOutOfBoundsException e){ System.out.println("A lista já está vazia"); }
    }

    public String imprimir(){
        if (totalDeElementos == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        Iterador<T> it = new Iterador<T>(this.primeira);

        int i=0;
        while (it.hasNext()){
            Celula atual = it.getAtual();
            if(atual.getElemento() == null) builder.append("-");
            else builder.append(atual.getElemento());
            if(i < this.totalDeElementos - 1) builder.append(", ");
            it.next();
            i++;
        }

        builder.append("]");

        return builder.toString();
    }

}
