package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import entites.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Case2Controller implements Initializable{
	
	@FXML private TableView<Person> tablePersons;
	@FXML private TableColumn<Person, String> columnName;
	@FXML private TableColumn<Person, String> columnEmail;
	@FXML private TableColumn<Person, Person> columnEdit;
	@FXML private TableColumn<Person, Person> columnDelete;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	
	
	@Override
	public void initialize(URL url, ResourceBundle resources) {
		// Criação de algumas entidades para popular a TableView
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Carlos Antonio", "carlinhos@gmail.com"));
		persons.add(new Person("Maria Joaquiana", "maria@outlook.com"));
		persons.add(new Person("João Cardoso", "cardoso.joao@email.com"));
		persons.add(new Person("Pedro da Silva", "pedro@gmail.com"));
		persons.add(new Person("Mario", "mario@gmail.com"));
		// Observable List para popular a tabela
		ObservableList<Person> personsObservableList = FXCollections.observableArrayList(persons);
		// Define o que terá em cada coluna da tabela
		columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		// insere as pessoas na tabela
		tablePersons.setItems(personsObservableList);
		
		// BOTÕES COM ÍCONES EM SVG
		// configura a coluna para editar e deleter uma pessoa
		Utils.initButtons(columnEdit, 15, PEN_SOLID, "svg-gray", (Person person, ActionEvent event) -> {
			System.out.println("Você clicou para editar as informações de: " + person.getName());
			// Aqui vai toda a lógica para editar a pessoa
		});
		Utils.initButtons(columnDelete, 15, TRASH_SOLID, "svg-red", (Person person, ActionEvent event) -> {
			System.out.println("Você clicou para deletar as informações de: " + person.getName());
			// Aqui vai toda a lógica para deletar a pessoa
		});
	}

}