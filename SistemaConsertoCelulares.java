package sistemaconsertocelulares; 
import java.util.*; 
import java.awt.Desktop; 
import java.net.URI; 
// Cidade 
class Cidade { 
String nomeCid; 
public Cidade(String nomeCid) { 
this.nomeCid = nomeCid; 
} 
public void addCidade(String nomeCid) { 
this.nomeCid = nomeCid; 
} 
} 
// Estado 
class Estado { 
String nomeUF; 
public Estado(String nomeUF) { 
this.nomeUF = nomeUF; 
} 
public void addUF(String nomeUF) { 
this.nomeUF = nomeUF; 
} 
} 
// Endereco 
class Endereco { 
String logradouro, cep, numero, bairro, cidade, estado; 
public Endereco(String cep, String numero, String bairro, String 
logradouro, String cidade, String estado) { 
this.cep = cep; 
this.numero = numero; 
this.bairro = bairro; 
this.logradouro = logradouro; 
this.cidade = cidade; 
this.estado = estado; 
} 
public String toString() { 
return logradouro + ", " + numero + " - " + bairro + ", " + 
cidade + "/" + estado + " - CEP: " + cep; 
} 
} 
// Cliente 
class Cliente { 
int id; 
String nome, telefone, email; 
Endereco endereco; 
public Cliente(int id, String nome, String telefone, String email, 
Endereco endereco) { 
this.id = id; 
this.nome = nome; 
this.telefone = telefone; 
this.email = email; 
this.endereco = endereco; 
} 
public void alterarCliente(String nome, String telefone, String 
email, Endereco endereco) { 
this.nome = nome; 
this.telefone = telefone; 
this.email = email; 
this.endereco = endereco; 
} 
public String toString() { 
return "Cliente: " + nome + ", Tel: " + telefone + ", Email: " 
+ email + ", Endereco: " + endereco; 
} 
} 
// Mensagem 
class Mensagem { 
public static boolean validarTelefone(String numero) { 
return numero != null && numero.matches("^[0-9]{10,11}$"); 
} 
} 
// Marca 
class Marca { 
String nomeMarca; 
public Marca(String nomeMarca) { 
this.nomeMarca = nomeMarca; 
} 
public void adicionarMarca(String nome) { this.nomeMarca = nome; } 
public void alterarMarca(String novoNome) { this.nomeMarca = 
novoNome; } 
public void removerMarca() { this.nomeMarca = ""; } 
} 
// TipoModelo 
class TipoModelo { 
String nomeTipo; 
public TipoModelo(String nomeTipo) { 
this.nomeTipo = nomeTipo; 
} 
public void adicionarTipo(String tipo) { this.nomeTipo = tipo; } 
public void alterarTipo(String novoTipo) { this.nomeTipo = novoTipo; 
} 
public void removerTipo() { this.nomeTipo = ""; } 
} 
// ModeloAparelho 
class ModeloAparelho { 
int id; 
Marca marca; 
String nome; 
TipoModelo tipo; 
public ModeloAparelho(int id, Marca marca, String nome, TipoModelo 
tipo) { 
} 
this.id = id; 
this.marca = marca; 
this.nome = nome; 
this.tipo = tipo; 
} 
public String toString() { 
return tipo.nomeTipo + " " + marca.nomeMarca + " " + nome; 
} 
// StatusAparelho 
class StatusAparelho { 
public static final String EM_MANUTENCAO = "Em manutencao"; 
public static final String PRONTO = "Pronto"; 
public static final String ENTREGUE = "Entregue"; 
String statusAparelho; 
public StatusAparelho() { this.statusAparelho = EM_MANUTENCAO; } 
public void setStatusAparelho(String status) { this.statusAparelho 
= status; } 
public String getStatusAparelho() { return statusAparelho; } 
} 
// Aparelho 
class Aparelho { 
int id; 
ModeloAparelho modelo; 
String cor, defeitoDesc; 
Cliente cliente; 
StatusAparelho statusAparelho; 
public Aparelho(int id, ModeloAparelho modelo, String cor, String 
defeitoDesc, Cliente cliente) { 
        this.id = id; 
        this.modelo = modelo; 
        this.cor = cor; 
        this.defeitoDesc = defeitoDesc; 
        this.cliente = cliente; 
        this.statusAparelho = new StatusAparelho(); 
    } 
    public String toString() { 
        return modelo + " | Cor: " + cor + " | Defeito: " + defeitoDesc 
+ " | Cliente: " + cliente.nome 
            + " | Status Aparelho: " + 
statusAparelho.getStatusAparelho(); 
    } 
} 
 
