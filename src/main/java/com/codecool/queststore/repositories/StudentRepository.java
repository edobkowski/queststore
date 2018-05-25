package com.codecool.queststore.repositories;

import com.codecool.queststore.model.entities.CodecoolClass;
import com.codecool.queststore.model.entities.Student;
import com.codecool.queststore.model.entities.Wallet;
import com.codecool.queststore.specifications.CodecoolClassById;
import com.codecool.queststore.specifications.SqlSpecification;
import com.codecool.queststore.specifications.WalletById;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends AbstractRepository<Student> {
    public StudentRepository() throws PersistenceLayerException {}

    private static final String ADD_QUERY = "INSERT INTO students(login, exp, wallet_id, class_id) VALUES(?,?,?,?)";
    private static final String EDIT_QUERY = ADD_QUERY + " WHERE login=?";
    private static final String DELETE_QUERY = "DELETE * FROM students WHERE login=?";

    @Override
    void addEntity(Student entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(ADD_QUERY);
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.setInt(2, entity.getExperience());
        super.preparedStatement.setInt(3, entity.getWallet().getId());
        super.preparedStatement.setInt(4, entity.getCodecoolClass().getId());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void updateEntity(Student entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(EDIT_QUERY);
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.setInt(2, entity.getExperience());
        super.preparedStatement.setInt(3, entity.getWallet().getId());
        super.preparedStatement.setInt(4, entity.getCodecoolClass().getId());
        super.preparedStatement.setString(5, entity.getLogin());
        super.preparedStatement.executeUpdate();
    }

    @Override
    void deleteEntity(Student entity) throws SQLException {
        super.preparedStatement = super.dbConnection.prepareStatement(DELETE_QUERY);
        super.preparedStatement.setString(1, entity.getLogin());
        super.preparedStatement.executeUpdate();
    }

    @Override
    List<Student> deserializeEntities() throws PersistenceLayerException {
        List<Student> students = new ArrayList<>();

        try {
            while (super.resultSet.next()) {
                String login = super.resultSet.getString("login");
                int experience = super.resultSet.getInt("exp");

                Repository<Wallet> walletRepository = this.REPOSITORY_POOL.getRepository(Repositories.WALLET);
                SqlSpecification getWalletById = new WalletById(super.resultSet.getInt("wallet_id"));
                Wallet wallet = walletRepository.query(getWalletById).get(0);

                Repository<CodecoolClass> codecoolClassRepository;
                codecoolClassRepository = this.REPOSITORY_POOL.getRepository(Repositories.CODECOOL_CLASS);
                SqlSpecification getCodecoolClassById = new CodecoolClassById(super.resultSet.getInt("class_id"));
                CodecoolClass codecoolClass = codecoolClassRepository.query(getCodecoolClassById).get(0);

                students.add(new Student(login, experience, wallet, codecoolClass));
            }
            return students;
        } catch (SQLException e) {
            throw new PersistenceLayerException("Can't get Student from the database");
        }
    }
}
