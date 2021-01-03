package generator;

import model.Pessoa;

import java.lang.reflect.InvocationTargetException;

public class Teste {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Pessoa> pessoa = Pessoa.class;

        Pessoa pessoa2 = pessoa.getDeclaredConstructor().newInstance();

    }
}
