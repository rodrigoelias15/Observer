import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {

    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void instalarAtualizacao(RepoSO repositorio) {
        repositorio.addObserver(this);
    }

    public void update(Observable repositorio, Object arg1) {
        this.ultimaNotificacao = this.nome + ", atualização lançada do " + repositorio.toString();
    }
}