// Peca 
class Peca { 
    String nome; 
    int id, quantidade; 
    double valorUnitario; 
    public Peca(int id, String nome, double valorUnitario, int 
quantidade) { 
        this.id = id; 
        this.nome = nome; 
        this.valorUnitario = valorUnitario; 
        this.quantidade = quantidade; 
    } 
    public void darBaixa(int qtd) { 
        if (qtd <= quantidade) quantidade -= qtd; 
    } 
    public String toString() { 
        return nome + " (R$" + valorUnitario + ") Estoque: " + 
quantidade; 
    } 
} 
 
// Estoque 
class Estoque { 
    List<Peca> pecas; 
    public Estoque() { this.pecas = new ArrayList<>(); } 
public void visualizarEstoque() { 
for (Peca p : pecas) System.out.println(p.toString()); 
} 
} 
// StatusOS 
class StatusOS { 
public static final String EM_ANDAMENTO = "Em andamento"; 
public static final String CONCLUIDA = "Concluída"; 
public static final String CANCELADA = "Cancelada"; 
public static final String ENTREGUE = "Entregue"; 
String status; 
public StatusOS() { this.status = EM_ANDAMENTO; } 
public void setStatus(String status) { this.status = status; } 
public String getStatus() { return status; } 
} 
// OrdemServico 
class OrdemServico { 
int id; 
String descricao; 
Aparelho aparelho; 
List<Peca> pecasUsadas; 
double valorMaoDeObra; 
StatusOS statusOS; 
public OrdemServico(int id, String descricao, Aparelho aparelho, 
double valorMaoDeObra) { 
this.id = id; 
this.descricao = descricao; 
this.aparelho = aparelho; 
this.valorMaoDeObra = valorMaoDeObra; 
this.pecasUsadas = new ArrayList<>(); 
this.statusOS = new StatusOS(); 
} 
public void adicionarPeca(Peca peca, int qtd) { 
if (peca.quantidade >= qtd) { 
peca.darBaixa(qtd); 
for (int i = 0; i < qtd; i++) pecasUsadas.add(peca); 
} 
} 
    public double valorTotal() { 
        double total = valorMaoDeObra; 
        for (Peca p : pecasUsadas) total += p.valorUnitario; 
        return total; 
    } 
    public void marcarConcluida() { 
statusOS.setStatus(StatusOS.CONCLUIDA); } 
    public void marcarEntregue() { 
statusOS.setStatus(StatusOS.ENTREGUE); } 
    public void marcarCancelada() { 
statusOS.setStatus(StatusOS.CANCELADA); } 
    public String toString() { 
        return "\nOS " + id + " | " + aparelho + " | Status: " + 
statusOS.getStatus() + " | Valor Total: R$" + valorTotal(); 
    } 
    public boolean podeEnviarWhatsapp() { 
        return statusOS.getStatus().equals(StatusOS.CONCLUIDA); 
    } 
} 
 
