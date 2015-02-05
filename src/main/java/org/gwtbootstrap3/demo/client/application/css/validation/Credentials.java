package org.gwtbootstrap3.demo.client.application.css.validation;

/*
 * #%L
 * GwtBootstrap3
 * %%
 * Copyright (C) 2013 - 2015 GwtBootstrap3
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Credentials implements Serializable {

    private static final long serialVersionUID = -1626677647077707091L;

    private String password = null;

    private String username = null;

    /** {@inheritDoc} */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        Credentials other = (Credentials) obj;
        if (password == null) {
            if (other.password != null) { return false; }
        } else if (!password.equals(other.password)) { return false; }
        if (username == null) {
            if (other.username != null) { return false; }
        } else if (!username.equals(other.username)) { return false; }
        return true;
    }

    /**
     * @return the password
     */
    @NotNull
    @Size(min = 4, max = 12)
    public String getPassword() {
        return password;
    }

    /**
     * @return the username
     */
    @NotNull
    public String getUsername() {
        return username;
    }

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (password == null ? 0 : password.hashCode());
        result = prime * result + (username == null ? 0 : username.hashCode());
        return result;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Credentials [username=" + username + ", password=" + password + "]";
    }

}
