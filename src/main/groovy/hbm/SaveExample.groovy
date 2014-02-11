package main.groovy.hbm

import main.java.Book


Config config = new Config()
assert config.factory != null

def session = config.factory.currentSession
def tx = session.beginTransaction()

assert session.createQuery("from Book").list().size() == 0

session.save(new Book("peysal", "peysal yg hebat"))

def books = session.createQuery("from Book").list()
assert books.size() > 0
tx.commit()