// UtilWhatsApp 
class UtilWhatsApp { 
    public static void enviarMensagem(String numero, String mensagem) { 
        try { 
            String url = "https://wa.me/55" + numero.replaceAll("[^0
9]", "") + "?text=" + URIEncoder.encode(mensagem); 
            if (Desktop.isDesktopSupported()) { 
                Desktop.getDesktop().browse(new URI(url)); 
                System.out.println("\n\nAbra o WhatsApp Web para enviar: 
" + url); 
            } else { 
                System.out.println("Whatsapp URL: " + url); 
            } 
        } catch (Exception e) { 
            System.out.println("Erro ao tentar abrir WhatsApp: " + 
e.getMessage()); 
        } 
    } 
} 
 
// URIEncoder 
class URIEncoder { 
public static String encode(String s) { 
return s.replace(" ", "%20").replace("\n", "%0A"); 
} 
} 
// Programa principal de exemplo 
public class SistemaConsertoCelulares { 
public static void main(String[] args) { 
Scanner sc = new Scanner(System.in); 
// Cadastro de Cidade e Estado 
System.out.print("-------- SISTEMA DE GERENCIAMENTO DE CELULARES -------\n\n"); 
System.out.print("---- Dados de Endereço do cliente ------\n"); 
System.out.print("Cidade: "); 
String nomeCidade = sc.nextLine(); 
Cidade cidade = new Cidade(nomeCidade); 
System.out.print("Estado: "); 
String nomeEstado = sc.nextLine(); 
Estado estado = new Estado(nomeEstado); 
// Cadastro do endereço 
System.out.print("CEP: "); 
String cep = sc.nextLine(); 
System.out.print("Numero: "); 
String num = sc.nextLine(); 
System.out.print("Bairro: "); 
String bairro = sc.nextLine(); 
System.out.print("Logradouro: "); 
String logradouro = sc.nextLine(); 
Endereco endereco = new Endereco(cep, num, bairro, logradouro, 
cidade.nomeCid, estado.nomeUF); 
System.out.print("\n----- Dados do Cliente ----- \n"); 
// Cadastro do cliente 
System.out.print("Nome do cliente: "); 
String nomeCliente = sc.nextLine(); 
System.out.print("Telefone do cliente: "); 
String telCliente = sc.nextLine(); 
System.out.print("E-mail do cliente (opcional): "); 
String emailCliente = sc.nextLine(); 
Cliente cliente = new Cliente(1, nomeCliente, telCliente, 
emailCliente, endereco); 
System.out.print("\n----- Dados do Aparelho do Cliente -----
\n"); 
// Cadastro de Marca e TipoModelo 
System.out.print("Marca do aparelho: "); 
String nomeMarca = sc.nextLine(); 
Marca marca = new Marca(nomeMarca); 
System.out.print("Tipo do aparelho (Celular, Tablet...): "); 
String nomeTipoModelo = sc.nextLine(); 
TipoModelo tipoModelo = new TipoModelo(nomeTipoModelo); 
// Cadastro do modelo do aparelho 
System.out.print("Nome do modelo: "); 
String nomeModelo = sc.nextLine(); 
ModeloAparelho modeloAparelho = new ModeloAparelho(1, marca, 
nomeModelo, tipoModelo); 
// Cadastro de Aparelho 
System.out.print("Cor do aparelho: "); 
String cor = sc.nextLine(); 
System.out.print("Defeito relatado: "); 
String defeitoDesc = sc.nextLine(); 
Aparelho aparelho = new Aparelho(1, modeloAparelho, cor, 
defeitoDesc, cliente); 
System.out.print("\n------ Dados de peças e estoque -------\n"); 
// Cadastro das peças e Estoque 
Estoque estoque = new Estoque(); 
System.out.print("Quantas peças diferentes serão cadastradas 
neste OS? "); 
int qtdPecas = Integer.parseInt(sc.nextLine()); 
for (int i = 1; i <= qtdPecas; i++) { 
            System.out.print("Nome da peça " + i + ": "); 
            String nomePeca = sc.nextLine(); 
            System.out.print("Valor unitário da peça: "); 
            double valorPeca = Double.parseDouble(sc.nextLine()); 
            System.out.print("Estoque inicial da peça: "); 
            int estoquePeca = Integer.parseInt(sc.nextLine()); 
            estoque.pecas.add(new Peca(i, nomePeca, valorPeca, 
estoquePeca)); 
        } 
 
        System.out.print("\n------- Dados da Ordem de Serviço -----
\n"); 
        // Cadastro da Ordem de Serviço 
        System.out.print("Descrição para a Ordem de Serviço: "); 
        String descricaoOS = sc.nextLine(); 
 
        System.out.print("Valor da mão de obra: "); 
        double maoObra = Double.parseDouble(sc.nextLine()); 
 
        OrdemServico os = new OrdemServico(1, descricaoOS, aparelho, 
maoObra); 
 
        // Adicionando peças utilizadas na OS 
        for (Peca p : estoque.pecas) { 
            System.out.print("Quantidade da peça usada na OS (" + p.nome 
+ "): "); 
            int qtdUso = Integer.parseInt(sc.nextLine()); 
            os.adicionarPeca(p, qtdUso); 
        } 
 
        // Mudar status 
        System.out.print("Finalizar ordem de serviço como 'Concluída'? 
(s/n): "); 
        String status = sc.nextLine(); 
        if (status.equalsIgnoreCase("s")) { 
            os.marcarConcluida(); 
        } 
 
        System.out.println(os); 
 
// Envio WhatsApp 
if (os.podeEnviarWhatsapp()) { 
String msg = "Olá " + cliente.nome + ", seu conserto (" + 
modeloAparelho.nome + ") está pronto. Valor: R$" + os.valorTotal(); 
UtilWhatsApp.enviarMensagem(cliente.telefone, msg); 
} else { 
System.out.println("Só é possível enviar WhatsApp quando a 
OS estiver 'Concluída'."); 
} 
// Visualizando Estoque 
System.out.println("\n ------- ESTOQUE ATUAL -----\n"); 
estoque.visualizarEstoque(); 
sc.close(); 
} 
}