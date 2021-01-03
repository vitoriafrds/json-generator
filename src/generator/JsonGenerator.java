package generator;

import model.Pessoa;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class JsonGenerator {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Raquel Soares");
        pessoa.setIdade(21);
        pessoa.setRg("502864576");

        char chaveAberta = '{';
        char chaveFechada = '}';
        char aspas = '"';
        char doisPontos = ':';
        char virgula = ',';

        Field[] atributos = Pessoa.class.getDeclaredFields();
        StringBuilder json = new StringBuilder();

        json.append(chaveAberta);
        json.append("\n");
        for (int index = 0; index < atributos.length; index++) {

            if (atributos[index].getName().equals("nome")) {
                json.append(aspas).append(atributos[index].getName())
                        .append(aspas)
                        .append(doisPontos).append(aspas).
                        append(Pessoa.class.getDeclaredMethod("getNome").invoke(pessoa)).append(aspas).append(virgula);
            }

            if (atributos[index].getName().equals("idade")) {
                json.append(aspas).append(atributos[index].getName())
                        .append(aspas)
                        .append(doisPontos).append(Pessoa.class.getDeclaredMethod("getIdade").invoke(pessoa)).append(virgula);
            }

            if (atributos[index].getName().equals("rg")) {
                json.append(aspas).append(atributos[index].getName())
                        .append(aspas)
                        .append(doisPontos).append(aspas).
                        append(Pessoa.class.getDeclaredMethod("getRg").invoke(pessoa)).append(virgula);
            }


            json.append("\n");
        }
        json.append(chaveFechada);
        System.out.println(json.toString());
    }

    //pontos a melhorar: verificar o tipo do atributo no json (se e valor numerico ou texto)
    //para saber quando abrir aspas ou nao
}






