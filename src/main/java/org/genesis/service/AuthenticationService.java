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

package org.genesis.service;

import org.apache.log4j.Logger;
import org.genesis.dao.UserDAO;

import java.sql.SQLException;
import java.text.ParseException;

public class AuthenticationService {

    private final static Logger log = Logger.getLogger(AuthenticationService.class);

    public boolean authenticate(String username, String password) {
        UserDAO userDAO = new UserDAO();
        try {
            return userDAO.authenticateUser(username, password);
        } catch (Exception e) {
            log.error("Error while authenticating the user.", e);
            return false;
        }
    }

    public boolean authenticateWithOpenid(String code) {
        UserDAO userDAO = new UserDAO();
        TokenService tokenService = new TokenService();
        try {
            String username = tokenService.getSubject(code);
            return userDAO.userExist(username);
        } catch (SQLException e) {
            log.error("Error while authenticating the user from ID token.", e);
        } catch (ParseException e) {
            log.error("Error while authenticating the user from ID token.", e);
        }
        return false;
    }
}
