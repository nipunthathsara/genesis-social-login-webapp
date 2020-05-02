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

public class UserDAO {

    private final static Logger log = Logger.getLogger(UserDAO.class);

    public void createUser(UserDTO userDTO) throws SQLException {

        Connection connection = null;
        String query = "";
        try {
            connection = Utils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            log.info("User created successfully.");
        } catch (SQLException e) {
            log.error("Error while creating the user.", e);
            throw e;
        } finally {
            connection.close();
        }
    }

    public boolean authenticateUser(String username, String password) throws SQLException {
        Connection connection = null;
        String query = "";
        try {
            connection = Utils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {

            }
            log.info("User created successfully.");
        } catch (SQLException e) {
            log.error("Error while creating the user.", e);
            throw e;
        } finally {
            connection.close();
        }
    }
}
