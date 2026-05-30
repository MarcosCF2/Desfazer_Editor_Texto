import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Acao {
    String descricao;
    LocalDateTime horario;
    TipoAcao tipo;
    String textoAnterior;
    Acao proximo;

    public Acao(String descricao, TipoAcao tipo) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.horario = LocalDateTime.now();
        this.proximo = null;
    }
}