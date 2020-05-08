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

package org.genesis;

public class Constants {

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String GENDER = "gender";

    public static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/test";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "root";
    public static final String CREATE_USER_SQL = "INSERT INTO user (USERNAME, PASSWORD, GENDER, EMAIL) VALUES (?, ?, ?, ?)";
    public static final String AUTHENTICATE_SQL = "SELECT * FROM user WHERE USERNAME = ? AND PASSWORD = ?";

    public static final String TOKEN_ENDPOINT_URL = "https://localhost:9443/oauth2/token";
    public static final String REDIRECT_URL = "http://localhost:8080/org.genesis.login/callback";
    public static final String CLIENT_ID = "j5eXqvEaZcpCO23fhsWtMDmzta4a";
    public static final String CLIENT_SECRET = "WMQqNdk5cRxv4SuhKsUKexhVWtca";
    public static final String CLIENT_ID_PARAMETER = "client_id";
    public static final String GRANT_TYPE_PARAMETER = "grant_type";
    public static final String REDIRECT_URI_PARAMETER = "redirect_uri";
    public static final String AUTHORIZATION_CODE_PARAMETER = "code";
    public static final String CODE_GRANT = "authorization_code";

}
