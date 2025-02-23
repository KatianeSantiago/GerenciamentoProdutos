package src.service;

import java.util.ArrayList;
import java.util.List;

import src.model.Produto;

public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public Produto buscarProduto(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public boolean removerProduto(int id) {
        return produtos.removeIf(p -> p.getId() == id);
    }
}
