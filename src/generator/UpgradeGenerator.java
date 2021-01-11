package generator;

import model.Teste;
import utils.CharUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UpgradeGenerator {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Teste teste = new Teste();
        teste.setId(1);
        teste.setTeste("TESTE");


        Class<Teste> testeClass = Teste.class;
        Field[] atributos = testeClass.getDeclaredFields();
        Method[] methods = testeClass.getDeclaredMethods();
        StringBuilder json = new StringBuilder();

        json.append(CharUtils.chaveAberta());
        json.append("\n");
        for (int i = 0; i < atributos.length; i++) {
            for (int x = 0; x < methods.length; x++) {
                if (formatarNomeMetodoAcessor(atributos[i].getName(), methods[x].getName())) {
                    json.append(CharUtils.aspas()).append(atributos[i].getName())
                            .append(CharUtils.aspas())
                            .append(CharUtils.doisPontos()).append(CharUtils.aspas()).
                            append(testeClass.getDeclaredMethod(methods[x].getName()).invoke(teste)).append(CharUtils.aspas()).append(CharUtils.virgula());
                    json.append("\n");
                }


            }
        }

        json.append(CharUtils.chaveFechada());
        System.out.println(json.toString());
    }

    public static boolean formatarNomeMetodoAcessor(String atributo, String metodo) {
        String tipoMetodo = "get";
        String primeiraLetra = atributo.substring(0, 1).toUpperCase();
        String metodoFormatado = tipoMetodo.concat(primeiraLetra).concat(atributo.substring(1));

        return metodoFormatado.equals(metodo);

    }
}
