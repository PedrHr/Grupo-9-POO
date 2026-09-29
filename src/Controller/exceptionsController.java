package Controller;

public abstract class exceptionsController {

    public static String camposVazios (){
        return "Preencha todos os devidos campos para prosseguir a operação!";
    }
    public static String exceptionsDAO(String inserir){
        if (inserir.equals("inserir")){
            return "Ouve um problema na conexão do sistema. Não foi possivel criar ";
        }

    }
}

