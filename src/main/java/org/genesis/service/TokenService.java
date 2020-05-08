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

import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.genesis.Constants;
import org.genesis.Utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TokenService {

    private static final Logger log = Logger.getLogger(TokenService.class);

    CloseableHttpClient httpClient = HttpClients.createDefault();
    CloseableHttpResponse httpResponse;

    public void getIdToken(String code) {
        try {
            HttpPost request = new HttpPost(Constants.TOKEN_ENDPOINT_URL);
            String authString = Constants.CLIENT_ID + ":" + Constants.CLIENT_SECRET;
            request.addHeader(HttpHeaders.AUTHORIZATION, Utils.base64Encode(authString));
            request.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded;charset=UTF-8");
            List<NameValuePair> parameters = new ArrayList<>();
            parameters.add(new BasicNameValuePair(Constants.CLIENT_ID_PARAMETER, Constants.CLIENT_ID));
            parameters.add(new BasicNameValuePair(Constants.GRANT_TYPE_PARAMETER, Constants.CODE_GRANT));
            parameters.add(new BasicNameValuePair(Constants.REDIRECT_URI_PARAMETER, Constants.REDIRECT_URL));
            parameters.add(new BasicNameValuePair(Constants.AUTHORIZATION_CODE_PARAMETER, code));
            request.setEntity(new UrlEncodedFormEntity(parameters));
            httpResponse = httpClient.execute(request);
            log.info("Response : " + EntityUtils.toString(httpResponse.getEntity()));
        } catch (UnsupportedEncodingException e) {
            log.error("Error while creating the token request.", e);
        } catch (ClientProtocolException e) {
            log.error("Error while sending the token request.", e);
        } catch (IOException e) {
            log.error("Error while sending the token request.", e);
        }
    }
}
