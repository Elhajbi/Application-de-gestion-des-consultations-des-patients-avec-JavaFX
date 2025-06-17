package ma.enset.gestionconsultation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.gestionconsultation.dao.ConsultationDao;
import ma.enset.gestionconsultation.dao.PatientDao;
import ma.enset.gestionconsultation.entities.Patient;
import ma.enset.gestionconsultation.service.CabinetService;
import ma.enset.gestionconsultation.service.ICabinetService;

import java.net.URL;
import java.util.ResourceBundle;

public class PatientController implements Initializable {
    @FXML private TextField textFieldNom;
    @FXML private TextField textFieldPrenom;
    @FXML private TextField textFieldTel;
    @FXML private TextField textFieldSearch;
    @FXML private TableView<Patient> tablePatients;
    @FXML private TableColumn<Patient,Long> columnId;
    @FXML private TableColumn<Patient,String> columnNom;
    @FXML private TableColumn<Patient,String> columnPrenom;
    @FXML private TableColumn<Patient,String> columnTel;
    @FXML private Label labelSucces;
    private ICabinetService cabinetService ;
    private ObservableList<Patient> patients = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService = new CabinetService(new PatientDao(),new ConsultationDao());
        columnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        patients.setAll(cabinetService.getAllPatients());
        tablePatients.setItems(patients);
    }
    public void addPatient() {
         Patient patient = new Patient();
         patient.setNom(textFieldNom.getText());
         patient.setPrenom(textFieldPrenom.getText());
         patient.setTel(textFieldTel.getText());
         cabinetService.addPatient(patient);
         patients.setAll(cabinetService.getAllPatients());
    }
    public void delPatient() {
      Patient patient = tablePatients.getSelectionModel().getSelectedItem();
      cabinetService.deletePatient(patient);
      patients.setAll(cabinetService.getAllPatients());
      labelSucces.setText("Le patient a été bien suprimé");
    }
}
