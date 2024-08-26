package br.edu.fateczl.thiago.mergesort;

public class MergeSort {
    public int[] sort(int[] vet, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            sort(vet, inicio, meio);
            sort(vet, meio + 1, fim);
            merge(vet, inicio, meio, fim);
        }
        return vet;
    }

    private void merge(int[] vet, int inicio, int meio, int fim) {
        int[] aux = new int[vet.length];
        int pe = inicio;
        int pd = meio + 1;

        for (int i = inicio; i <= fim; i++) {
            aux[i] = vet[i];
        }

        for (int i = inicio; i <= fim; i++) {
            if (pe > meio) {
                vet[i] = aux[pd];
                pd++;
            } else if (pd > fim) {
                vet[i] = aux[pe];
                pe++;
            } else if (aux[pe] < aux[pd]) {
                vet[i] = aux[pe];
                pe++;
            } else {
                vet[i] = aux[pd];
                pd++;
            }
        }
    }
}
