import spock.lang.Specification

class BoletimSpec extends Specification {

    def "deve calcular a media corretamente incluindo todas as notas (Bug 1)"() {
        given:
        Boletim boletim = new Boletim()
        List<Double> notas = [8.0, 7.5, 9.0]

        when:
        double media = boletim.calcularMedia(notas)

        then:
        Math.abs(media - 8.1666) < 0.001
    }

    def "deve retornar Recuperacao para media 6.0 respeitando a constante correta (Bug 2)"() {
        given:
        Boletim boletim = new Boletim()
        final double MEDIA_APROVACAO = 7.0
        final double MEDIA_RECUPERACAO = 5.0

        when:
        String situacao = boletim.situacao(6.0, MEDIA_APROVACAO, MEDIA_RECUPERACAO)

        then:
        situacao == "Recuperação"
    }

    def "deve retornar Aprovado para media exatamente 7.0 (Bug 3)"() {
        given:
        Boletim boletim = new Boletim()
        final double MEDIA_APROVACAO = 7.0
        final double MEDIA_RECUPERACAO = 5.0

        when:
        String situacao = boletim.situacao(7.0, MEDIA_APROVACAO, MEDIA_RECUPERACAO)

        then:
        situacao == "Aprovado"
    }

}
