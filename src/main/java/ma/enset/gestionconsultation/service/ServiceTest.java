package ma.enset.gestionconsultation.service;

import ma.enset.gestionconsultation.dao.ConsultationDao;
import ma.enset.gestionconsultation.dao.PatientDao;
import ma.enset.gestionconsultation.entities.Patient;

import java.util.List;

public class ServiceTest {
    public static void main(String[] args) {
        ICabinetService service = new CabinetService(new PatientDao(),new ConsultationDao());
        /*Patient patient = new Patient();
        patient.setNom("TAZI");
        patient.setPrenom("AHMED");
        patient.setTel("0678451963");
        service.addPatient(patient);*/
      /* List <Patient> patients = service.getAllPatients();
       patients.forEach(patient -> System.out.println(patient));*/
        Patient patient = service.getPatientById(6L);
        patient.setTel("123456789");
        service.updatePatient(patient);





    }
}
