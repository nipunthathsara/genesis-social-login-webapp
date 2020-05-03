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

package org.genesis.servlet;

import org.genesis.Constants;
import org.genesis.dto.UserDTO;
import org.genesis.service.RegistrationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "registrationServlet",
        urlPatterns = "/register"
)
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(req.getParameter(Constants.USERNAME));
        userDTO.setPassword(req.getParameter(Constants.PASSWORD));
        userDTO.setEmail(req.getParameter(Constants.EMAIL));
        userDTO.setGender(req.getParameter(Constants.GENDER));
        RegistrationService regService = new RegistrationService();
        boolean error = regService.registerUser(userDTO);
        if (error) {
            resp.setStatus(500);
            resp.sendError(1000, "Error occurred while creating the user");
        } else {
            resp.setStatus(202);
        }
    }
}
