package br.marcio.javafx.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.marcio.javafx.model.Cliente;
import br.marcio.javafx.model.repository.ClienteRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ClienteController implements Initializable {

    @FXML private TextField txtNome;
    @FXML private TextField txtTelefone;
    @FXML private TextField txtEndereco;
    @FXML private TextField txtEmail;
    @FXML private Button btnCadastrarCliente;
    @FXML private TextField txtId;
    @FXML private Label lblResultado;
    @FXML private TextField txtIdCliente;
    @FXML private Button btnBuscarId;
    @FXML private TextField txtNomeCliente;
    @FXML private Button btnBuscarNome;
    @FXML private Label lblResultadoBusca;
    @FXML private TableView<Cliente> tbClientes;
    @FXML private TableColumn<Cliente, Long> colId;
    @FXML private TableColumn<Cliente, String> colNome;
    @FXML private TableColumn<Cliente, String> colTelefone;
    @FXML private Button btnCarregarClientes;

    //qual entidade de dominio que o controller trabalha?
    private Cliente cliente;
    //qual o repository da entidade de dominio?
    private ClienteRepository clienteRepository;
    
    @FXML
    void cadastrarCliente(ActionEvent event) {
    	cliente = new Cliente();
    	cliente.setId(Long.parseLong(txtId.getText()));
    	cliente.setNome(txtNome.getText());
    	cliente.setEndereco(txtEndereco.getText());
    	cliente.setTelefone(txtTelefone.getText());
    	cliente.setEmail(txtEmail.getText());
    	
    	System.out.println(cliente.toString());
    	
    	clienteRepository = new ClienteRepository(cliente);
    	
    	if (clienteRepository.cadastrarCliente()) {
    		lblResultado.setText("Usuário cadastrado com sucesso");
    	}else {
    		lblResultado.setText("Erro! Não cadastrou.");
    	}    	
    }    
    
    @FXML
    void buscarClientePeloId(ActionEvent event) {
    	try {
    		
    		clienteRepository = new ClienteRepository();
    		cliente = new Cliente();
    		long id = Long.parseLong(txtIdCliente.getText());
    		cliente = clienteRepository.buscarClientePeloId(id);
    		
    		if (cliente != null) {
    			lblResultadoBusca.setText(cliente.toString());
    		}else {
    			lblResultadoBusca.setText("Cliente não encontrado!");
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			lblResultadoBusca.setText("Houve um erro na busca do cliente no banco de dados");
		}
    }

    @FXML
    void buscarClientePeloNome(ActionEvent event) {
    	try {
    		
    		clienteRepository = new ClienteRepository();
    		cliente = new Cliente();
    		String nome = txtNomeCliente.getText();
    		cliente = clienteRepository.buscarClientePeloNome(nome);
    		
    		if (cliente != null) {
    			lblResultadoBusca.setText(cliente.toString());
    		}else {
    			lblResultadoBusca.setText("Cliente não encontrado!");
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			lblResultadoBusca.setText("Houve um erro na busca do cliente no banco de dados");
		}
    }

    //@FXML
    public void carregarClientes() {
    	clienteRepository = new ClienteRepository();
    	List<Cliente> clientes = clienteRepository.buscarClientes();
    	
    	ObservableList<Cliente> observableClientes = FXCollections.observableArrayList();
    	
    	clientes.forEach(cliente -> {
    		observableClientes.add(cliente);
    	});
    	
    	colId.setCellValueFactory(new PropertyValueFactory("id"));
    	colNome.setCellValueFactory(new PropertyValueFactory("nome"));
    	colTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
    	
    	tbClientes.setItems(observableClientes);
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.carregarClientes();
	}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}