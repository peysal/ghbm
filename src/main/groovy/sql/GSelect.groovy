package main.groovy.sql

import groovy.sql.Sql


def sql = Sql.newInstance("jdbc:h2:tcp://localhost/~/development/db/h2/test", "sa", "", "org.h2.Driver")
def rows = sql.rows("select * from BOOK")
assert rows.size() == 0
