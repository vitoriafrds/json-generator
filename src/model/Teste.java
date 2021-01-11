package model;

public class Teste {
    private String teste;
    private int id;

    public Teste(String teste, int id) {
        this.teste = teste;
        this.id = id;
    }

    public Teste() {

    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
