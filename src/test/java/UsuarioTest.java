import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    void deveNotificarUmAluno() {
        RepoSO repositorio = new RepoSO(150.2f, "Patch", "01/05/2021");
        Usuario usuario = new Usuario("Usuario 1");
        usuario.instalarAtualizacao(repositorio);
        repositorio.instalarPacotes();
        assertEquals("Usuario 1, atualização lançada do Repositório " +
                        "{Tamanho: 150.2, tipo de atualização:'Patch', data de modificação: 01/05/2021}",
                         usuario.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlunos() {
        RepoSO repositorio = new RepoSO(45f, "driver rtl8812au v4.22", "15/01/2022");
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");
        usuario1.instalarAtualizacao(repositorio);
        usuario2.instalarAtualizacao(repositorio);
        repositorio.instalarPacotes();
        assertEquals("Usuario 1, atualização lançada do Repositório " +
                "{Tamanho: 45.0, tipo de atualização:'driver rtl8812au v4.22', data de modificação: 15/01/2022}",
                usuario1.getUltimaNotificacao());
        assertEquals("Usuario 2, atualização lançada do Repositório " +
                "{Tamanho: 45.0, tipo de atualização:'driver rtl8812au v4.22', data de modificação: 15/01/2022}",
                usuario2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarAluno() {
        RepoSO repositorio = new RepoSO(1022, "Android Studio", "21/12/2020");
        Usuario usuario = new Usuario("Usuario 1");
        repositorio.instalarPacotes();
        assertEquals(null, usuario.getUltimaNotificacao());
    }


    @Test
    void deveNotificarAlunoTurmaA() {
        RepoSO repositorioA = new RepoSO(60f, "VLC", "21/11/2021");
        RepoSO repositorioB = new RepoSO(20f, "smplayer v2.1", "04/05/2019");
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 2");
        usuario1.instalarAtualizacao(repositorioA);
        usuario2.instalarAtualizacao(repositorioB);
        repositorioA.instalarPacotes();
        assertEquals("Usuario 1, atualização lançada do Repositório " +
                "{Tamanho: 60.0, tipo de atualização:'VLC', data de modificação: 21/11/2021}",
                usuario1.getUltimaNotificacao());
        assertEquals(null, usuario2.getUltimaNotificacao());
    }

}