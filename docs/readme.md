- Simple Automation Project 
- Basic lettering with reference capability


- Requirements to run project :
- install tomee 9.1.2

- copy ojdbc11 driver in webapp/WEB-INF/lib @ {tomee_dir}/lib

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


