- install tomee 9.1.2

- copy ojdbc11 driver in webapp/WEB-INF/lib @ {tomee_dir}/lib

- create uer_tbl & user_rol tables in database

- setup resource in {tomee_dir}/conf/tomee.xml (jta)

        <Resource id = "jdbc/JtaDataSource" type = "javax.sql.DataSource">
        jdbcDriver = oracle.jdbc.driver.OracleDriver
        jdbcUrl = jdbc:oracle:thin:@localhost:1521:xe
        username =
        password = 
        jtaManaged = true
        maxIdle = 20
        minIdle = 5
        maxWait = 10000
        </Resource>
        <Resource id = "jdbc/NonJtaDataSource" type = "javax.sql.DataSource">
        jdbcDriver = oracle.jdbc.driver.OracleDriver
        jdbcUrl = jdbc:oracle:thin:@localhost:1521:xe
        username =
        password = 
        jtaManaged = false
        maxIdle = 20
        minIdle = 5
        maxWait = 10000
        </Resource>

- setup realm in {tomee_dir}/conf/server.xml

       <Realm className="org.apache.catalina.realm.DataSourceRealm"
       dataSourceName="jdbc/JtaDataSource"
       userTable="user_tbl"
       userNameCol="u_username"
       userCredCol="u_password"
       userRoleTable="user_roles"
       roleNameCol="role_name"/>


- create login.jsp 

        <form action="j_security_check">
            <label for="userId">UserName</label>
            <input id="userId" type="text" name="j_username">
            <label for="passId">Password</label>
            <input id="passId" type="password" name="j_password">
            <input type="submit" value="Login">
        </form>

setup web.xml for security constraint

    <security-constraint>
        <web-resource-collection>
            <web-resource-name>Admin</web-resource-name>
            <url-pattern>/jsp/admin/*</url-pattern>
            <http-method>GET</http-method>
            <http-method>POST</http-method>
            <http-method>PUT</http-method>
            <http-method>DELETE</http-method>
        </web-resource-collection>
        <auth-constraint>
            <role-name>admin</role-name>
        </auth-constraint>
    </security-constraint>


    <login-config>
        <auth-method>FORM</auth-method>
        <form-login-config>
            <form-login-page>/login.jsp</form-login-page>
            <form-error-page>/login-error.jsp</form-error-page>
        </form-login-config>
    </login-config>
