package com.example.demo.db;


import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

public class DBProcess {

    private static final String SAVE_DATA = "INSERT INTO CustomerNew (NAME,CITY,EMAIL) VALUES (?,?,?)";
    private static final String GET_DATA = "SELECT * FROM CustomerNew WHERE id = ?";
    private static final String SAVE_ITEM_DATA ="INSERT INTO item (code,description,qty,unitPrice) VALUES(?,?,?,?)" ;

    Logger logger = (Logger) LoggerFactory.getLogger(DBProcess.class);

}

