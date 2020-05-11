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
import org.genesis.service.RegistrationService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "callbackServlet",
        urlPatterns = "/callback/*"
)
public class CallbackServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String code = req.getParameter(Constants.AUTHORIZATION_CODE_PARAMETER);
        if (code != null && !code.trim().isEmpty()) {
            AuthenticationService authenticationService = new AuthenticationService();
            RegistrationService registrationService = new RegistrationService();

            // Login service callback
            if ("login".equals(req.getParameter(Constants.FLOW_PARAMETER))) {
                boolean isAuthenticated = authenticationService.authenticateWithOpenid(code);
                resp.setStatus(302);
                if (isAuthenticated) {
                    resp.sendRedirect("index.jsp");
                } else {
                    resp.sendRedirect("login.do");
                }
             // Registration service callback
            } else if ("register".equals(req.getParameter(Constants.FLOW_PARAMETER))) {
                boolean isError = registrationService.registerWithOpenid(code);
                resp.setStatus(302);
                if (!isError) {
                    // If registration is a success, do an auto login.
                    resp.sendRedirect(Constants.AUTHORIZATION_URL + Constants.LOGIN_FLOW);
                } else {
                    resp.sendRedirect("register.do");
                }
            }
        }
    }
}
