package it.unibo.playbasket.db.features;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.Collection;

public class FeaturesTesserato{

    private Connection connection;

    public FeaturesTesserato(Connection connection){
        this.connection = connection;
    }
}
