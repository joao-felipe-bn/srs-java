package enums;

public enum ERROS {

    ERRO_INSERIR_USUARIO("ERRO AO INSERIR USUARIO "),
    ERRO_ATUALIZAR_USUARIO("ERRO AO ATUALIZAR USUARIO "),
    ERRO_AO_BUSCAR_USUARIO("ERRO AO BUSCAR USUARIO");

    private String error;

    ERROS(String error) {
        this.error = error;
    }

    public String getErro() {
        return error;
    }
}
