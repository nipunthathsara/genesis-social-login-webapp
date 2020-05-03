/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.genesis.dao;

import org.apache.log4j.Logger;
import org.genesis.Utils;
import org.genesis.dto.UserDTO;

import java.sql.*;

import static org.genesis.Constants.AUTHENTICATE_SQL;
import static org.genesis.Constants.CREATE_USER_SQL;

public class UserDAO {

    private final static Logger log = Logger.getLogger(UserDAO.class);

    public void createUser(UserDTO userDTO) throws SQLException {

        Connection connection = null;
        try {
            connection = Utils.getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(CREATE_USER_SQL);
            prepStatement.setString(1, userDTO.getUsername());
            prepStatement.setString(2, userDTO.getPassword());
            prepStatement.setString(3, userDTO.getGender());
            prepStatement.setString(4, userDTO.getEmail());
            prepStatement.executeUpdate();
            log.info("User created successfully.");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    public boolean authenticateUser(String username, String password) throws SQLException {
        Connection connection = null;
        boolean isAuthenticated = false;
        try {
            connection = Utils.getConnection();
            PreparedStatement prepStatement = connection.prepareStatement(AUTHENTICATE_SQL);
            prepStatement.setString(1, username);
            prepStatement.setString(2, password);
            ResultSet rs = prepStatement.executeQuery();
            while (rs.next()) {
                isAuthenticated = true;
            }
            log.info("User authenticated successfully.");
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return isAuthenticated;
    }
}
