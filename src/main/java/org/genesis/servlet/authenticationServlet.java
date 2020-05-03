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
import org.genesis.service.AuthenticationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "authenticationServlet",
        urlPatterns = "/authenticate"
)
public class authenticationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        AuthenticationService authenticationService = new AuthenticationService();
        String username = req.getParameter(Constants.USERNAME);
        String password = req.getParameter(Constants.PASSWORD);
        boolean isAuthenticated = authenticationService.authenticate(username, password);
        if (isAuthenticated) {
            resp.setStatus(200);
        }
        resp.setStatus(401);
    }
}
