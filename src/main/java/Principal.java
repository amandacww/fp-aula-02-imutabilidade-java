import exercicios.*;

/**
 * Classe para você testar suas implementações.
 * Veja o README para mais detalhes.
 */
public class Principal {
    public static void main(final String[] args) {
        // 1. CidadeRecord - Imutável
        var recife = new CidadeRecord("Recife");
        System.out.println("CidadeRecord: " + recife.nome());
        // recife.nome() = "São Paulo"; // ERRO: não pode reatribuir

        // 2. Cidade - Mutável
        var saopaulo = new Cidade("São Paulo");
        System.out.println("Cidade antes: " + saopaulo.getNome());
        saopaulo.setNome("Brasília"); // OK: pode reatribuir
        System.out.println("Cidade depois: " + saopaulo.getNome());

        // 3. PessoaRecordShallow - Shallow Immutability
        var cidade = new Cidade("Rio de Janeiro");
        var pessoaShallow = new PessoaRecordShallow("Ana", cidade);
        System.out.println("\nPessoaRecordShallow (shallow imutability):");
        System.out.println("  Nome: " + pessoaShallow.nome() + ", Cidade: " + pessoaShallow.cidade().getNome());
        // pessoaShallow.cidade = new Cidade("..."); // ERRO: não pode reatribuir o campo
        pessoaShallow.cidade().setNome("Salvador"); // OK: Cidade é mutável
        System.out.println("  Após modificar Cidade: " + pessoaShallow.cidade().getNome());

        // 4. PessoaRecord - Deep Immutability
        var pessoaDeep = new PessoaRecord("Bruno", new CidadeRecord("Manaus"));
        System.out.println("\nPessoaRecord (deep immutability):");
        System.out.println("  Nome: " + pessoaDeep.nome() + ", Cidade: " + pessoaDeep.cidade().nome());
        // pessoaDeep.cidade().nome() = "..."; // ERRO: CidadeRecord é imutável
        // pessoaDeep.cidade = new CidadeRecord("..."); // ERRO: não pode reatribuir
    }
}
