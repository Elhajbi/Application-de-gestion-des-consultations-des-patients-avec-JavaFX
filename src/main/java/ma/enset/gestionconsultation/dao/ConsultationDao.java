package ma.enset.gestionconsultation.dao;

import ma.enset.gestionconsultation.entities.Consultation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ConsultationDao implements IConsultationDao {

    @Override
    public void create(Consultation consultation) throws SQLException {
        Connection connection =DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO CONSULTATIONS(DATE_CONSULTATION,DESCRIPTION,ID_PATIENT)" +
                "VALUES(?,?,?)");
        pstm.setDate(1,consultation.getDateConsultation());
        pstm.setString(2,consultation.getDescription());
        pstm.setLong(3,consultation.getPatient().getId());
        pstm.executeUpdate();

    }

    @Override
    public void update(Consultation consultation) throws SQLException {

    }

    @Override
    public void delete(Consultation consultation) throws SQLException {

    }

    @Override
    public List<Consultation> findAll() throws SQLException {
        return List.of();
    }

    @Override
    public Consultation findById(Long id) throws SQLException {
        return null;
    }
}
