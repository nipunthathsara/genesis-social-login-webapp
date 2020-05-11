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
import org.genesis.Constants;
import org.genesis.Utils;
import org.genesis.dao.UserDAO;
import org.genesis.dto.UserDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class RegistrationService {

    private static final Logger log = Logger.getLogger(RegistrationService.class);

    public boolean registerUser(UserDTO user) {
        boolean error = false;
        UserDAO userDAO = new UserDAO();
        try {
            userDAO.createUser(user);
        } catch (Exception e) {
            log.error("Error while creating the user.", e);
            error = true;
        }
        return error;
    }

    public boolean registerWithOpenid(String code) {
        boolean error = false;
        TokenService tokenService = new TokenService();
        UserDAO userDAO = new UserDAO();
        try {
            UserDTO userDTO = tokenService.getUserClaims(code, Constants.REGISTER_FLOW);
            userDTO.setPassword(Utils.getRandomPassword());
            userDAO.createUser(userDTO);
        } catch (ParseException | SQLException | IOException e) {
            error = true;
            log.error("Error while registering user with Openid.", e);
        }
        return error;
    }
}
