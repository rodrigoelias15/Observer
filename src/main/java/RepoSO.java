import java.util.Observable;

public class RepoSO extends Observable {

    private float tamanhoPacote;
    private String recursoAtualizacao;
    private String data;

    public RepoSO(float tamanhoPacote, String recursoAtualizacao, String data) {
        this.tamanhoPacote = tamanhoPacote;
        this.recursoAtualizacao = recursoAtualizacao;
        this.data = data;
    }

    public void instalarPacotes() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Repositório {" +
                "Tamanho: " + tamanhoPacote +
                ", tipo de atualização:'" + recursoAtualizacao + '\'' +
                ", data de modificação: " + data +
                "}";
    }
}





