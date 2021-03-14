package Functions;


public class Vetor<T> {

    T[] vetor;
    int totalElementos = 0;
    int tamanho;

    public Vetor(){
    }

    public Vetor(int tamanho){
        this.vetor = (T[]) new Object[tamanho];
        this.tamanho = tamanho;
    }

    public boolean existeDado(int posicao){
        return (this.vetor[posicao] != null);
    }

    public boolean vazio(){
        return (this.vetor[0] == null);
    }

    public void moveEsq(){
        Iterador it = new Iterador(this.vetor);

        int i=0, cont=0;
        while (it.hasNext() && i<this.vetor.length-1){
            if (this.vetor[i] != null) cont++;
            if (it.next() == null && this.vetor[i+1] != null) {
                this.vetor[i] = this.vetor[i + 1];
                this.vetor[i + 1] = null;
                cont = 0;
            }
            i++;
        }
        if (cont < totalElementos) moveEsq();
    }

    public void adiciona(T elemento, int posicao){
        try {
            if (Tamanho() == this.vetor.length) Redimensiona();
            if (!existeDado(posicao)) {
                this.vetor[posicao] = elemento;
                this.totalElementos++;
                moveEsq();
            } else {
                Iterador it = new Iterador(this.vetor);

                int i = 0;
                while (it.hasNext()) {
                    it.next();
                    if (this.vetor[i + 1] == null) {
                        this.vetor[i + 1] = this.vetor[i];
                        if (i == posicao) {
                            this.vetor[i] = elemento;
                            this.totalElementos++;
                            break;
                        }
                        this.vetor[i] = null;
                        i--;
                    } else {
                        i++;
                    }
                }
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) { System.out.println("A posição não pôde ser alcançada");}
    }

    public void adicionaInicio(T elemento){
        if (Tamanho() == this.vetor.length) {
            Redimensiona();
        }
        if (this.vetor[0] == null) {
            this.vetor[0] = elemento;
            this.totalElementos++;
        }
        else {
            Iterador it = new Iterador(this.vetor);

            int i = this.totalElementos-1;
            while (it.hasNext()) {
                it.next();
                this.vetor[i+1] = this.vetor[i];
                if (i == 0) {
                    this.vetor[i] = elemento;
                    this.totalElementos++;
                    break;
                }
                i--;
            }
        }
    }

    public void adicionaFim(T elemento){
        if (Tamanho() == this.vetor.length) {
            Redimensiona();
        }

        Iterador it = new Iterador(this.vetor);

        int i=0;
        while (it.hasNext()){
            if (it.next() == null) {
                this.vetor[i] =  elemento;
                this.totalElementos++;
                break;
            }
            i++;
        }
    }

    public void remove(int posicao){
        try {
            if (vazio()) System.out.println("O vetor está vazio");
            else if (!existeDado(posicao)) System.out.println("Não existe dados nessa posição");
            else {
                this.vetor[posicao] = null;
                this.totalElementos--;
                moveEsq();
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) { System.out.println("A posição não pôde ser alcançada");}
    }

    public void removeInicio(){
        try {
            if (vazio()) System.out.println("O vetor está vazio");
            else if (!existeDado(0)) System.out.println("Não existe dados nessa posição");
            else {
                this.vetor[0] = null;
                this.totalElementos--;
                moveEsq();
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) { System.out.println("A posição não pôde ser alcançada");}
    }

    public void removeFim(){
        try {
            if (vazio()) System.out.println("O vetor está vazio");
            else if (!existeDado(totalElementos - 1)) System.out.println("Não existe dados nessa posição");
            else {
                this.vetor[totalElementos - 1] = null;
                this.totalElementos--;
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) { System.out.println("A posição não pôde ser alcançada");}
    }

    public void Redimensiona(){
        if(this.totalElementos == this.vetor.length){
            T[] novoVetor = (T[]) new Object[this.vetor.length*2];
            for (int i=0; i< this.vetor.length; i++){
                novoVetor[i] = this.vetor[i];
            }
            this.vetor = novoVetor;
        }
    }

    public T Recupera(int posicao){
        try {
            if (vazio()) System.out.println("O vetor está vazio");
            else if (!existeDado(posicao)) System.out.println("Não existe dados nessa posição");
            else {
                return this.vetor[posicao];
            }
        }
        catch (Exception ArrayIndexOutOfBoundsException) { System.out.println("A posição não pôde ser alcançada");}
        return null;
    }

    public int Tamanho(){
        return this.totalElementos;
    }

    public void limpa(){
        T[] vetorLimpo = (T[]) new Object[this.tamanho];
        this.vetor = vetorLimpo;
        totalElementos = 0;
    }

    public String imprimir(){
        if (this.vetor.length == 0){
            return "[]";
        }

        StringBuilder builder = new StringBuilder();
        builder.append("[");

        Iterador it = new Iterador(this.vetor);

        int i=0;
        while (it.hasNext()){
            if(this.vetor[i] == null) builder.append("-");
            else builder.append(this.vetor[i]);
            if(i < vetor.length - 1) builder.append(", ");
            it.next();
            i++;
        }

        builder.append("]");

        return builder.toString();
    }

}
